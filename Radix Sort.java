class Solution {
    static void radixSort(int arr[], int n) {
        int d = countDigits(arr);
        int mod = 1;

        while(d--!=0) {
            ArrayList<Integer>[] buckets = new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                buckets[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                int digit = (arr[i] / mod) % 10;
                buckets[digit].add(arr[i]);
            }

            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int num : buckets[i]) {
                    arr[index++] = num;
                }
            }
            mod *= 10;
        }
    }

    static int countDigits(int[] arr) {
        int maxDigits = 0;
        for (int num : arr) {
            maxDigits = Math.max(maxDigits, Integer.toString(num).length());
        }
        return maxDigits;
    }
}
