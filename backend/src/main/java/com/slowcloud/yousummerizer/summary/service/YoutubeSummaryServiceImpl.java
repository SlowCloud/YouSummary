package com.slowcloud.yousummerizer.summary.service;

import com.google.api.services.youtube.YouTube;
import com.slowcloud.yousummerizer.summary.dto.YoutubeSummary;
import com.slowcloud.yousummerizer.summary.dto.YoutubeURL;
import com.slowcloud.yousummerizer.summary.util.YoutubeSummarizer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class YoutubeSummaryServiceImpl implements YoutubeSummaryService {

    private final YoutubeSummarizer youtubeSummarizer;

    @Override
    public YoutubeSummary summarize(YoutubeURL youtubeURL) {

        // TODO: load youtube caption from youtubeUrl.
        String caption = null;

//        YouTube youtube = new YouTube.Builder().build();

        return new YoutubeSummary(youtubeURL.url(), youtubeSummarizer.summarize(caption));
    }

    @Override
    public List<YoutubeSummary> getSummaryList() {
        return List.of();
    }

    @Override
    public YoutubeSummary getSummary(YoutubeURL youtubeURL) {
        return null;
    }
}
