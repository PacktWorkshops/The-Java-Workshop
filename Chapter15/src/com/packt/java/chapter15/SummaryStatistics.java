package com.packt.java.chapter15;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SummaryStatistics {

    public static void main(String[] args) {

        IntSummaryStatistics intStats = IntStream.of(7, 9, 3, 4, 1).summaryStatistics();
        System.out.println(intStats);

        LongSummaryStatistics longStats = LongStream.of(6L, 4L, 1L, 3L, 7L).summaryStatistics();
        System.out.println(longStats);

        DoubleSummaryStatistics doubleStats = DoubleStream.of(4.3, 5.1, 9.4, 1.3, 3.9).summaryStatistics();
        System.out.println(doubleStats);

    }

}
