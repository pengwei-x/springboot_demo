package leetcode;

/**
 * 求两个数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 * @author pengwei
 * @date 2020/4/17
 */
public class leetCode04 {

    public static void main(String[] args) {
        int[] a=new int[]{1,3,4,9};
        int[] b=new int[]{1,2,3,4,5,6,7,8,9,10};
        double middleNum = getMiddleNum(a, b);
        System.out.println(middleNum);

//        double medianSortedArrays = findMedianSortedArrays(a, b);
//        System.out.println(medianSortedArrays);
    }

    private static double getMiddleNum(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        int len=n+m;
        int left=-1,right=-1;
        int strat1=0,start2=0;
        for(int i=0;i<=len/2;i++){
            left=right;
            if(strat1< n && (start2>=m || a[strat1] <b[start2] )){
                right=a[strat1++];
            } else{
                right=b[start2++];
            }
        }
        if((len%2)==0){
            return (left + right) / 2.0;
        }else{
            return right;
        }
    }


    /**
     * 求K小数思维
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        int kth1 = getKth(nums1, 0, n - 1, nums2, 0, m - 1, left);
        int kth2 = getKth(nums1, 0, n - 1, nums2, 0, m - 1, right);
        return (kth1+kth2)*0.5;
       // return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
