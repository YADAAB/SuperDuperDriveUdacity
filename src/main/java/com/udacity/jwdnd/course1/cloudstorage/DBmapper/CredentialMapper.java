package com.udacity.jwdnd.course1.cloudstorage.DBmapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;

import java.util.List;


@Mapper
    public interface CredentialMapper {
        @Select("SELECT * FROM CREDENTIALS WHERE username = #{username}")
        List<Credentials> getCredentials(String username);


        @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) VALUES(#{url}, #{username}, #{key}, #{password}, #{userid})")
        @Options(useGeneratedKeys = true, keyProperty = "userid")
        int insertCredentials(Credentials credentials);

    }
