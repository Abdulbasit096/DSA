package Arrays_Strings;

import java.util.*;

public class Solution {
    public int findClosestNumber(int[] nums) {
        int max = nums[0];
        int diff = Math.abs(nums[0]);
        for (int i=1; i<nums.length; i++){
            if (diff > Math.abs(nums[i])){
                diff = Math.abs(nums[i]);
                max = nums[i];
            }
            if (diff == Math.abs(nums[i]) && nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
    public String mergeAlternately(String word1, String word2) {
        StringBuilder newStr = new StringBuilder();
        int n = Math.max(word1.length(),word2.length());
        int i=0;
        while (i < n){
            if (i < word1.length()){
                newStr.append(word1.charAt(i));

            }
            if (i < word2.length()){
                newStr.append(word2.charAt(i));

            }
            i++;
        }
        return newStr.toString();
    }
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanNums = new HashMap<Character,Integer>();
        romanNums.put('I' , 1);
        romanNums.put('V' , 5);
        romanNums.put('X' , 10);
        romanNums.put('L' , 50);
        romanNums.put('C' , 100);
        romanNums.put('D' , 500);
        romanNums.put('M' , 1000);


        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1 && romanNums.get(s.charAt(i)) < romanNums.get(s.charAt(i+1))){
                num -= romanNums.get(s.charAt(i));
            }else{
                num+= romanNums.get(s.charAt(i));
            }

        }

        return num;
    }
    public boolean isSubsequence(String s, String t) {
        int sp = 0,tp = 0;

        while(sp < s.length() && tp< t.length()){
            if(s.charAt(sp) == t.charAt(tp)){
                sp++;
            }
            tp++;
        }
        return sp==s.length();
    }
    public int maxProfit(int[] prices) {
        int buysAt = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<buysAt){
                buysAt = prices[i];
            }
            if (profit<Math.max((prices[i]-buysAt),profit)){
                profit = prices[i]-buysAt;
            }

        }
        return profit;
    }
    public String longestCommonPrefix(String[] strs) {
        StringBuilder newStr = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        for (int i=0; i<Math.min(first.length(),last.length());i++){
            if (first.charAt(i) != last.charAt(i)){
                return newStr.toString();
            }
            newStr.append(first.charAt(i));
        }


        return newStr.toString();
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i]) {
                ranges.add(String.valueOf(start + "->" + nums[i]));
            } else {
                ranges.add(String.valueOf(start));
            }
            i++;
        }
        return ranges;

    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,1);

        int pre = 1;
        for (int i=0; i<nums.length; i++){
            res[i] = pre;
            pre *= nums[i];
        }

        int post = 1;
        for (int i=nums.length-1; i>=0; i--){
            res[i] *= post;
            post *= nums[i];
        }
    return res;
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(intervals[0]);


        for (int[] interval : intervals){
            if (interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }else{
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();

        int left = 0;
        int top = 0;
        int right = matrix[left].length-1;
        int bottom = matrix.length-1;

        while (top <= bottom && left<=right) {
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {


            for (int i = bottom; i >= top; i--) {
                spiral.add(matrix[i][left]);
            }
            left++;
        }
        }



        return spiral;

    }

    public int[][] rotateImage(int[][] matrix){
        for (int i =0; i<matrix.length; i++){
            for (int j=i; j<matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i =0; i<matrix.length; i++){
            int rowStart = 0;
            int rowEnd = matrix.length-1;
            while (rowStart<=rowEnd){
                int temp = matrix[i][rowStart];
                matrix[i][rowStart] = matrix[i][rowEnd];
                matrix[i][rowEnd] = temp;
                rowEnd--;
                rowStart++;
            }


        }


        return matrix;
    }



}
