package com.boluo.langchain4jboluoai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,
//        chatModel = "qwenChatModel",
        streamingChatModel = "qwenStreamingChatModel",
        chatMemoryProvider = "chatMemoryProviderBoluo",
        tools = {"appointmentTools","baiDuMapTools"},
        contentRetriever = "contentRetrieverBoLuo")
public interface BoLuoAgent {

//    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
//    String chat(@V("MemoryId") Long memoryId,@V("UserMessage") String userMessage);


    /**
     * 流式响应
     * @param memoryId
     * @param userMessage
     * @return
     */
    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
