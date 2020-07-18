package 排序;

/**
 * 快速排序
 *
 * @author pengwei
 * @date 2020/6/29
 */
public class QucklySort {
    public static void main(String[] args) {

        int[] a = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        //57
        int i = 0;
        int j = a.length - 1;
        quickSort(a, i, j);

        for (int value : a) {
            System.out.print(value + ",");
        }


    }

    static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }


    public static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int temp = a[i];

            while (i < j) {

                while (i < j && temp <= a[j]) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;

                }
                while (i < j && temp > a[i]) {
                    i++;

                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }

            }
            a[i] = temp;
            quickSort(a, start, i - 1);
            quickSort(a, i + 1, end);

        }


    }

}
