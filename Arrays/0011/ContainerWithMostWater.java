
public class ContainerWithMostWater {
    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;

        int resArea = 0;

        while(left < right){
            int width = right-left;
            int currentHeight = Math.min(height[left], height[right]);

            int area = width * currentHeight;

            resArea = Math.max(area, resArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return resArea;
    }
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
