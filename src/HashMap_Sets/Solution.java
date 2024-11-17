package HashMap_Sets;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {



    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "car";
        String t = "arci";

//        System.out.println(solution.numJewelsInStones("aA","aAAbbbb"));
//        System.out.println(solution.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(solution.canConstruct("aa","ab"));

    }

    public  int numJewelsInStones(String jewels, String stones) {
        int totalJewels = 0;
//        HashMap<Character,Integer> sJ = new HashMap<>();
//        for (char c: stones.toCharArray()){
//            if (sJ.containsKey(c)){
//                sJ.put(c, sJ.get(c)+1);
//            }else{
//                sJ.put(c,1);
//            }
//        }
//        for (Map.Entry<Character,Integer> e : sJ.entrySet()){
//            if (jewels.contains(String.valueOf(e.getKey()))){
//                totalJewels+=e.getValue();
//            }
//        }
//        return totalJewels;

        Set<Character> sJ = new HashSet<>();
        for (char c:jewels.toCharArray()){
            sJ.add(c);
        }

        for (char c:stones.toCharArray()){
            if (sJ.contains(c)){
                totalJewels++;
            }
        }
        return totalJewels;

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int i : nums){
            if(!unique.add(i)){
                return true;
            }
        }
        return false;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        for (char c: magazine.toCharArray()){
            if (charCount.containsKey(c)){
                charCount.put(c,charCount.get(c)+1);
            }else{
                charCount.put(c,1);
            }
        }

        for (char c: ransomNote.toCharArray()){
            if (!charCount.containsKey(c)) return false;
            if (charCount.get(c) == 1){
                charCount.remove(c);
            }else{
                charCount.put(c,charCount.get(c)-1);
            }
        }

        return true;
    }
}
