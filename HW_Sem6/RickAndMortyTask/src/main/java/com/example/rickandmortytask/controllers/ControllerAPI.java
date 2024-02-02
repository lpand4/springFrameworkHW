package com.example.rickandmortytask.controllers;

import com.example.rickandmortytask.domain.Characters;
import com.example.rickandmortytask.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/")
    public String getCharacters(Model m)
    {
        Characters allCharacters = serviceApi.getAllCharacters();
//        int size = allCharacters.getResults().size();
//        Characters firstPart = new Characters();
//        Characters secondPart = new Characters();
//        firstPart.setResults(allCharacters.getResults().subList(0,size/2));
//        secondPart.setResults(allCharacters.getResults().subList(size/2 + 1,size));
//        Characters[] allChar = new Characters[]{firstPart,secondPart};
        m.addAttribute("characters", allCharacters);
        return "rickandmorty";
    }
}