import java.util.*;

public class ProdOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];

        int leftProduct = 1;
        for(int i=0; i<nums.length; i++){
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for(int i=nums.length-1; i>=0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}