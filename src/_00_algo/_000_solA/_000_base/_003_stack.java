package _00_algo._000_solA._000_base;

import java.util.Stack;

public class _003_stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);



        // System.out.println(stack.pop());
        if(!stack.isEmpty()){
            int top = stack.pop();
            System.out.println(top);
        }

        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.search(10));
        System.out.println(stack.contains(99));

        /*
        push(E item)	아이템을 스택에 추가
        pop()	맨 위 아이템 꺼내고 제거 (pop()은 예외 발생 가능하니 꼭 isEmpty()로 체크하고 쓰는 게 좋아.)

        peek()	맨 위 아이템 조회만 (제거 X)
        isEmpty()	스택이 비었는지 확인

        size()	스택 크기

        search(Object o)	요소의 위치 반환 (1부터 시작, 못 찾으면 -1)
        contains(Object o)	요소 포함 여부 확인

        */


    }
}
