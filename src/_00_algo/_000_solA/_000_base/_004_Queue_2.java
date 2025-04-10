package _00_algo._000_solA._000_base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _004_Queue_2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= 5; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
