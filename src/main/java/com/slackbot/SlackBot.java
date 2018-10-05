package com.slackbot;

import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class SlackBot extends Bot {

    @Value("${slackBotToken}")
    private String slackToken;

    @Override
    public String getSlackToken() {
        return slackToken;
    }

    @Override
    public Bot getSlackBot() {
        return this;
    }
    
    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
    public void onReceive(WebSocketSession session, Event event) {
        if (event.getText().toLowerCase().contains("hbo")) {
            reply(session, event, new Message("HBO processed 45454 today"));
            return;
        }
        if (event.getText().toLowerCase().contains("fox")) {
            reply(session, event, new Message("FOX processed 34321 today"));
            return;
        }
        reply(session, event, new Message("Hi, the following keywords are supported\nhbo\nfox"));
    }
    
}
