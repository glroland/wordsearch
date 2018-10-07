package com.glroland.wordsearch.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glroland.wordsearch.game.GameFactory;
import com.glroland.wordsearch.model.Game;

@RestController
public class WordSearchController {

    @RequestMapping("/")
    public String index() {
        return "Word Search!";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/generate")
    public Game generate(int width, int height)
    {
    	return GameFactory.generate(width, height);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/generate")
    public Game generate()
    {
    	return GameFactory.generate();
    }
}
