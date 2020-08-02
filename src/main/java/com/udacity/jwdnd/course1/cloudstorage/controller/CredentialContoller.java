package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/credentialupload")
public class CredentialContoller {

    private CredentialService credentialService;

    public CredentialContoller(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

@GetMapping()
public String credentialsGet()
{
    System.out.println("Inside credentials get()");
    return "home";
}

@PostMapping()
public String postCredentials(@ModelAttribute Credentials credentialdata, Model model)
{
    System.out.println("Inside postCreds method, creds controller ");
    this.credentialService.uploadCredentials(credentialdata.getUrl(), credentialdata.getCredUserName(), credentialdata.getCredPassword(), new String("1234"));
    model.addAttribute("usercredentials", this.credentialService.getCredentials(credentialdata.getCredUserName()));
    return "home";
}

}


//<form action="#" method="POST" th:object="${credentialdata}" th:action="@{/credentialupload}">