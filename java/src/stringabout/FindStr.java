package stringabout;

//lintcode 13题
public class FindStr {
    /**
     * 暴力法
     *
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStrViolent(String source, String target) {
        // Write your code here
        for (int i = 0; i <= source.length() - target.length(); i++) {
            int j = 0;
            boolean flag = true;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 超级算法
     *
     * @return
     */
    public static int strStr(String source, String target) {
        if (target.length() == 0) {
            return 0;
        }

        //find the first letter of target
        int start = 0;
        for (start = 0; start < source.length(); start++) {
            if (source.charAt(start) == target.charAt(0)) break;
        }

        if (start == source.length()) {
            return -1;
        }

        //calculate sum_diff from source and target by using left and right pointers.
        int left = start;
        int right = 0;

        int sum_diff = 0;
        boolean equal_flag = true;
        while (left < source.length() && right < target.length()) {
            sum_diff += source.charAt(left);
            sum_diff -= target.charAt(right);
            equal_flag &= (source.charAt(left++) == target.charAt(right++));
        }

        //judge if corresponding to our need.
        if (right < target.length()) {
            return -1;
        } else if (equal_flag) {
            return start;
        }

        //if it doesn't meet our need, we should use a window to find the first position.
        //再来双指针，相当于一个窗口
        int sub_start = 0;
        for (sub_start = start; left < source.length(); left++) {
            sum_diff -= source.charAt(sub_start++);
            sum_diff += source.charAt(left);

            //滑动窗口判断
            if (sum_diff == 0 && source.charAt(sub_start) == target.charAt(0)
                    && (source.substring(sub_start, sub_start + target.length()).equals(target))
            ) {
                return sub_start;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String a = "abcdessewsacb";
        String c = "acb";
        System.out.println(strStr(a, c));
    }


}
