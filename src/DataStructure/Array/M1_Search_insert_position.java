package DataStructure.Array;

public class M1_Search_insert_position {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 5, 6, 6, 8, 9, 11};
        int n = nums.length;
        System.out.println("二分查找索引：" + binarySearchBasic(nums, 6, 0, n - 1));
        System.out.println("查找数字插入的索引：" + insertIndex(nums, 6, 0, n - 1));
        int[] range = searchRange(nums, 6);
        System.out.println("元素存在的索引范围为：[" + range[0] + "," + range[1] + "]");
        System.out.println("从数组中找出第一个大于目标元素的数的索引为：" + lowBoundIndex(nums, 6, 0, n - 1));
        System.out.println("从数组中找出最后一个小于目标元素的数的索引为：" + upperBoundIndex(nums, 6, 0, n - 1));
    }


    //——————————————————————————————————————————————————————————————————————————————————————————————————————————————————

    /**
     * 二分查找 —— 查找数组中是否存在某一个值
     * 如果存在，返回该值的位置
     * 如果不存在，返回 -1
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int binarySearchBasic(int[] nums, int target, int left, int right) {
        // 这里需要注意，循环条件是 <=，而不是 <
        while (left <= right) {
            // 这里需要注意，计算 mid 的时候
            // 不能使用 （left + right ）/ 2
            // 否则有可能会导致溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 这里需要注意，移动左指针
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 这里需要注意，移动右指针
                right = mid - 1;
            }
        }
        //没有找到该元素，返回 -1
        return -1;
    }

    /**
     * 二分查找 —— 递归写法
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                //查找成功
                return mid;
            } else if (nums[mid] > target) {
                //新的区间,左半区间
                return binarySearchRecursive(nums, target, left, mid - 1);
            } else if (nums[mid] < target) {
                //新的区间，右半区间
                return binarySearchRecursive(nums, target, mid + 1, right);
            }
        }
        //不存在返回-1
        return -1;
    }
    //——————————————————————————————————————————————————————————————————————————————————————————————————————————————————

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int insertIndex(int[] nums, int target, int left, int right) {
        // 这里需要注意，循环条件是 <=，而不是 <
        while (left <= right) {
            // 这里需要注意，计算 mid 的时候，不能使用 （left + right ）/ 2
            // 否则有可能会导致溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 这里需要注意，移动左指针
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 这里需要注意，移动右指针
                right = mid - 1;
            }
        }
        //没有找到该元素，返回 left
        return left;
    }
    //——————————————————————————————————————————————————————————————————————————————————————————————————————————————————

    /**
     * 排序数组中查找指定值的元素的第一个位置和最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int upper = upperBound(nums, target);
        int low = lowerBound(nums, target);
        //不存在情况
        if (upper < low) {
            return new int[]{-1, -1};
        }
        return new int[]{low, upper};
    }

    /**
     * 计算第一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    static int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                //当目标值小于等于nums[mid]时，继续在左区间检索，找到第一个数
                right = mid - 1;
            } else if (target > nums[mid]) {
                //目标值大于nums[mid]时，则在右区间继续检索，找到第一个等于目标值的数
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 计算最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    static int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target >= nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return right;
    }
    //——————————————————————————————————————————————————————————————————————————————————————————————————————————————————

    /**
     * 从数组中找出第一个大于目标元素的数的索引
     * 如果不存在，返回 -1
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int lowBoundIndex(int[] nums, int target, int left, int right) {
        while (left <= right) {
            //求中间值
            int mid = left + ((right - left) >> 1);
            //大于目标值的情况
            if (nums[mid] > target) {
                //返回 mid
                if (mid == 0 || nums[mid - 1] <= target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
        //所有元素都小于目标元素
        return -1;
    }

    /**
     * 从数组中找出最后一个小于目标元素的数的索引
     * 如果不存在，返回 -1
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int upperBoundIndex(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            //小于目标值
            if (nums[mid] < target) {
                //看看是不是当前区间的最后一位，如果当前小于，后面一位大于，返回当前值即可
                if (mid == right || nums[mid + 1] >= target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        //没有查询到的情况
        return -1;
    }


}
