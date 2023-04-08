package org.example;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        random = new Random();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomsItr<Integer>(this);
    }

    private static class RandomsItr<E> implements Iterator<Integer> {
        private final Randoms a;

        RandomsItr(Randoms a) {
            this.a = a;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return a.min + a.random.nextInt(a.max - a.min + 1);
        }
    }
}
