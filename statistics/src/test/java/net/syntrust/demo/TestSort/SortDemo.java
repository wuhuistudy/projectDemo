package net.syntrust.demo.TestSort;

import net.syntrust.demo.SortCollections.SelectionSort;
import net.syntrust.demo.Utils.ArrayOutUtils;

/**
 * 排序测试
 *
 * @author wuhui
 * @version C10 2018/9/19
 * @since SDP V300R003C10
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 6, 9, 7, 3, 89, 33, 44, 20, 14};
        // 冒泡排序
        //BubbleSort.bubb(arr);
        //选择排序
        SelectionSort.sele(arr);
        // 控制台输出
        ArrayOutUtils.soutMethod(arr);
    }
}
