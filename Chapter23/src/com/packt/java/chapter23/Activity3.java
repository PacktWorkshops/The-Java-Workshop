package com.packt.java.chapter23;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Activity3 {

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + File.separator +  "res/database.csv";
        List<Member> members = parseMembers(filePath);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long bubbleSortStart = System.nanoTime();
        Future<List<Member>> bubbleSort = executorService.submit(new BubbleSortMemberAge(members));
        try {
            bubbleSort.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Duration bubbleSortDuration = Duration.of(System.nanoTime() - bubbleSortStart, ChronoUnit.NANOS);
        System.out.println(String.format("BubbleSort: %02dm:%02ds:%02dms", bubbleSortDuration.toMinutes(), bubbleSortDuration.toSeconds(), bubbleSortDuration.toMillis()));
        try {
            List<Member> sortedMembers = bubbleSort.get();
            printMembers(sortedMembers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long mergeSortStart = System.nanoTime();
        List<Member> mergeSort = forkJoinPool.invoke(new MergeSortMemberAge(members));
        Duration mergeSortDuration = Duration.of(System.nanoTime() - mergeSortStart, ChronoUnit.NANOS);
        System.out.println(String.format("MergeSort: %02dm:%02ds:%02dms", mergeSortDuration.toMinutes(), mergeSortDuration.toSeconds(), mergeSortDuration.toMillis()));
        printMembers(mergeSort);
    }

    private static List<Member> parseMembers(String filePath) {
        try (Stream<String> authors = Files.lines(Paths.get(filePath))) {
            return authors.skip(1).map(Member::new).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void printMembers(List<Member> members) {
        for (int i = 0; i < 10; i++) {
            Member member = members.get(i);
            printMember(member);
        }
    }

    private static void printMember(Member member) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(member.firstName).append(" ").append(member.lastName).append(" is ");
        stringBuilder.append(member.age).append(" years. Works as ").append(member.title).append(" and earns ");
        stringBuilder.append(member.salary).append(" Java-$");

        System.out.println(stringBuilder.toString());
    }
}
