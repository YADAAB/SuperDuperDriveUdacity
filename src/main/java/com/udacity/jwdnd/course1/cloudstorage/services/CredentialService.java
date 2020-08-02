package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.DBmapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialService {

    private final HashService hashService;
    private final CredentialMapper credentialMapper;

    public CredentialService(CredentialMapper credentialMapper, HashService hashService) {
        this.credentialMapper = credentialMapper;
        this.hashService = hashService;
    }

    public int uploadCredentials(String url, String credUserName, String credPassword, String userId){
        System.out.println("Inside upload Credentials Service() ");
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        HashService hashService;
        String hashedPassword = this.hashService.getHashedValue(credPassword, encodedSalt);
        return credentialMapper.insertCredentials(new Credentials(null, url, credUserName, hashedPassword, userId));
    }

    public List<Credentials> getCredentials(String userid)
    {
        return credentialMapper.getCredentials(userid);
    }
}