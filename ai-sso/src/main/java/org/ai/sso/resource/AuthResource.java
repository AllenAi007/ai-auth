package org.ai.sso.resource;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.ai.sso.model.UserAuthorization;
import org.ai.sso.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Resource for doAuthorize
 */
@Path("")
@Service
public class AuthResource {

    public static Cache<String, UserAuthorization> USER_AUTHORIZATION_CACHE;

    @Value("${sso.sessionExpiredAfter}")
    private String sessionExpireAfter;

    @Value("${sso.maximumSize:1000}")
    private int maximumSize;

    public AuthResource() {
        USER_AUTHORIZATION_CACHE = CacheBuilder.newBuilder().
                maximumSize(maximumSize).
                expireAfterWrite(5, TimeUnit.MINUTES).
                build();
    }

    @Autowired
    private UserService userService;


    /**
     * @param userLoginId
     * @param password
     * @return
     */
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public UserAuthorization login(@QueryParam("userLoginId") String userLoginId, @QueryParam("password") String password) {
        try {
            UserAuthorization userAuthorization = userService.doAuthenticate(userLoginId, password);
            if (userAuthorization != null) {
                userAuthorization.setAuthorized(true);
                String authToken = UUID.randomUUID().toString();
                userAuthorization.setAuthToken(authToken);
                userAuthorization.setSessionExpiredAfter(sessionExpireAfter);
                USER_AUTHORIZATION_CACHE.put(userLoginId, userAuthorization);
            }
            return userAuthorization;
        } catch (Exception e) {
            return createFailedUserAuthorization(e.getMessage());
        }
    }


    /**
     * /verify?userLoginId=%s&challenge=%s&hash=%s
     *
     * @param userLoginId
     * @param challenge   base64 encrypt string
     * @param hash        (token + challenge) sha1 base64 encrypt str
     * @return
     */
    @GET
    @Path("verify")
    @Produces(MediaType.APPLICATION_JSON)
    public UserAuthorization verify(@QueryParam("userLoginId") String userLoginId, @QueryParam("challenge") String challenge, @QueryParam("hash") String hash) {
        try {
            if (StringUtils.isBlank(userLoginId) || StringUtils.isBlank(challenge) || StringUtils.isBlank(hash)) {
                return createFailedUserAuthorization("Empty sso token provided");
            }
            UserAuthorization userAuthorization = USER_AUTHORIZATION_CACHE.getIfPresent(userLoginId);
            if (userAuthorization == null || StringUtils.isBlank(userAuthorization.getAuthToken())) {
                return createFailedUserAuthorization("No sso token find for given user " + userLoginId);
            }
            String srcChallenge = new String(Base64.decodeBase64(challenge), "UTF-8");
            String shaHash = new String(Base64.decodeBase64(hash), "UTF-8");
            String userToken = userAuthorization.getAuthToken();
            if (DigestUtils.sha1Hex(userToken + srcChallenge).equals(shaHash)) {
                return userAuthorization;
            } else {
                return createFailedUserAuthorization("Wrong sso token given");
            }
        } catch (Exception e) {
            return createFailedUserAuthorization(e.getMessage());
        }
    }


    /**
     * Create Login failed UserAuthorization
     *
     * @param errorMessage
     * @return
     */
    private UserAuthorization createFailedUserAuthorization(String errorMessage) {
        UserAuthorization userAuthorization = new UserAuthorization();
        userAuthorization.setAuthorized(false);
        userAuthorization.setError(errorMessage);
        return userAuthorization;
    }

}
