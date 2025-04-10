package _00_algo._000_solA._000_base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _004_Queue {
    public static void main(String[] args) {
        /*
        선입선출 (FIFO) 구조
        먼저 넣은 데이터가 먼저 나간다
        offer() → 넣기
        poll() → 꺼내기
        peek() → 맨 앞 요소 보기*/

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());

        /*
        Deque란?
        양쪽으로 삽입/삭제 가능한 Queue
        Deque = Double-Ended Queue
        스택과 큐를 동시에 구현할 수 있음!*/

        Deque<String > dq = new ArrayDeque<>();
        dq.addFirst("a");
        dq.addLast("b");

        System.out.println(dq.removeFirst()); // a
        System.out.println(dq.removeLast());  // b

        /*
        offer(e)	뒤에 추가

        poll()	앞에서 제거 + 반환
        peek()	앞 요소 조회

        addFirst(e)	앞에 추가
        addLast(e)	뒤에 추가
        removeFirst()	앞에서 제거
        removeLast()	뒤에서 제거

        isEmpty()	비었는지 확인
        size()	크기 확인*/
    }
}
