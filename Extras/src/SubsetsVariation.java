import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsVariation {

   // Subsets:  https://leetcode.com/problems/subsets/
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsbacktrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void subsetsbacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            subsetsbacktrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

   //Subsets: https://leetcode.com/problems/subsets-ii/

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupbacktrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void subsetsWithDupbacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            subsetsWithDupbacktrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }



    // Permutation : https://leetcode.com/problems/permutations/






    public static void main(String[] args){

        System.out.println("Variation 1: All possible subsets including duplicates");

        List<List<Integer>> subsets = subsets(new int[]{1, 3, 6, 3, 9,4, 2});
        System.out.println(subsets.toString());


        System.out.println("Variation 2: Input With duplicates");

        List<List<Integer>> subsetsWithDup = subsetsWithDup(new int[]{1, 3, 6, 3, 9,4, 2});
        System.out.println(subsetsWithDup.toString());


    }
}
