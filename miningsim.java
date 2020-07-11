import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class miningsim {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> progress = new HashMap();
        PrintWriter pw = new PrintWriter("tempminingsim.txt");
        int[] chances = new int[] {200,30,10,4,7,2,1,5};
        int total = 0;
        for (int i : chances) {
            total += i;
        }

        Scanner reader = new Scanner(new File("MiningSimProgress.txt"));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            progress.put(line.substring(0,line.indexOf(" ")), Integer.parseInt(line.substring(line.indexOf(" ")+1)));
        }

        System.out.println("------------------------------------------");
        for (int i = 0; i < 12; i++) {
            System.out.println();
        }
        for (String string : progress.keySet()) {
            System.out.println(string + " " + progress.get(string));
        }
        System.out.println();
        int random = (int) (Math.random()*total);
        int exit = -1;
        for (int i : chances) {
            random -= i;
            exit++;
            if (random <= 0) {
                break;
            }
        }
        if (exit == 0) {
            System.out.println("You found cobblestone!");
            progress.put("Cobblestone", progress.get("Cobblestone")+2);
        }
        else if (exit == 1) {
            System.out.println("You found coal!");
            progress.put("Coal", progress.get("Coal")+(int) (Math.random()*15+5));
        }
        else if (exit == 2) {
            System.out.println("You found iron!");
            progress.put("Iron", progress.get("Iron")+(int) (Math.random()*4+4));
        }
        else if (exit == 3) {
            System.out.println("You found lapis lazuli!");
            progress.put("Lapis_Lazuli", progress.get("Lapis_Lazuli")+(int) (Math.random()*4+4));
        }
        else if (exit == 4) {
            System.out.println("You found redstone!");
            progress.put("Redstone", progress.get("Redstone")+(int) (Math.random()*4+4));
        }
        else if (exit == 5) {
            System.out.println("You found diamond!");
            progress.put("Diamond", progress.get("Diamond")+(int) (Math.random()*7+1));
        }
        else if (exit == 6) {
            System.out.println("You found emerald!");
            progress.put("Emerald", progress.get("Emerald")+1);
        }
        else {
            System.out.println("You found gold!");
            progress.put("Gold", progress.get("Gold")+(int) (Math.random()*4+4));
        }
        for (int i = 0; i < 12; i++) {
            System.out.println();
        }
        System.out.println("------------------------------------------");
        
        for (String string : progress.keySet()) {
            pw.println(string + " " + progress.get(string));
        }
        pw.close();
        reader.close();
        Scanner transfer = new Scanner(new File("tempminingsim.txt"));
        PrintWriter export = new PrintWriter("MiningSimProgress.txt");
        while (transfer.hasNextLine()) {
            export.println(transfer.nextLine());
        }
        export.close();
    }
}