package org.ai.sso.model;

import java.util.Date;

public class UserAuthorization {

    /**
     * whether you are authorzied or not
     */
    private boolean authorized;

    /**
     * Login Error Message
     */
    private String error;

    private String userFullName;

    /**
     * A tooken with authen credential
     */
    private String authToken;
    /**
     * HH:MM
     */
    private String sessionExpiredAfter;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.USER_LOGIN_NAME
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    private String userLoginName;


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.LAST_LOGIN
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    private Date lastLogin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.LAST_LOGIN_IP
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    private String lastLoginIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.LAST_LOGIN_SYSTEM
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    private String lastLoginSystem;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.USER_LOGIN_NAME
     *
     * @return the value of user_authorization.USER_LOGIN_NAME
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public String getUserLoginName() {
        return userLoginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.USER_LOGIN_NAME
     *
     * @param userLoginName the value for user_authorization.USER_LOGIN_NAME
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.LAST_LOGIN
     *
     * @return the value of user_authorization.LAST_LOGIN
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.LAST_LOGIN
     *
     * @param lastLogin the value for user_authorization.LAST_LOGIN
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.LAST_LOGIN_IP
     *
     * @return the value of user_authorization.LAST_LOGIN_IP
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.LAST_LOGIN_IP
     *
     * @param lastLoginIp the value for user_authorization.LAST_LOGIN_IP
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.LAST_LOGIN_SYSTEM
     *
     * @return the value of user_authorization.LAST_LOGIN_SYSTEM
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public String getLastLoginSystem() {
        return lastLoginSystem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.LAST_LOGIN_SYSTEM
     *
     * @param lastLoginSystem the value for user_authorization.LAST_LOGIN_SYSTEM
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setLastLoginSystem(String lastLoginSystem) {
        this.lastLoginSystem = lastLoginSystem == null ? null : lastLoginSystem.trim();
    }


    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getSessionExpiredAfter() {
        return sessionExpiredAfter;
    }

    public void setSessionExpiredAfter(String sessionExpiredAfter) {
        this.sessionExpiredAfter = sessionExpiredAfter;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}