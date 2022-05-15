package com.learn;

public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome sh=new ShortestPalindrome();
        System.out.println(sh.shortestPalindrome("aacecaaa"));
    }
    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);

        //get the maximum palin part in s starts from 0
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public int[] getTable(String s){
        int[] table = new int[s.length()];

        int index = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
                table[i] = table[i-1] + 1;
                index ++;
            }else{


                index = table[i-1];
                while(index > 0 && s.charAt(index) != s.charAt(i)){
                    index = table[index-1];
                }
               if(s.charAt(index) == s.charAt(i)){
                    index ++ ;
                }

                table[i] = index;
            }

        }

        return table;
    }
}
