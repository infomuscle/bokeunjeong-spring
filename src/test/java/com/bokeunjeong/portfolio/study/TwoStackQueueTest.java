package com.bokeunjeong.portfolio.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoStackQueueTest {


    @Test
    public void testTwoStackQueue() throws Exception {
        Random random = new Random();
        List<Integer> numbers = IntStream.range(0, 10).mapToObj(x -> random.nextInt(5) + 1).collect(Collectors.toList());

        List<Integer> dequeued = new ArrayList<>();
        TwoStackQueue tsq = new TwoStackQueue();
        numbers.stream().forEach(number -> tsq.enqueue(number));

        while (!tsq.isEmpty()) {
            dequeued.add(tsq.dequeue());
        }

        IntStream.range(0, dequeued.size()).forEach(i -> assertThat(dequeued.get(i)).isEqualTo(numbers.get(i)));
        System.out.println(numbers);
        System.out.println(dequeued);
    }


    class TwoStackQueue {

        Stack<Integer> inStack = new Stack();
        Stack<Integer> outStack = new Stack();

        public void enqueue(Integer element) {
            inStack.push(element);
        }

        public Integer dequeue() throws Exception {
            if (outStack.isEmpty()) {
                if (inStack.isEmpty()) {
                    throw new Exception();
                }
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }

            }
            return outStack.pop();
        }

        public Boolean isEmpty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        public Integer size() {
            return inStack.size() + outStack.size();
        }

    }

}
