import java.io.*;
import java.util.*;
 
public class day1 {
    public static void main(String[] args) throws IOException{
        day1 test = new day1();
        System.out.println(test.part2());
    }

    int part1()throws IOException{
        Scanner in = new Scanner(new File("C:\\Users\\Miguel\\Desktop\\AdventOCode24\\day1\\data.txt"));
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        while(in.hasNextLine()){
            String[] nums = in.nextLine().split("\\s+"); //One or more white space
            left.add(Integer.parseInt(nums[0]));
            right.add(Integer.parseInt(nums[1]));
        }
        in.close();

        Collections.sort(left);
        Collections.sort(right);

        int totaldist = 0;
        for(int i = 0; i < left.size(); i++){
            totaldist += Math.abs(left.get(i) - right.get(i));
        }
        return totaldist;
    }

    int part2()throws IOException{
        Scanner in = new Scanner(new File("C:\\Users\\Miguel\\Desktop\\AdventOCode24\\day1\\data.txt"));
        List<Integer> left = new ArrayList<Integer>();
        Map<Integer, Integer> right = new HashMap<>();

        while(in.hasNextLine()){
            String[] nums = in.nextLine().split("\\s+"); //One or more white space
            left.add(Integer.parseInt(nums[0]));
            int toadd = Integer.parseInt(nums[1]);
            if(right.get(toadd) == null){
                right.put(toadd, 1);
            }else{
                right.put(toadd, right.get(toadd)+1);
            }
        }

        int total = 0;
        for(int i = 0; i < left.size(); i++){
            if(right.get(left.get(i)) != null){
                total += left.get(i) * right.get(left.get(i));
            }
        }
        return total;
    }
}
