package HashMap_Sets;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {



    public static void main(String[] args) {
        Solution solution = new Solution();


//        System.out.println(solution.numJewelsInStones("aA","aAAbbbb"));
//        System.out.println(solution.containsDuplicate(new int[]{1,2,3,1}));
//        System.out.println(solution.canConstruct("aa","ab"));
//        System.out.println(solution.isAnagram("anagram","nagaram"));
//        System.out.println(solution.maxNumberOfBalloons("nlaebolko"));


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

    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()) return false;
//
//        char[] sArr = s.toCharArray();
//        char[] tArr = t.toCharArray();
//        Arrays.sort(sArr);
//        Arrays.sort(tArr);
//        s = new String(sArr);
//        t = new String(tArr);
//
//        return s.equals(t);

        //SOL 2

        Map<Character,Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()){
            sMap.put(c,sMap.getOrDefault(c,0)+1);
        }
        for (char c : t.toCharArray()){
            if (!sMap.containsKey(c))return false;
            if (sMap.get(c)==1)sMap.remove(c);
            else sMap.put(c,sMap.get(c)-1);
        }

        return sMap.isEmpty();


        // return s.chars().sorted().mapToObj(c->String.valueOf((char) c)).collect(Collectors.joining()).equals(t.chars().sorted().mapToObj(c->String.valueOf((char) c)).collect(Collectors.joining()));
    }

    public int maxNumberOfBalloons(String text) {

//        int[] chars = new int[26];
//        for(char c: text.toCharArray()){
//            chars[c-'a']++;
//        }
//
//        return Math.min(Math.min(Math.min(chars[1],chars[0]),Math.min(chars[11]/2,chars[14]/2)),chars[13]);

        Map<Character,Integer> charForBal = new HashMap<>();
        for (char c : text.toCharArray()){
           if (c == 'b' || c=='a' || c=='l'|| c=='o'|| c=='n'){
               charForBal.put(c,charForBal.getOrDefault(c,0)+1);
           }
        }

        String balloon = "balloon";

        for (char c: balloon.toCharArray()){
            if (!charForBal.containsKey(c)){
                return 0;
            }
        }

        return Math.min(Math.min(Math.min(charForBal.get('b'),charForBal.get('a')),Math.min(charForBal.get('l')/2,charForBal.get('o')/2)),charForBal.get('n'));







    }
}
