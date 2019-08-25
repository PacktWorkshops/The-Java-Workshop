package com.packt.java.chapter23;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class BubbleSortMember implements Callable<List<Member>> {

    private List<Member> data;

    public BubbleSortMember(List<Member> data) {
        this.data = data;
    }

    @Override
    public List<Member> call() throws Exception {
        List<Member> copied = new ArrayList<>(data);
        int n = copied.size();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                Member currentItem = copied.get(i);
                Member nextItem = copied.get(i + 1);

                if (currentItem.salary < nextItem.salary) {
                    copied.set(i, nextItem);
                    copied.set(i + 1, currentItem);
                    swapped = true;
                }
            }
        }
        return copied;
    }
}
