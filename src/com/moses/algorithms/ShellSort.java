package com.moses.algorithms;

/**
 * 希尔排序
 * 基于插入排序，先大间隔排，然后小间隔，最后插入排序
 * 空间复杂度为常量O(1)（内部是插入排序）
 * 最坏情况和平均时间复杂度都是O(nlog2 n)，最好情况不确定
 */
public class ShellSort {

    //希尔排序 knuth 间隔序列  3h+1
    public static void knuthShellSort(int[] array) {
        SortUtil.display(array);
        int step = 1;
        int len = array.length;
        while (step <= len / 3) {       //3h+1 取间隔, knuth间隔序列
            step = step * 3 + 1;      //1, 4, 13, 40
        }

        while (step > 0) {
            //分别对每个间隔进行排序
            for (int i = step; i < len; i++) {

                //对array[i], array[i-step], array[i-2*step], array[i-3*step] ... 使用插入排序
                int tmp = array[i];
                int j = i;
                while (j > step - 1 && tmp <= array[j - step]) {
                    array[j] = array[j - step];
                    j -= step;
                }
                array[j] = tmp;
            }
            System.out.println("间隔为" + step + "的排序结果为: ");
            SortUtil.display(array);
            step = (step - 1) / 3;
        }

        System.out.println("最终结果为:");
        SortUtil.display(array);
    }

    //希尔排序 间隔序列2h
    public static void shellSort(int[] array) {
        SortUtil.display(array);
        int step;
        int len = array.length;
        for (step = len / 2; step > 0; step /= 2) {
            for(int i = step; i < array.length; i++){
                int j = i;
                int tmp = array[j];
                if(array[j] < array[j-step]){
                    while(j-step >= 0 && tmp < array[j-step]){
                        array[j] = array[j-step];
                        j -= step;
                    }
                    array[j] = tmp;
                }
            }
            System.out.println("间隔为" + step + "的排序结果为: ");
            SortUtil.display(array);
        }
        System.out.println("最终结果为:");
        SortUtil.display(array);
    }


    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 8, 9, 5, 7, 6, 1, 3, 10};
        shellSort(array);
    }
}
