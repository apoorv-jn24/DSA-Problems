import java.util.ArrayList;
import java.util.List;
public class Subsequences {
    public static void main(String[] args) {
        String str = "abc";
        int[] nums = {1,2,2};
        System.out.println(subsets(nums));
    }
    // All subsets of the ArrayList  LeetCode 78
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num:nums){
            int n = result.size();
            for(int i=0;i<n;i++){
                ArrayList<Integer> list = new ArrayList<>(result.get(i)); // creating a copy of the result list
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
    // print all subsequences of the String
    // public static void printSubseq(String current, String str) {
    //    if(str.length()==0) {
    //     System.out.println(current);
    //     return;
    //    }
    //    char ch = str.charAt(0);
    //    printSubseq( current + ch, str.substring(1));
    //    printSubseq(current, str.substring(1));
    // }
    
}