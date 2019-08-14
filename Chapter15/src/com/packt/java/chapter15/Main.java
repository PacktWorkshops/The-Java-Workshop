package com.packt.java.chapter15;

import java.util.stream.*;

public class Main {

    public static void main(String[] args) {






//        String cwd = System.getProperty("user.dir");
//        System.out.println(cwd);

//        // Create a Stream of one object
//        Stream<Object> one = Stream.of(new Object());
//
//        // Create a stream of multiple elements
//        Stream<Object> two = Stream.of(new Object(), new Object(), new Object());
//
//        // There are four types of streams Stream (objects), IntStream (ints), DoubleStream (doubles), LongStream (longs)
//        IntStream intStream = IntStream.of(1, 2, 3);
//
//        // Create a stream from a list
//        List<String> stringList = List.of("string1", "string2", "string3");
//        Stream<String> stringStream = stringList.stream();
//
//        // Create a stream from an array
//        String[] stringArray = new String[]{"string1", "string2", "string3"};
//        Stream<String> stringStream1 = Arrays.stream(stringArray);
//
//        // Create a stream of one item - that either returns a stream of one item, or an empty stream if the item is null.
//        Stream<Object> three = Stream.ofNullable(new Object());
//
//        // Add two streams together
//        Stream<Object> concatenated = Stream.concat(one, two);

        // A stream with at least one following operation is called a pipeline
        Comparable asd;

        // a few intermediate operations change the type of stream!
        long count = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).mapToInt(i -> i.value).count();

        // flatMap
//        Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).flatMap((i) -> {
//            return i.value;
//        });

        // Disctinct
//        long count = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).distinct();

        // Sorted
//        Stream.of(1, 4, 6, 2, 9).sorted().forEach(System.out::println);
//        Stream.of(1, 4, 6, 2, 9).sorted((a, b) -> a - b).forEach(System.out::println);

        // Peek
//        long count = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).peek();

//        // Limit
//        long asdasd = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).limit(100).count();

//        // Skip
//        long asdasd = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).skip(1).count();

//        // For each
//        System.out.println("Un ordered");
//        Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).parallel().forEach((i) -> {
//            System.out.println(String.valueOf(i.value));
//        });
//
//        // For each ordered
//        System.out.println("Ordered");
//        Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).parallel().forEachOrdered((i) -> {
//            System.out.println(String.valueOf(i.value));
//        });

//        // To array 1
//        Object[] arr = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).toArray();
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println("item: " + ((Item)arr[i]).value);
//        }
//        // To array 2
//        Item[] arr2 = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).toArray(Item[]::new);
//        for(int i = 0; i < arr2.length; i++) {
//            System.out.println("item: " + arr2[i].value);
//        }

//        // Reduce 1
//        int sum = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).map(i -> i.value).reduce(0, (a, b) -> a + b);

//        // Reduce 2
//        int sum2 = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).reduce(0, (total, i) -> total + i.value, (a, b) -> a + b );

//        // Sum
//        int sum3 = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).mapToInt(i -> i.value).sum();

//        // Collect
//        List<Item> items = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).collect(Collectors.toList());

//        // Min
//        Optional<Item> item = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).min(Comparator.comparingInt(a -> a.value));

//        // Max
//        Optional<Item> item = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).max(Comparator.comparingInt(a -> a.value));

        // Average
//        OptionalDouble avg = IntStream.of(1, 2, 5, 12, 5, 4, 2).average();

//        // Count
//        long items = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).count();

//        // Anymatch
//        boolean matched = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).anyMatch((i) -> {return i.value > 20;});

//        // allMAtch
//        boolean matched = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).allMatch((i) -> {return i.value > 0;});

//        // noneMatch
//        boolean matched = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).noneMatch((i) -> {return i.value > 0;});

//        // findFirst
//        Optional<Item> item = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).sorted((a,b)->a.value - b.value).findFirst();

//        // findAny
//        Optional<Item> item = Stream.of(new Item(3), new Item(5), new Item(12), new Item(1)).findAny();
//        System.out.println(item.get().value);

        // summaryStatistics
//        IntSummaryStatistics stats = IntStream.of(1, 2, 5, 12, 5, 4, 2).summaryStatistics();
//        LongSummaryStatistics stats2 = LongStream.of(1, 2, 5, 12, 5, 4, 2).summaryStatistics();
//        DoubleSummaryStatistics stats3 = DoubleStream.of(1, 2, 5, 12, 5, 4, 2).summaryStatistics();



//Stream.of(1, 2, 3, 4).onClose(() -> {
//    System.out.println("Close handler 1");
//}).onClose(() -> {
//    System.out.println("Close handler 2");
//}).onClose(() -> {
//    double d = 1 / 0;
//    System.out.println("Close handler 3");
//}).onClose(() -> {
//    System.out.println("Close handler 4");
//}).close();

//        reduce(0, (a, b) -> {
//            return a + b;
//        });

//        Stream.Builder<String> streamBuilder = Stream.builder();
//        for (int i = 0; i < 10; i++) {
//            streamBuilder.accept("string" + i);
//        }
//        Stream<String> stream = streamBuilder.build();

//        Stream.Builder<String> streamBuilder = Stream.builder();
//        streamBuilder.add("string1").add("string2").add("string3");
//        Stream<String> stream = streamBuilder.build();
//
//        streamBuilder.add("asd");
    }

    private static class Item {
        int value;
        public Item(int val) {
            value = val;
        }
    }
}
