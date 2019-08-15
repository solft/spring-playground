package com.example.springsocial.controller;

import com.example.springsocial.service.StreamTweetEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SearchController {

    private StreamTweetEventService streamTweetEventService;

    public SearchController(StreamTweetEventService streamTweetEventService) {
        this.streamTweetEventService = streamTweetEventService;
    }

    @GetMapping("/tweet")
    public String searchTwitter() {
        log.debug("START");

        streamTweetEventService.streamTweetEvent();

        return "start";
    }

    @GetMapping("/stop")
    public String stopTwitter() {
        log.debug("STOP");

        streamTweetEventService.closeStream();

        return "stop";
    }
}
