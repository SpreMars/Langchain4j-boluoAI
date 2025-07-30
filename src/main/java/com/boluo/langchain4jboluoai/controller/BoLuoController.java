package com.boluo.langchain4jboluoai.controller;

import com.boluo.langchain4jboluoai.assistant.BoLuoAgent;
import com.boluo.langchain4jboluoai.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Tag(name = "BoluoAi")
@RestController
@RequestMapping("/boluo")
public class BoLuoController {

    @Autowired
    private BoLuoAgent boluoAgent;

    //    @Operation(summary = "对话")
//    @PostMapping(value = "/chat",  produces = "text/stream;charset=utf-8")
//    public String chat(@RequestBody ChatForm chatForm)
//    {
//        return boluoAgent.chat(chatForm.getMemoryId(),chatForm.getUserMessage());
//    }
    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm) {
        return boluoAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }

}
