package com.slowcloud.yousummerizer.summary.service;

import com.slowcloud.yousummerizer.summary.dto.YoutubeSummary;
import com.slowcloud.yousummerizer.summary.dto.YoutubeURL;

import java.util.List;

public interface YoutubeSummaryService {
    YoutubeSummary summarize(YoutubeURL youtubeURL);

    List<YoutubeSummary> getSummaryList();

    YoutubeSummary getSummary(YoutubeURL youtubeURL);
}
