package net.syntrust.demo.SortCollections;


/**
 * 选择排序
 *
 * @author wuhui
 * @version C10 2018/9/19
 * @since SDP V300R003C10
 */
public class SelectionSort {
    /**
     * @return void
     * @Author wuhui
     * @Description //选择排序
     * @Date 2018/9/20
     * @Param [arr]
     **/
    public static void sele(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp;
                if (arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
//：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
// 也就是：每一趟在n-i+1(i=1，2，…n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。