package com.udacity.jwdnd.course1.cloudstorage.DBmapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotesMapper {

    @Select("SELECT * FROM NOTES WHERE userId = #{userId}")
    List<Notes> getNotes(Integer userId);

    @Insert("INSERT INTO NOTES (noteTitle, noteDescription, userId) VALUES(#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNotes(Notes notes);

    @Delete("DELETE from NOTES where noteId = #{noteId}")
    int deleteNotes(Integer noteId);

    @Update("update NOTES set noteDescription=#{noteDescription}, noteTitle=#{noteTitle} where noteId=#{noteId}")
    int updateNotes(Notes notes);

}