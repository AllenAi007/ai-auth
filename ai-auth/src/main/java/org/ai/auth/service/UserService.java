package org.ai.auth.service;

import org.ai.auth.exception.LoginFailedException;
import org.ai.auth.model.UserAuthorization;

/**
 * Created by hua.ai on 2016/5/9.
 */
public interface UserService {

    /**
     *
     * Do authenticate
     *
     * @param userLoginName
     * @param password
     * @return
     * @throws LoginFailedException wrong user name or password given
     */
    public UserAuthorization doAuthenticate(String userLoginName, String password) throws LoginFailedException;

    /**
     *
     * @param userLoginName
     * @param password
     * @param system
     * @return
     * @throws LoginFailedException
     */
    public UserAuthorization doAuthenticate(String userLoginName, String password, String system) throws LoginFailedException;


}
