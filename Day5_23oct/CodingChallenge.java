import java.util.Arrays;

public class CodingChallenge {
    
    // Function to reverse a portion of the array from start to end indices
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array to the right by k steps
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // In case k is larger than n

        // Reverse entire array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining n-k elements
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original array: " + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("Array after " + k + " right rotations: " + Arrays.toString(nums));
    }
}
