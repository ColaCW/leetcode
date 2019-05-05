import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class leetcodeUtil {

    //两数之和
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    //整数反转
    public static int reverse(int x) {
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        sb = sb.reverse();
        if(sb.toString().indexOf("-") != -1){
            try {
                return Integer.parseInt("-"+sb.toString().substring(0,sb.toString().length()-1));
            } catch (NumberFormatException e) {
                return  0;
            }
        }else{
            try {
                return Integer.parseInt(sb.toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }

    //回文数
    public static boolean isPalindrome(int x) {
        //直接转为字符串
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        return sb.toString().equals(sb.reverse().toString());
//        不用字符串
//        if(x < 0){
//            return false;
//        }else{
//            Integer number = new Integer(x);
//            for (int i = 0; i < number.toString().length() / 2 + 1; i++) {
//                if (number.toString().charAt(i) != number.toString().charAt(number.toString().length() - 1 - i))
//                    return false;
//            }
//            return true;
//        }
    }

    //罗马数字转整数
    public static int romanToInt(String s) {
        int num = 0;
        if(s.indexOf("IV") != -1){
            s = s.replaceAll("IV",",4");
        }
        if(s.indexOf("IX") != -1){
            s = s.replaceAll("IX",",9");
        }
        if(s.indexOf("XL") != -1){
            s = s.replaceAll("XL",",40");
        }
        if(s.indexOf("XC") != -1){
            s = s.replaceAll("XC",",90");
        }
        if(s.indexOf("CD") != -1){
            s = s.replaceAll("CD",",400");
        }
        if(s.indexOf("CM") != -1){
            s = s.replaceAll("CM",",900");
        }
        s = s.replaceAll("I",",1");
        s = s.replaceAll("V",",5");
        s = s.replaceAll("X",",10");
        s = s.replaceAll("L",",50");
        s = s.replaceAll("C",",100");
        s = s.replaceAll("D",",500");
        s = s.replaceAll("M",",1000");
        String[] ss = s.split(",",-1);
        for(int i = 0;i<ss.length;i++){
            System.out.println("****"+ss[i]);
            System.out.println(ss[i] == "");
            if(!"".equals(ss[i])){
                num += Integer.parseInt(ss[i]);
            }
        }
        return num;
    }

    //最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return  strs[0];
        }else if(strs.length > 1){
            for(int i = 0;i<strs.length;i++){
                if(strs[i].equals("")){
                    return "";
                }
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i<strs[0].length();i++){
                boolean flag = true;
                for(int j = 1;j<strs.length;j++){
                    if(strs[j].length() < i+1  || strs[j].charAt(i) != strs[0].charAt(i)){
                        flag = false;
                    }
                }
                if(flag){
                    sb.append(strs[0].charAt(i));
                }else{
                    break;
                }
            }
            return sb.toString();
        }
        return "";
    }

    //有效的括号
    public static boolean isValid(String s) {
        if(!s.equals("")){
            if(s.length()%2 != 0){
                return false;
            }
            Stack<String> stack = new Stack<>();
            for(int i = 0;i<s.length();i++){
                if("({[".indexOf(s.charAt(i)) != -1){
                    stack.push(String.valueOf(s.charAt(i)));
                }else{
                    if(stack.empty()){
                        return false;
                    }
                    switch (String.valueOf(s.charAt(i))){
                        case "}":
                            if(!stack.peek().equals("{")){
                                return false;
                            }else{
                                stack.pop();
                            }
                            break;
                        case "]":
                            if(!stack.peek().equals("[")){
                                return false;
                            }else{
                                stack.pop();
                            }
                            break;
                        case ")":
                            if(!stack.peek().equals("(")){
                                return false;
                            }else{
                                stack.pop();
                            }
                            break;
                    }
                }
            }
            if(!stack.empty()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        isValid("()");
    }
}
