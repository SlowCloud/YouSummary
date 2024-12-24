package com.slowcloud.yousummerizer.summary.util;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface YoutubeSummarizer {
    // TODO: load instruction here
    @SystemMessage("you are a polite assistant.")
    String summarize(String caption);
}
