class BinarySearch {

    // Method to perform binary search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // Target is not present in the array
        return -1;
    }

    // Main method to test the binary search
    public static void main(String[] args) {
        int[] sortedArray = {2, 3, 4, 10, 40};
        int target = 10;

        int result = binarySearch(sortedArray, target);

        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element found at index: " + result);
        }

        // Additional test cases
        System.out.println("Test Case 1: " + binarySearch(sortedArray, 2)); // Should return 0
        System.out.println("Test Case 2: " + binarySearch(sortedArray, 40)); // Should return 4
        System.out.println("Test Case 3: " + binarySearch(sortedArray, 1)); // Should return -1
        System.out.println("Test Case 4: " + binarySearch(new int[]{}, 10)); // Should return -1
        System.out.println("Test Case 5: " + binarySearch(sortedArray, 5)); // Should return -1
    }
}
