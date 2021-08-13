package com.example.answer.week4.hw1;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();
        app.printBoard();
    }

    private void printBoard() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");

        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            GHIssue issue = repository.getIssue(i);
            List<GHIssueComment> comments = issue.getComments();

            for (GHIssueComment comment : comments) {
                Participant participant = findParticipant(participants, comment.getUserName());
                participant.markHomeworkIsDone(i);
            }
        }

        participants.sort(Comparator.comparing(p -> p.username));
        participants.forEach( p -> {
            System.out.printf("| %s %s | %.2f%% |\n", p.username, checkMark(p), p.getRate(15));
        });
    }

    private String checkMark(Participant p) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if (p.homeworkResult.containsKey(i) && p.homeworkResult.get(i)) {
                result.append("|:white_check_mark:");
            }else {
                result.append("|");
            }
        }
        return result.toString();
    }

    private Participant findParticipant(List<Participant> participants, String userName) {
        if (isNewUser(participants, userName)) {
            Participant participant = new Participant(userName);
            participants.add(participant);
            return participant;
        }else {
            Optional<Participant> first = participants.stream().filter(p -> p.username.equals(userName)).findFirst();
            return first.orElseThrow();
        }
    }

    private boolean isNewUser(List<Participant> participants, String userName) {
        return participants.stream().noneMatch(p -> p.username.equals(userName));
    }
}
