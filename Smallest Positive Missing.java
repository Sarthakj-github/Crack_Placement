class Solution {
    // Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        int i = 0;
        while (i < size) {
            // Correct position for arr[i] is arr[i] - 1 (0-based index)
            if (arr[i] > 0 && arr[i] <= size && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with the element at its correct position
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
        // Check for the first missing positive number
        for (i = 0; i < size; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        // If all positions are filled correctly, return size + 1
        return size + 1;
    }
}
