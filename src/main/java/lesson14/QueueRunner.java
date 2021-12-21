package lesson14;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueRunner {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> numbers = new LinkedList<Integer>();
        System.out.println(numbers.peek()); // no exception
        // System.out.println(numbers.element()); // throw exception
        numbers.add(1);
        numbers.add(5);
        numbers.add(-1);
        numbers.add(28);
        for (Integer value : numbers) {
            System.out.println(value + " ");
        }
        System.out.println(numbers);

        List<String> sharedResources = new ArrayList<>();
//        while (true) {
//            if (!sharedResources.isEmpty()) {
//                String word = sharedResources.get(0);
//                print(word);
//            }
//            Thread.sleep(1_000);
//        }

        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        priorityQueue.offer(185);
        priorityQueue.offer(1857);
        priorityQueue.offer(18);
        priorityQueue.offer(10000);
        priorityQueue.offer(-1);
        System.out.println(priorityQueue);

        BlockingQueue<String> anotherSharesResources = new ArrayBlockingQueue<>(10);
        while (true) {
            String take = anotherSharesResources.take();
            print(take);
        }
    }

    public static void print (String str) {
        System.out.println(str);
    }
}
