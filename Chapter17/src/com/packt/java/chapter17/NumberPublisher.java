package com.packt.java.chapter17;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Supplier;

public class NumberPublisher extends SubmissionPublisher<String> {

    final Timer timer = new Timer();
    final TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            try {
                submit(supplier.get());
            } catch (Exception e) {
                closeExceptionally(e);
            }
        }
    };
    final Supplier<String> supplier;

    public NumberPublisher(Supplier<String> supplier) {
        this.supplier = supplier;
        this.timer.schedule(timerTask, 1000, 1000);
    }

    @Override
    public void close() {
        timer.cancel();
        super.close();
    }
}
