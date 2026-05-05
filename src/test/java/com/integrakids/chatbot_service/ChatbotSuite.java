package com.integrakids.chatbot_service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        ChatBotControllerTest.class,
        ChatBotRestControllerTest.class,
        SDREngineTest.class,
        LeadFlowTest.class
})
public class ChatbotSuite {
}