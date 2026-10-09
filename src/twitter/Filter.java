/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter consists of methods that filter lists of tweets.
 */
public class Filter {

    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
        List<Tweet> result = new ArrayList<>();

        for (Tweet tweet : tweets) {
            if (tweet.getAuthor().equalsIgnoreCase(username)) {
                result.add(tweet);
            }
        }

        return result;
    }

    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
        List<Tweet> result = new ArrayList<>();

        for (Tweet tweet : tweets) {
            if (!tweet.getTimestamp().isBefore(timespan.getStart())
                    && !tweet.getTimestamp().isAfter(timespan.getEnd())) {
                result.add(tweet);
            }
        }

        return result;
    }

    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
        List<Tweet> result = new ArrayList<>();

        for (Tweet tweet : tweets) {
            if (hasAnyWord(tweet.getText(), words)) {
                result.add(tweet);
            }
        }

        return result;
    }

    private static boolean hasAnyWord(String text, List<String> words) {
        for (String tweetWord : text.split(" ")) {
            for (String word : words) {
                if (!tweetWord.isEmpty()
                        && tweetWord.equalsIgnoreCase(word)) {
                    return true;
                }
            }
        }

        return false;
    }
}