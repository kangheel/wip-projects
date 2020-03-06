import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class sort {
    private static int iterations;
    private static PrintWriter pw;
    public static void main(String[] args) throws FileNotFoundException {
        pw = new PrintWriter(new File("sort.csv"));
        int length = 50;
        int cap = 100;
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = (int) (Math.random()*cap);
        }
        printArray(numbers);
        int[] clone1 = numbers.clone();
        int[] clone2 = numbers.clone();
        int[] clone3 = numbers.clone();
        int[] clone4 = numbers.clone();
        int[] clone5 = numbers.clone();
        iterations = 0;
        pw.println("Bubble sort");
        long BSstartTime = System.currentTimeMillis();
        bubbleSort(clone1);
        long BSendTime = System.currentTimeMillis();
        long BSduration = (BSendTime - BSstartTime);
        int bubbleSortIterations = iterations;
        // System.out.println("Bubble sort complete");
        pw.println("Foil sort");
        long FSstartTime = System.currentTimeMillis();
        foilSort(clone2);
        long FSendTime = System.currentTimeMillis();
        long FSduration = (FSendTime - FSstartTime);
        int foilSortIterations = iterations;
        // System.out.println("Foil sort complete");
        pw.println("Criss Cross sort");
        long CCSstartTime = System.currentTimeMillis();
        crissCrossSort(clone3);
        long CCSendTime = System.currentTimeMillis();
        long CCSduration = (CCSendTime - CCSstartTime);
        int crissCrossSortIterations = iterations;
        // System.out.println("Criss Cross sort complete");
        pw.println("Layer sort");
        long LSstartTime = System.currentTimeMillis();
        layerSort(clone4);
        long LSendTime = System.currentTimeMillis();
        long LSduration = (LSendTime - LSstartTime);
        int layerSortIterations = iterations;
        // System.out.println("Layer sort complete");
        pw.println("Neighbor sort");
        long NSstartTime = System.currentTimeMillis();
        neighborSort(clone5);
        long NSendTime = System.currentTimeMillis();
        long NSduration = (NSendTime - NSstartTime);
        int neighborSortIteartions = iterations;
        // System.out.println("Neighbor sort complete");
        pw.println("Bubble Sort: "+bubbleSortIterations + " " + BSduration + "ms");
        pw.println("Foil Sort: "+foilSortIterations + " " + FSduration + "ms");
        pw.println("Criss Cross Sort: "+crissCrossSortIterations + " " + CCSduration + "ms");
        pw.println("Layer Sort: "+layerSortIterations + " " + LSduration + "ms");
        pw.println("Neighbor Sort: "+neighborSortIteartions + " " + NSduration + "ms");
        pw.close();
    }

    private static boolean notSorted(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] > numbers[i+1]) return true;
        }
        return false;
    }

    public static int[] layerSort(int[] numbers) {
        iterations = 0;
        while (notSorted(numbers)) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i+1; j < numbers.length; j++) {
                    if (numbers[i] > numbers[j]) {
                        int temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                    }
                    pw.print(iterations+": ");
                    printArray(numbers);
                    iterations++;
                    if (!notSorted(numbers)) break;
                }
                if (!notSorted(numbers)) break;
            }
            if (!notSorted(numbers)) break;
        }
        return numbers;
    }

    public static int[] foilSort(int[] numbers) {
        iterations = 0;
        while (notSorted(numbers)) {
            for(int i = 0; i < numbers.length/2; i++) {
                if (numbers[i] > numbers[numbers.length-i-1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[numbers.length-i-1];
                    numbers[numbers.length-i-1] = temp;
                }
                iterations++;
                pw.print(iterations+": ");
                printArray(numbers);
                if (!notSorted(numbers)) break;
            }
            bubbleSort(numbers);
        }
        return numbers;
    }

    public static int[] crissCrossSort(int[] numbers) {
        iterations = 0;
        while (notSorted(numbers)) {
            for(int i = 0; i < numbers.length-2; i++) {
                if (numbers[i] > numbers[i+2]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i+2];
                    numbers[i+2] = temp;
                }
                iterations++;
                pw.print(iterations+": ");
                printArray(numbers);
                if (!notSorted(numbers)) break;
            }
            bubbleSort(numbers);
        }
        return numbers;
    }

    public static int[] bubbleSort(int[] numbers) {
        while (notSorted(numbers)) {
            for(int i = 0; i < numbers.length-1; i++) {
                if (numbers[i] > numbers[i+1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                }
                iterations++;
                pw.print(iterations+": ");
                printArray(numbers);
            }
        }
        return numbers;
    }

    public static int[] neighborSort(int[] numbers) {
        iterations = 0;
        while (notSorted(numbers)) {
            for (int i = 1; i < numbers.length-1; i++) {
                int first = numbers[i-1];
                int middle = numbers[i];
                int last = numbers[i+1];
                if (first > middle && first > last) {
                    if (middle < last) {
                        int temp1 = middle;
                        int temp2 = last;
                        numbers[i+1] = first;
                        numbers[i] = temp2;
                        numbers[i-1] = temp1;
                    }
                    else {
                        int temp1 = last;
                        int temp2 = middle;
                        numbers[i+1] = first;
                        numbers[i] = temp2;
                        numbers[i-1] = temp1;
                    }
                }
                else if (last > middle && last > first) {
                    if (middle < first) {
                        int temp1 = middle;
                        int temp2 = first;
                        numbers[i+1] = last;
                        numbers[i] = temp2;
                        numbers[i-1] = temp1;
                    }
                    else {
                        int temp1 = first;
                        int temp2 = middle;
                        numbers[i+1] = last;
                        numbers[i] = temp2;
                        numbers[i-1] = temp1;
                    }
                }
                else if (middle > first && middle > last) {
                    if (first < last) {
                        int temp1 = first;
                        int temp2 = last;
                        numbers[i+1] = middle;
                        numbers[i] = temp2;
                        numbers[i-1] = temp1;
                    }
                    else {
                        int temp1 = last;
                        int temp2 = first;
                        numbers[i+1] = middle;
                        numbers[i] = temp2;
                        numbers[i-1] = temp1;
                    }
                }
                else {
                    if (first == middle && middle == last) {
                        continue;
                    }
                    else if (first == middle) {
                        if (first > last) {
                            int temp1 = last;
                            int temp2 = first;
                            numbers[i+1] = middle;
                            numbers[i] = temp2;
                            numbers[i-1] = temp1;
                        }
                        else {
                            int temp1 = first;
                            int temp2 = middle;
                            numbers[i+1] = last;
                            numbers[i] = temp2;
                            numbers[i-1] = temp1;
                        }
                    }
                    else if (middle == last) {
                        if (middle > first) {
                            int temp1 = first;
                            int temp2 = last;
                            numbers[i+1] = middle;
                            numbers[i] = temp2;
                            numbers[i-1] = temp1;
                        }
                        else {
                            int temp1 = last;
                            int temp2 = middle;
                            numbers[i+1] = first;
                            numbers[i] = temp2;
                            numbers[i-1] = temp1;
                        }
                    }
                    else if (first == last) {
                        if (first > middle) {
                            int temp1 = middle;
                            int temp2 = first;
                            numbers[i+1] = last;
                            numbers[i] = temp2;
                            numbers[i-1] = temp1;
                        }
                        else {
                            int temp1 = first;
                            int temp2 = last;
                            numbers[i+1] = middle;
                            numbers[i] = temp2;
                            numbers[i-1] = temp1;
                        }
                    }
                }
                if (!notSorted(numbers)) break;
                pw.print(iterations+": ");
                printArray(numbers);
                iterations++;
            }
        }
        return numbers;
    }

    private static void printArray(int[] numbers) {
        for (int num : numbers) {
            pw.print(num + " ");
        }
        pw.println();
    }
}