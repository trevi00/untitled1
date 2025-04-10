package _00_algo._000_solA._000_base;

import java.util.Scanner;
import java.util.Stack;

public class _003_stack_2 {
    public static void main(String[] args) {
        // (()())()
        // YES

        Stack<Character> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        char[] chArr = str.toCharArray();

        boolean ans = true;
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] == '('){
                stack.push(chArr[i]);
            } else {
                if(stack.isEmpty()){
                    ans = false;
                    break;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty() && ans){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
