package com.packt.java.chapter17;

import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class MyPublisher extends SubmissionPublisher<String> {

    public MyPublisher() {
        super(Executors.newFixedThreadPool(1), Flow.defaultBufferSize());
    }
}
