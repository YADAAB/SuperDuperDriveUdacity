package com.udacity.jwdnd.course1.cloudstorage.services;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.udacity.jwdnd.course1.cloudstorage.DBmapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

//@Service
public class AuthPrincipal {

    private static UserMapper userMapper;
    private static Authentication auth;
    private static Map<String, String> authdata = new HashMap<String, String>();

    public AuthPrincipal(UserMapper userMapper, Authentication auth) {
        this.userMapper = userMapper;
        this.auth = auth;
    }


    public static Map<String, String> getAuthUser()
    {
        System.out.println("Inside getAuthUser "+(String) auth.getPrincipal());
                //+ " and id - "+(String) userMapper.getUserName((String) auth.getPrincipal()).getUserId());
        authdata.put("username", (String) auth.getPrincipal());
        authdata.put("userid", Integer.toString(userMapper.getUserName  ((String) auth.getPrincipal()).getUserId()));
        return authdata;
    }
}
