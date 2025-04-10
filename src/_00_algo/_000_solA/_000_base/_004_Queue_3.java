package _00_algo._000_solA._000_base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _004_Queue_3 {
    public static void main(String[] args) {
        Deque<String> dq = new ArrayDeque<>();

        dq.addFirst("apple");
        dq.addLast("banana");
        dq.addFirst("cherry");

        System.out.println(dq.peek());
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

        System.out.println(dq.removeLast());
        System.out.println(dq.removeFirst());

        while(!dq.isEmpty()){
            System.out.println(dq.remove());
        }
    }
}

