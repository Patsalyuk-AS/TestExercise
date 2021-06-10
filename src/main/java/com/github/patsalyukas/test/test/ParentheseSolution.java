package com.github.patsalyukas.test.test;

import java.util.*;

public class ParentheseSolution {
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        Deque<Character> stringOfParentheses = new LinkedList();
        char simbolFromInput;
        char simbolFromStack;
        while (sc.hasNext()) {
            String input=sc.next();
            stringOfParentheses.clear();
            if ((input == "")||(input == null)) {
                System.out.println(true);
                break;
            }
            for (int i = 0; i < input.length(); i++) {
                simbolFromInput = input.charAt(i);
                if ((simbolFromInput == '(') || (simbolFromInput == '[') || (simbolFromInput == '{')) {
                    stringOfParentheses.addLast(simbolFromInput);
                } else if ((simbolFromInput == ')') || (simbolFromInput == ']') || (simbolFromInput == '}')) {
                    if (stringOfParentheses.peekLast() == null) {
                        stringOfParentheses.addLast('!');
                        break;
                    }
                    simbolFromStack = stringOfParentheses.peekLast();
                    if ((simbolFromStack - simbolFromInput == -1)||(simbolFromStack - simbolFromInput == -2)) {
                        stringOfParentheses.removeLast();
                    } else {
                        break;
                    }
                }
            }
            if (stringOfParentheses.isEmpty()) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }

    }
}
