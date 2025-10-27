
    import java.util.Arrays;

public class CodingChallenge{
    public static int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        // Merge both arrays using two-pointer technique
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        // Copy remaining elements, if any
        while (i < n) {
            merged[k++] = nums1[i++];
        }
        while (j < m) {
            merged[k++] = nums2[j++];
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        int[] result = merge(nums1, nums2);
        System.out.println("Merged Array: " + Arrays.toString(result));
    }
}

