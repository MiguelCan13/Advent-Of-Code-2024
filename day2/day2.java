import java.io.*;
import java.util.*;

public class day2 {
    public static void main(String[] args) throws IOException{
        System.out.println(part2());
    }

    static int part1() throws IOException {
        Scanner in = new Scanner(new File("C:\\Users\\migue\\OneDrive\\Documents\\GitHub\\Advent-Of-Code-2024\\day2\\day2.txt"));
        int safeReports = 0;

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" ");
            if (line.length < 2) continue; // Skip lines with fewer than 2 levels

            boolean isSafe = true;
            int trend = 0; // 0: unset, 1: increasing, -1: decreasing

            for (int i = 0; i < line.length - 1; i++) {
                int current = Integer.parseInt(line[i]);
                int next = Integer.parseInt(line[i + 1]);
                int diff = next - current;

                if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                    isSafe = false; // Difference not in allowed range
                    break;
                }

                if (trend == 0) {
                    trend = Integer.compare(diff, 0); // Set initial trend
                } else if ((trend == 1 && diff < 0) || (trend == -1 && diff > 0)) {
                    isSafe = false; // Trend inconsistency
                    break;
                }
            }

            if (isSafe) safeReports++;
        }

        return safeReports;
    }
    static int part2() throws IOException {
        Scanner in = new Scanner(new File("C:\\Users\\migue\\OneDrive\\Documents\\GitHub\\Advent-Of-Code-2024\\day2\\day2.txt"));
        int safeReports = 0;
    
        while (in.hasNextLine()) {
            ArrayList<String> line = new ArrayList<>(Arrays.asList(in.nextLine().split(" ")));
            if (line.size() < 2) continue;
    
            if (isSafe(line)) {
                safeReports++;
                continue;
            }
    
            boolean becomesSafe = false;
            for (int i = 0; i < line.size(); i++) {
                ArrayList<String> modifiedLine = new ArrayList<>(line);
                modifiedLine.remove(i);
    
                if (isSafe(modifiedLine)) {
                    becomesSafe = true;
                    break;
                }
            }
    
            if (becomesSafe) {
                safeReports++;
            }
        }
    
        return safeReports;
    }
    
    static boolean isSafe(ArrayList<String> line) {
        if (line.size() < 2) return false;
    
        int trend = 0; // 0: unset, 1: increasing, -1: decreasing
    
        for (int i = 0; i < line.size() - 1; i++) {
            int current = Integer.parseInt(line.get(i));
            int next = Integer.parseInt(line.get(i + 1));
            int diff = next - current;
    
            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false; 
            }
    
            if (trend == 0) {
                trend = Integer.compare(diff, 0); 
            } else if ((trend == 1 && diff < 0) || (trend == -1 && diff > 0)) {
                return false; 
            }
        }
    
        return true;
    }
    
}
