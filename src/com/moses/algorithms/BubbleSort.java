package com.moses.algorithms;

/**
 * 冒泡排序
 * 时间复杂度 O(n²), 空间复杂度为常量O(1)
 */
public class BubbleSort {

    public static int[] sort(int[] array) {
        //表示总共需要比较多少轮
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;    //若为true, 则表示此次循环没有进行交换，也就是数组已经有序
            //每轮比较参与的元素。对当前无序区间array[0...length-i]进行排序
            for (int j = 0; j < array.length - i; j++) {    //因为每轮比较都会出现一个最大值放在最右边，所以每轮比较后的元素个数都会少一个，这也是为什么j的范围是逐渐减小的。
                if (array[j] > array[j + 1]) {
                    SortUtil.swap(array, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println("第" + i + "轮排序后的结果为: ");
            SortUtil.display(array);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 6, 1, 2, 9, 7, 8, 4, 0};
        System.out.println("未排序数组顺序为: ");
        SortUtil.display(array);
        System.out.println("-------------------------------");
        array = sort(array);
        System.out.println("-------------------------------");

        System.out.println("排序后数组顺序为: ");
        SortUtil.display(array);
    }
}
