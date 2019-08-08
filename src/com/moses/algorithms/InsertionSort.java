package com.moses.algorithms;

/**
 * 插入排序
 * 每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 */
public class InsertionSort {

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    SortUtil.swap(array, j, j - 1);
                } else {
                    break;
                }
            }
            SortUtil.display(array);
        }
        return array;
    }

    /**
     * 减少swap次数
     *
     * @param array
     * @return
     */
    public static int[] betterSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];     //要插入的数据
            int j = i;
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
            SortUtil.display(array);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 6, 1, 2, 9, 7, 8, 4, 0};
        System.out.println("未排序数组顺序为: ");
        SortUtil.display(array);
        System.out.println("-------------------------------");
        betterSort(array);
        System.out.println("-------------------------------");

        System.out.println("排序后数组顺序为: ");
        SortUtil.display(array);
    }
}
