package com.sample.chat.controller;

import com.sample.chat.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 5:54
 */
@Controller
@RequestMapping("/chat")
public class ChatController{
    private final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public String chatWorld() {
        logger.info("챗?");
        return "index";
    }


}
