package com.github.mangila.ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    private final ChatClient chatClient;

    public ConversationService(@Value("classpath:/prompts/t800.st") Resource resource,
                               ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem(resource)
                .build();
    }

    public void call() {
        var l = chatClient.prompt(new Prompt("Hello?"))
                .call();
        System.out.println(l.content());
    }
}
