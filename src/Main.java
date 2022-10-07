import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        List<Integer> firstStack = new ArrayList<>();
        List<Integer> secondStack = new ArrayList<>();

        for (int i = 0; i < Math.max(m, n); i++) {

            try {
                firstStack.add(scanner.nextInt());
            } catch (Exception e) {
                scanner.next();

            }

            try {
                secondStack.add(scanner.nextInt());
            } catch (Exception e) {
                scanner.next();

            }
        }

        int result = 0;
        int stack1_count = 0;
        int stack2_count = 0;
        int totalSum = 0;
        for (Integer elementFirst : firstStack) {
            if (totalSum + elementFirst > s)
                break;
            totalSum += elementFirst;
            stack1_count++;
        }
        result = stack1_count;


        for (Integer elementSecond : secondStack) {
            totalSum += elementSecond;
            stack2_count++;
            while (totalSum > s && stack1_count > 0) {
                totalSum -= firstStack.get(stack1_count - 1);
                stack1_count--;
            }
            result = (totalSum <= s) ?
                    Math.max(stack1_count + stack2_count, result) : result;
        }

        System.out.println(result);

    }

}


