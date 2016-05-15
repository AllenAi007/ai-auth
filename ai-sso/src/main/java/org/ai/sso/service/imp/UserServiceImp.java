package org.ai.sso.service.imp;

import org.ai.sso.dao.UserAuthorizationMapper;
import org.ai.sso.exception.LoginFailedException;
import org.ai.sso.model.UserAuthorization;
import org.ai.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by hua.ai on 2016/5/9.
 */
@Transactional
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserAuthorizationMapper userAuthorizationMapper;

    @Transactional(readOnly = true)
    @Override
    public UserAuthorization doAuthenticate(String userLoginName, String password) throws LoginFailedException {
        if (StringUtils.isEmpty(userLoginName) || StringUtils.isEmpty(password)) {
            throw new LoginFailedException("Empty username or password is given");
        }

        UserAuthorization userAuthorization = userAuthorizationMapper.selectByLoginName(userLoginName);
        if (userAuthorization == null) {
            throw new LoginFailedException("User " + userLoginName + " does not exist");
        }
        if (!password.equals(userAuthorization.getPassword())) {
            throw new LoginFailedException("Wrong password given for user " + userLoginName);
        }

        return userAuthorization;
    }

    @Transactional(readOnly = true)
    @Override
    public UserAuthorization doAuthenticate(String userLoginName, String password, String system) throws LoginFailedException {
        return doAuthenticate(userLoginName, password);
    }

}
