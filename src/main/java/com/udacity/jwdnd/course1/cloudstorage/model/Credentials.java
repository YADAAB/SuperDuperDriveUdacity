package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credentials {

    private Integer credentialId;
    private String url;
    private String credUserName;
    private String credPassword;
    private String userId;

    public Credentials(Integer credentialId, String url, String credUserName, String credPassword, String userId) {
        this.credentialId = credentialId;
        this.url = url;
        this.credUserName = credUserName;
        this.credPassword = credPassword;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



}

/*
*
CREATE TABLE IF NOT EXISTS CREDENTIALS (
    credentialid INT PRIMARY KEY auto_increment,
    url VARCHAR(100),
    username VARCHAR (30),
    key VARCHAR,
    password VARCHAR,
    userid INT,
    foreign key (userid) references USERS(userid)
);
* */