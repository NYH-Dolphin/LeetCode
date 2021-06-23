package DataStructure.Array;

public class E1_Find_the_central_index_of_the_array {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int num : nums) {
            sumRight += num;
        }

        // 数组只有一个元素
        if(nums.length == 1){
            return 1;
        }

        // 从下标为 0 的数组开始考虑
        sumRight -= nums[0];
        if(sumLeft == sumRight){
            return 0;
        }

        // 移动下标
        for(int i = 1; i < nums.length; i++){
            sumLeft += nums[i - 1];
            sumRight -= nums[i];
            if(sumLeft == sumRight){
                return i;
            }
        }

        return -1;
    }
}
