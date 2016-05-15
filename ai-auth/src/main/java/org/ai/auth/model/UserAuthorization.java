package org.ai.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class UserAuthorization {

    /**
     * whether you are authorzied or not
     */
    @JsonProperty(required = true)
    private boolean authorized;

    /**
     * Login Error Message
     */
    @JsonProperty(required = true)
    private String error;

    private String userFullName;

    /**
     * A tooken with authen credential
     */
    @JsonProperty(required = true)
    private String authToken;
    /**
     * HH:MM
     */
    @JsonProperty(required = true)
    private String sessionExpiredAfter;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.USER_ID
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    @JsonIgnore
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.USER_LOGIN_NAME
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    @JsonProperty(required = true)
    private String userLoginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.PASSWORD
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    @JsonIgnore
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.USER_FIRST_NAME
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    @JsonIgnore
    private String userFirstName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.USER_LAST_NAME
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    @JsonIgnore
    private String userLastName;

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
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.UPDATED_DATE
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    @JsonIgnore
    private Date updatedDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_authorization.CREATED_DATE
     *
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    @JsonIgnore
    private Date createdDate;

    public UserAuthorization() {
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.USER_ID
     *
     * @return the value of user_authorization.USER_ID
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.USER_ID
     *
     * @param userId the value for user_authorization.USER_ID
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
     * This method returns the value of the database column user_authorization.PASSWORD
     *
     * @return the value of user_authorization.PASSWORD
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.PASSWORD
     *
     * @param password the value for user_authorization.PASSWORD
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.USER_FIRST_NAME
     *
     * @return the value of user_authorization.USER_FIRST_NAME
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.USER_FIRST_NAME
     *
     * @param userFirstName the value for user_authorization.USER_FIRST_NAME
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName == null ? null : userFirstName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.USER_LAST_NAME
     *
     * @return the value of user_authorization.USER_LAST_NAME
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.USER_LAST_NAME
     *
     * @param userLastName the value for user_authorization.USER_LAST_NAME
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName == null ? null : userLastName.trim();
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

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.UPDATED_DATE
     *
     * @return the value of user_authorization.UPDATED_DATE
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.UPDATED_DATE
     *
     * @param updatedDate the value for user_authorization.UPDATED_DATE
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_authorization.CREATED_DATE
     *
     * @return the value of user_authorization.CREATED_DATE
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_authorization.CREATED_DATE
     *
     * @param createdDate the value for user_authorization.CREATED_DATE
     * @mbggenerated Mon May 09 15:09:09 CST 2016
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        if (userFullName == null) {
            userFullName = userLastName + " " + userFirstName;
        }
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}