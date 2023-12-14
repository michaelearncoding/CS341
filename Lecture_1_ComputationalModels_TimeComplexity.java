import java.util.*;
//https://docs.google.com/document/d/1itCGW-LhvI7I80AC-YP5y1fc98Ikl38Vk22VrEKenmA/edit
// merge sort
// binary search
// 2 sum
// 3 sum 

public class ThreeSum {
    public static int[] threeSum(int[] nums, int c) {
        Arrays.sort(nums); // Sort the array in ascending order

        for (int i = 0; i < nums.length - 2; i++) { // Iterate through the array
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }

            int target = c - nums[i]; // Calculate the target value
            int left = i + 1; // Set the left pointer
            int right = nums.length - 1; // Set the right pointer

            while (left < right) { // Loop until the pointers meet
                int sum = nums[left] + nums[right]; // Calculate the sum of the current pair

                if (sum == target) { // If the sum is equal to the target
                    return new int[]{i, left, right}; // Return the indices of the triplet
                } else if (sum < target) { // If the sum is less than the target
                    left++; // Move the left pointer to the right
                } else { // If the sum is greater than the target
                    right--; // Move the right pointer to the left
                }
            }
        }

        return new int[]{-1, -1, -1}; // If no triplet is found, return {-1, -1, -1}
    }


    




    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 }; // Initialize the array
        int c = 0; // Set the target value
        int[] result = threeSum(nums, c); // Call the threeSum method
        System.out.println(Arrays.toString(result)); // Print the result
    }
}
