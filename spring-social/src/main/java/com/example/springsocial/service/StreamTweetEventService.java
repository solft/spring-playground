package com.example.springsocial.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.social.twitter.api.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class StreamTweetEventService {

    private final Twitter twitter;

    private Stream userStream;

    public StreamTweetEventService(Twitter twitter) {
        this.twitter = twitter;
    }

    public void streamTweetEvent() {
        List<StreamListener> listeners = new ArrayList<>();

        StreamListener streamListener = new StreamListener() {
            @Override
            public void onTweet(Tweet tweet) {
                log.debug("User '{}', Tweeted : {}, from : {}", tweet.getUser().getName(), tweet.getText(), tweet.getUser().getLocation());
            }

            @Override
            public void onDelete(StreamDeleteEvent deleteEvent) {

            }

            @Override
            public void onLimit(int numberOfLimitedTweets) {

            }

            @Override
            public void onWarning(StreamWarningEvent warningEvent) {

            }
        };


        listeners.add(streamListener);
        userStream = twitter.streamingOperations().filter("lol", listeners);
    }

    public void closeStream() {
        userStream.close();
    }
}
