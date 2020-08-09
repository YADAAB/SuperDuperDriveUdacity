package com.udacity.jwdnd.course1.cloudstorage.DBmapper;


import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;

import java.util.List;


@Mapper
    public interface CredentialMapper {
        @Select("SELECT * FROM CREDENTIALS WHERE userId = #{userId}")
        List<Credentials> getCredentials(Integer userId);


        @Insert("INSERT INTO CREDENTIALS (url, credusername, key, credpassword, userid) VALUES(#{url}, #{credUserName}, #{key}, #{credPassword}, #{userId})")
        @Options(useGeneratedKeys = true, keyProperty = "credentialId")
        int insertCredentials(Credentials credentials);

        @Delete("DELETE from CREDENTIALS where credentialId = #{credentialId}")
        int deleteCredentials(Integer credentialId);

        @Update("update CREDENTIALS set url=#{url}, credusername=#{credUserName}, credPassword=#{credPassword} where credentialId=#{credentialId}")
        int updateCredentials(Credentials credential);
    }
