package com.packt.java.chapter23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MergeSortMember extends RecursiveTask<List<Member>> {
    private List<Member> data;

    public MergeSortMember(List<Member> data) {
        this.data = data;
    }

    @Override
    protected List<Member> compute() {
        if (data.size() == 1) {
            return data;
        }
        int middle = data.size() / 2;

        List<Member> left = data.subList(0, middle);
        List<Member> right = data.subList(middle, data.size());

        MergeSortMember leftTask = new MergeSortMember(left);
        MergeSortMember rightTask = new MergeSortMember(right);

        invokeAll(leftTask, rightTask);

        List<Member> leftResult = leftTask.join();
        List<Member> rightResult = rightTask.join();

        return merge(leftResult, rightResult);
    }

    private List<Member> merge(List<Member> left, List<Member> right) {
        int totalMembers = left.size() + right.size();
        List<Member> result = new ArrayList<>(totalMembers);
        int l = 0, r = 0;
        for (int i = 0; i < totalMembers; i++) {
            if (l >= left.size()) {
                result.add(i, right.get(r++));
            } else if (r >= right.size()) {
                result.add(i, left.get(l++));
            } else {
                if (left.get(l).salary > right.get(r).salary) {
                    result.add(i, left.get(l++));
                } else {
                    result.add(i, right.get(r++));
                }
            }
        }

        return result;
    }
}