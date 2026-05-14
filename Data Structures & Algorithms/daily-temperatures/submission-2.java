class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            while (j < temperatures.length && temperatures[j] <= temperatures[i]) {
                j++;
            }
            if (j < temperatures.length) {
                res[i] = j - i;
            } else {
                res[i] = 0;
            }
        }

        return res;

    }
}

//brute force
// two for loop, iterate temperature, second loop look for greater value
// record the range and return the recorded range array.

//stack
// int[] pair:[temperature, index]
