package net.syntrust.demo.Utils;

/**
 * @author wuhui
 * @version C10 2018/9/19
 * @since SDP V300R003C10
 */
public class ArrayOutUtils {
    /**
     * @return void
     * @Author wuhui
     * @Description //数组控制台输出
     * @Date 2018/9/19
     * @Param [arr]
     **/
    public static void soutMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[" + arr[i] + ",");
            } else if (i == arr.length - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
}
