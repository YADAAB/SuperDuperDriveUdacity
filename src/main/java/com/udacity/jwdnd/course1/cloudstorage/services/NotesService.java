package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.DBmapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.DBmapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.DBmapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    private final NotesMapper notesMapper;
    private final UserMapper userMapper;
    //private Users user;

    public NotesService(NotesMapper notesMapper, UserMapper userMapper) {
        this.notesMapper = notesMapper;
        this.userMapper = userMapper;
        //this.user = user;
    }

    public int insertNotes(String noteTitle, String noteDescription)
    {

        //System.out.println("Inside insertNotes "+AuthPrincipal.getAuthUser());
        return notesMapper.insertNotes(new Notes(null, noteTitle, noteDescription, new Integer(1)));
        //Integer.parseInt(AuthPrincipal.getAuthUser()["userid"])
    }


    public List<Notes> getNotes(Integer userId) {
        System.out.println("Inside getNotes "+userId);
        return notesMapper.getNotes(userId);
    }

    public int deleteNote(Integer noteId) {
        return notesMapper.deleteNotes(noteId);
    }

    public int editNote(Notes note) {
        return notesMapper.updateNotes(note);
    }
}
