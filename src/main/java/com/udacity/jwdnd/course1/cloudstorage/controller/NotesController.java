package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.DBmapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotesController {

    private NotesService notesService;
    private UserMapper userMapper;

    public NotesController(NotesService notesService, UserMapper userMapper) {
        this.notesService = notesService;
        this.userMapper = userMapper;
    }

    @GetMapping("/notes")
    public String notesGet(Authentication auth,Model model)
    {
        System.out.println("Inside Notes get()");
        model.addAttribute("notes", this.notesService.getNotes(userMapper.getUserName((String) auth.getPrincipal()).getUserId()));
        return "home";
    }

    @PostMapping("/notes")
    public String postNotes(Authentication auth, @ModelAttribute Notes notes, Model model)
    {
        System.out.println("(String) auth.getPrincipal() "+userMapper.getUserName((String) auth.getPrincipal()).getUserId());
        this.notesService.insertNotes(notes.getNoteTitle(), notes.getNoteDescription());
        model.addAttribute("notes", this.notesService.getNotes(userMapper.getUserName((String) auth.getPrincipal()).getUserId()));
        return "home";
    }


    @GetMapping("/note/delete/{noteId}")
    public String deleteCredential(@PathVariable("noteId") Integer noteId, Model model)
    {
        System.out.println("Inside controller deleteNote - "+noteId);
        this.notesService.deleteNote(noteId);
        return "home";
        //return "redirect:home#nav-credentials";
    }

    @PostMapping("/noteUpdateToEdit")
    public String updateEditNote(Authentication auth, @ModelAttribute Notes note, Model model)
    {
        System.out.println("Inside update edit cred, userId "+(String) auth.getPrincipal());
        note.setUserId(userMapper.getUserName((String) auth.getPrincipal()).getUserId());
        return "noteUpdate";
        //return "redirect:home#nav-credentials";

    }

    @PostMapping("/noteUpdate")
    public String editCredential(Model model, @ModelAttribute Notes note)
    {
        System.out.println("Inside editNotes - "+note.getNoteTitle());
        this.notesService.editNote(note);
        return "home";
    }
}

/*
*    @PostMapping("/credentialUpdate")
    public String editCredential(@ModelAttribute Credentials credentialdata, Model model)
    {
        System.out.println("Inside editCredential  "+credentialdata.getCredUserName());
        this.credentialService.editCredentials(credentialdata);
        return "home";
    }

* */