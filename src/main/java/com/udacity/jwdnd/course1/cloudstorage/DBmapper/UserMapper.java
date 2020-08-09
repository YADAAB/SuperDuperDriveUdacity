
package com.udacity.jwdnd.course1.cloudstorage.DBmapper;

       import com.udacity.jwdnd.course1.cloudstorage.model.Users;
       import org.apache.catalina.User;
       import org.apache.ibatis.annotations.Insert;
        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Options;
        import org.apache.ibatis.annotations.Select;
        import org.springframework.context.annotation.Bean;
        import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
        import java.util.List;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE userid = #{userId}")
    Users getUserId(Integer userId);

    @Select("SELECT * FROM USERS WHERE username = #{userName}")
    Users getUserName(String userName);



    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{userName}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(Users user);

}
/*
    private Integer userId;
    private String userName;
    private String salt;
    private String firstName;
    private String lastName;
* */
