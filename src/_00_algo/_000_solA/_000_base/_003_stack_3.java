package _00_algo._000_solA._000_base;

import java.util.Stack;

public class _003_stack_3 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("apple");
        stack.push("banana");
        stack.push("cherry");

        System.out.println(stack.peek());
        System.out.println(stack.contains("banana"));
        System.out.println(stack.pop());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());
    }
}
