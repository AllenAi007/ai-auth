package org.ai.auth.resource;

import org.ai.auth.exception.LoginFailedException;
import org.ai.auth.model.UserAuthorization;
import org.ai.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Resource for doAuthorize
 */
@Path("doAuthorize")
public class AuthorizationResource {

    @Autowired
    private UserService userService;


    /**
     * Do authorization
     * @param userName user name
     * @param password password
     * @return
     * @throws LoginFailedException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserAuthorization get(@QueryParam("userName") String userName, @QueryParam("password") String password) throws LoginFailedException {
        return userService.doAuthenticate(userName, password);
    }
}
