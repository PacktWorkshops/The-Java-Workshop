package com.packt.java.chapter17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Flow;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Activity1 {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            int index;
            @Override
            public String get() {
                String[] data = getStrings();
                if (index < data.length - 1) {
                    return data[index++];
                } else {
                    return null;
                }
            }
        };

        NumberPublisher publisher = new NumberPublisher(supplier);

        NumberProcessorEnhanced processor = new NumberProcessorEnhanced();

        publisher.subscribe(processor);

        processor.subscribe(new Flow.Subscriber<>() {
            Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("onNext: " + item);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete()");
            }
        });
    }


    private static String[] getStrings() {
        String filePath = "res/numbers.txt";
        try (Stream<String> words = Files.lines(Paths.get(filePath))) {
            return words.flatMap((line) -> Arrays.stream(line.split("[\\s\\n]+")))
                    .filter((word) -> word.length() > 0)
                    .toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
