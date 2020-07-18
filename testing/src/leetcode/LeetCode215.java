package leetcode;

import 排序.QucklySort;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author pengwei
 * @date 2020/6/29
 */
public class LeetCode215 {

    public static void main(String[] args) {
        int k = 4;
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = findKthLargest2(nums, k);
        System.out.println(kthLargest);
    }

    public static int findKthLargest1(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k < 1 || k > length) {
            return 0;
        }
        /**
         * 1、冒泡排序
         * 2、快速选择排序
         */
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[length - k];
    }
    public static int findKthLargest2(int[] nums, int k){
        int i=0;
        int j=nums.length-1;
        QucklySort.quickSort(nums,i,j);
        return nums[nums.length - k];
    }

}
