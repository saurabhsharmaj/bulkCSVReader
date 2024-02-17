package com.example.merter.vo;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
    private final Queue<CsvRecord> queue = new LinkedList<>();
    private final int maxSize;
    private final Object IS_NOT_FULL = new Object();
    private final Object IS_NOT_EMPTY = new Object();

    public DataQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return queue.size() == maxSize;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void waitIsNotFull() throws InterruptedException {
        synchronized (IS_NOT_FULL) {
            IS_NOT_FULL.wait();
        }
    }

    public void waitIsNotEmpty() throws InterruptedException {
        synchronized (IS_NOT_EMPTY) {
            IS_NOT_EMPTY.wait();
        }
    }

    public void add(CsvRecord CsvRecord) {
        queue.add(CsvRecord);
        notifyIsNotEmpty();
    }

    public CsvRecord poll() {
        CsvRecord mess = queue.poll();
        notifyIsNotFull();
        return mess;
    }

    public Integer getSize() {
        return queue.size();
    }

    private void notifyIsNotFull() {
        synchronized (IS_NOT_FULL) {
            IS_NOT_FULL.notify();
        }
    }

    private void notifyIsNotEmpty() {
        synchronized (IS_NOT_EMPTY) {
            IS_NOT_EMPTY.notify();
        }
    }
}