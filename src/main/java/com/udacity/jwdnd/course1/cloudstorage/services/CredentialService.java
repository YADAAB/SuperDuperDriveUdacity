package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.DBmapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.DBmapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialService {

    private final HashService hashService;
    private final CredentialMapper credentialMapper;
    private final UserMapper userMapper;
    private Users user;


    public CredentialService(CredentialMapper credentialMapper, HashService hashService, UserMapper userMapper) {
        this.credentialMapper = credentialMapper;
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public int uploadCredentials(String url, String credUserName, String credPassword, String username){
        System.out.println("Inside upload Credentials Service() ");
        user = userMapper.getUserName(username);
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        //HashService hashService;
        String hashedPassword = this.hashService.getHashedValue(credPassword, encodedSalt);
        System.out.println("userId "+userMapper.getUserName(username).getUserId());
        return credentialMapper.insertCredentials(new Credentials(null, url, credUserName, new String("key-1234"), hashedPassword, userMapper.getUserName(username).getUserId()));
        //return credentialMapper.insertCredentials(new Credentials(null, url, credUserName, new String("key-1234"),hashedPassword,userMapper.getUserName(username).getUserId()));
    }



    public List<Credentials> getCredentials(Integer userId)
    {
        //System.out.println("getCredentials "+credentialMapper.getCredentials(userId));
        return credentialMapper.getCredentials(userId);
    }

    public Integer deleteCredential(Integer id) {
        System.out.println("Inside cred Service deleteCredential "+id);
        return credentialMapper.deleteCredentials(id);
    }

    public int editCredentials(Credentials credentialdata) {
        System.out.println("Inside cred Service deleteCredential "+credentialdata.getUserId());
        return credentialMapper.updateCredentials(credentialdata);
    }
}