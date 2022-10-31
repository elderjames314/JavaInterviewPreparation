package preparation;

import java.util.Arrays;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {

        String[] arr = {"2", "1", "+", "3", "*" };
        String[] arr1 = {"4", "13", "5", "/", "+"};

        System.out.println(reversePolishNotation(arr1));

    }

    private static int reversePolishNotation(String[] arr) {

        String operation = "+/*-";
        Stack<String> buckets = new Stack<>();

        for (String token: arr) {
            if(!operation.contains(token)){
                buckets.push(token);
            }else {
                int index = operation.indexOf(token);
                int firstValue = Integer.valueOf(buckets.pop());
                int secondValue = Integer.valueOf(buckets.pop());
                switch (index) {
                    case 0:
                        buckets.push(String.valueOf(firstValue + secondValue));
                        break;
                    case 1:
                        buckets.push(String.valueOf(secondValue / firstValue));
                        break;
                    case 2:
                        buckets.push(String.valueOf(firstValue * secondValue));
                        break;
                    case 3:
                        buckets.push(String.valueOf(secondValue - firstValue));
                        break;
                }
            }
        }
        return Integer.valueOf(buckets.pop());
    }
}
