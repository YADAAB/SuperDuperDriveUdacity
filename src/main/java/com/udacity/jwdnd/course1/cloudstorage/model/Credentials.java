package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credentials {

    private Integer credentialId;
    private String url;
    private String credUserName;
    private String key;
    private String credPassword;
    private Integer userId;
//new Credentials(null, url, credUserName, hashedPassword, userId)
    public Credentials(Integer credentialId, String url, String credUserName, String key, String credPassword, Integer userId) {
        System.out.println("Inside Credentials Const..");
        this.credentialId = credentialId;
        this.url = url;
        this.credUserName = credUserName;
        this.key = key;
        this.credPassword = credPassword;
        this.userId = userId;
    }

    /*
    credentialid
    url VARCHAR(100),
    username VARCHAR (30),
    key VARCHAR,
    password VARCHAR,
    userid INT,
    * */


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCredUserName() {
        return credUserName;
    }

    public void setCredUserName(String credUserName) {
        this.credUserName = credUserName;
    }

    public String getCredPassword() {
        return credPassword;
    }

    public void setCredPassword(String credPassword) {
        this.credPassword = credPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



}