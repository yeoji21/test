package com.example.answer.week4.hw1;

import java.util.HashMap;
import java.util.Map;

public class Participant {
    String username;
    Map<Integer, Boolean> homeworkResult;

    public Participant(String username) {
        this.username = username;
        homeworkResult = new HashMap<>();
    }

    public double getRate(double total) {
        long count = homeworkResult.values().stream().filter(value -> value).count();
        return count * 100 / total;
    }

    public void markHomeworkIsDone(int index) {
        this.homeworkResult.put(index, true);
    }
}
