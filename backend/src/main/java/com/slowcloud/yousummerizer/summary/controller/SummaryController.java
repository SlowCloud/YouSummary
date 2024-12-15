package com.slowcloud.yousummerizer.summary.controller;

import com.slowcloud.yousummerizer.summary.dto.YoutubeSummaryCreateRequest;
import com.slowcloud.yousummerizer.summary.dto.YoutubeSummaryCreateResponse;
import com.slowcloud.yousummerizer.summary.dto.YoutubeSummaryGetResponse;
import com.slowcloud.yousummerizer.summary.service.YoutubeSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SummaryController {

    private final YoutubeSummaryService youtubeSummaryService;

    @PostMapping("summarize")
    public ResponseEntity<YoutubeSummaryCreateResponse> createYoutubeSummary(YoutubeSummaryCreateRequest url) {
        return null;
    }

    @GetMapping("list")
    public ResponseEntity<YoutubeSummaryGetResponse> getYoutubeSummaryList() {
        return null;
    }

}
