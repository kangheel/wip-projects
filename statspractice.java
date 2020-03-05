import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class statspractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("exit")) {
            System.out.println("Enter how many numbers you want.");
            answer = scanner.next();
            int number = Integer.parseInt(answer);
            int[] numbers = new int[number];
            for (int i = 0; i < number; i++) {
                numbers[i] = (int) (Math.random()*30);
            }
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("Type anything for the answer...");
            answer = scanner.next();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            HashMap<Integer, Integer> occurances = new HashMap<>();
            for (int num : numbers) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                sum += num;
                occurances.put(num,occurances.getOrDefault(num, 0)+1);
            }
            int maxmode = Integer.MIN_VALUE;
            for (int i : occurances.values()) {
                maxmode = Math.max(maxmode,i);
            }
            HashSet<Integer> modes = new HashSet<>();
            for (int i : occurances.keySet()) {
                if (occurances.get(i) == maxmode) {
                    modes.add(i);
                } 
            }
            System.out.println("Mean: " + 1.0*sum/number);
            System.out.println("Range: " + (max-min));
            for (int i : modes) {
                System.out.println("Mode: " + i);
            }
            TreeSet<Integer> sorted = new TreeSet<>();
            for (int i : numbers) {
                sorted.add(i);
            }
            int index = 0;
            int lowmed = 0;
            int highmed = 0;
            for (int i : sorted) {
                if (number % 2 == 0) {
                    if (index == (number/2)-1) {
                        lowmed = i;
                    }
                    else if (index == (number/2)) {
                        highmed = i;
                        break;
                    }
                }
                else {
                    if (index == number/2) {
                        System.out.println("Median: " + i);
                        break;
                    }
                }
                index++;
            }
            if (lowmed != 0 && highmed != 0) {
                System.out.println("Median: " + (lowmed+highmed)/2.0);
            }
        }
    }
}