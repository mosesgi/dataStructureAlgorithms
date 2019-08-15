package com.moses.algorithms;

/**
 * 选择排序
 * 每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 每次找到最小数，放在最左边，然后处理右边剩下的
 * 时间复杂度为O(n²) 无论是哪种情况，哪怕原数组已排序完成，它也将花费将近n²/2次遍历来确认一遍.
 * 空间复杂度为常量O(1)
 */
public class SelectionSort {
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;        //记录最小值元素的下标
                }
            }
            if (min != i) {     //如果i位置不是最小值，与m交换
                SortUtil.swap(array, min, i);
            }
            System.out.println("第" + (i + 1) + "次排序之后顺序：");
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
