package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.DBmapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/home")
public class CredentialContoller {

    private CredentialService credentialService;
    private UserMapper userMapper;

    public CredentialContoller(CredentialService credentialService, UserMapper userMapper) {
        this.credentialService = credentialService;
        this.userMapper = userMapper;
    }


@GetMapping("/home")
public String credentialsGet(Model model)
{
    System.out.println("Inside credentials get()");
    return "home";
}

@PostMapping("/home")
public String postCredentials(Authentication auth, @ModelAttribute Credentials credentialdata, Model model)
{
    System.out.println("(String) auth.getPrincipal() "+userMapper.getUserName((String) auth.getPrincipal()).getUserId());
    this.credentialService.uploadCredentials(credentialdata.getUrl(), credentialdata.getCredUserName(), credentialdata.getCredPassword(), (String) auth.getPrincipal());
    model.addAttribute("usercredentials", this.credentialService.getCredentials(userMapper.getUserName((String) auth.getPrincipal()).getUserId()));
    return "home";
}

@GetMapping("/credential/delete/{credentialId}")
public String deleteCredential(@PathVariable("credentialId") Integer credentialId, Model model)
{
    System.out.println("Inside controller deleteCredential - "+credentialId);
    this.credentialService.deleteCredential(credentialId);
    return "home";
}

@PostMapping("/credentialUpdateToEdit")
public String updateEditCredential(Authentication auth, @ModelAttribute Credentials credentialdata, Model model)
{
    System.out.println("Inside update edit cred, userId "+(String) auth.getPrincipal());
    credentialdata.setUserId(userMapper.getUserName((String) auth.getPrincipal()).getUserId());
    //model.addAttribute("userCredentialToUpdate", credentialdata);
    return "credentialUpdate";
}

    @PostMapping("/credentialUpdate")
    public String editCredential(@ModelAttribute Credentials credentialdata, Model model)
    {
        System.out.println("Inside editCredential  "+credentialdata.getCredUserName());
        this.credentialService.editCredentials(credentialdata);
        //credentialdata.setUserId(userMapper.getUserName((String) auth.getPrincipal()).getUserId());
        //model.addAttribute("userCredentialToUpdate", credentialdata);
        return "home";
    }
}



/*
    @GetMapping(value = "/delete_credential")
    public String handleDeleteCredential(@RequestParam(name="credentialId") String credentialId) {
        System.out.println("handleDeleteCredential "+credentialId);
        this.credentialService.deleteCredential(Integer.valueOf(credentialId));
        return "home";
    }
*/
