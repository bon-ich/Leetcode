import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Problems {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int counter = 1;
        int placeholder = 999;

        int temp = 0;
        int uniqueIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != temp && nums[j] != placeholder) {
                    uniqueIndex++;
                    int temp2 = nums[j];
                    nums[uniqueIndex] = temp2;
                    counter++;
                    break;
                } else {
                    nums[j] = placeholder;
                }
            }
        }
        return counter;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reverse = 0;
        double temp = x;
        int i = 1;
        int length = String.valueOf(x).length();
        while (temp != 0) {
            temp = temp / 10;
            int integer = (int) temp;
            double fractional = (double) Math.round((temp - integer) * 100) / 100;
            if (i == 1 && fractional == 0) {
                return false;
            }
            reverse += fractional * Math.pow(10, length - i + 1);
            temp = integer;
            i += 1;
        }
        return x == reverse;
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> romans = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};

        int result = 0;
        String previousLetter = "";
        String[] s1 = s.split("");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (Objects.equals(s1[i], "I") && (Objects.equals(previousLetter, "V") | Objects.equals(previousLetter, "X"))) {
                result -= romans.get("I");
            } else if (Objects.equals(s1[i], "X") && (Objects.equals(previousLetter, "L") | Objects.equals(previousLetter, "C"))) {
                result -= romans.get("X");
            } else if (Objects.equals(s1[i], "C") && (Objects.equals(previousLetter, "D") | Objects.equals(previousLetter, "M"))) {
                result -= romans.get("C");
            } else {
                result += romans.get(s1[i]);
            }
            previousLetter = s1[i];
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        String longestPrefix = "";
        int round = 1;
        int count = 0;
        while (round <= strs[0].length()) for (int i = 0; i < strs.length; i++) {
            String temp = strs[0].substring(0, round);
            if (strs[i].startsWith(temp)) {
                count++;
            }
            if (i == strs.length - 1) {
                if (count == strs.length) {
                    longestPrefix = temp;
                    round++;
                    count = 0;
                } else {
                    return longestPrefix;
                }
            }
        }
        return longestPrefix;
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        String openBrackets = "([{";
        String closeBrackets = ")]}";
        Stack<String> stack = new Stack<String>();
        String[] parenthesis = s.split("");
        for (String p : parenthesis) {
            System.out.println("bracket: " + p);
            if (openBrackets.contains(p)) {
                stack.push(p);
            } else {
                if (stack.isEmpty())
                    return false;
                int index = closeBrackets.indexOf(p);
                if (Objects.equals(stack.peek(), openBrackets.substring(index, index + 1))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            System.out.println("stack: " + stack.toString());
        }
        return stack.isEmpty();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else if (list1.val < list2.val)
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        else
            return new ListNode(list2.val, mergeTwoLists(list2.next, list1));
    }

}
