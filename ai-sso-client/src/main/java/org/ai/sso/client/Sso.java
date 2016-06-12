package org.ai.sso.client;

import org.ai.sso.model.UserAuthorization;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * Created by hua.ai on 2016/5/15.
 */
public class Sso {

    // cookie keys
    public static String COOKIE_KEY_SappUserLoginId = "SappUserLoginId";
    public static String COOKIE_KEY_SappUserName = "SappUserName";
    public static String COOKIE_KEY_SappChallenge = "SappChallenge";
    public static String COOKIE_KEY_SappHash = "SappHash";

    private String challenge;
    private String hash;
    private String userLoginId;
    private UserAuthorization userAuthorization;

    public Sso(UserAuthorization userAuthorization) {
        String loginToken = userAuthorization.getAuthToken();
        this.challenge = UUID.randomUUID().toString();
        this.hash = loginToken + challenge;
        // encryptHash
        encryptHash();
        // encryptChallenge
        encryptChallenge();
    }

    /**
     * Hash = auth_token + challenge,
     * first sha1
     * second base64
     */
    protected void encryptHash() {
        // sha1 base64
        this.hash = Base64.encodeBase64String(DigestUtils.sha1Hex(hash.getBytes()).getBytes());
    }

    /**
     * Challenge Base64
     */
    protected void encryptChallenge() {
        this.challenge = Base64.encodeBase64String(this.challenge.getBytes());
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public UserAuthorization getUserAuthorization() {
        return userAuthorization;
    }

    public void setUserAuthorization(UserAuthorization userAuthorization) {
        this.userAuthorization = userAuthorization;
    }
}
