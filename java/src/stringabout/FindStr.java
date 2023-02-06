package stringabout;

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
}
