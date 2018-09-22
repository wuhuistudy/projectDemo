package net.syntrust.demo.SortCollections;

/**
 * 冒泡排序
 *
 * @author wuhui
 * @version C10 2018/9/19
 * @since SDP V300R003C10
 */
public class BubbleSort
{
    /**
     * @return void
     * @Author wuhui
     * @Description 冒泡排序
     * @Date 2018/9/19
     * @Param [arr]
     **/
    public static void bubb(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - i - 1; j++)
            {
                int temp;
                if (arr[j] > arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
// 大概的逻辑: 例,从第一个数开始,将其与相邻的数(从左到右也就是第二个数)进行比较,如果第一个数较大,将第一个数与第二个数作交换,
// 再将交换后的第二个数与第三个数作比较(如果第二个数大于第一个数,那就直接拿第二个数跟第三个数做比较);以此类推;
// 每次循环都会将最大的那个数拿到放到后面(就是第一次拿到的是最大的那个数,第二次循环拿到的是倒数第二大的那个数...)