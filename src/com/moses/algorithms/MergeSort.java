package com.moses.algorithms;

/**
 * 递归实现归并排序
 * 将数组分两段，各自排序好，然后再合并起来
 */
public class MergeSort {

    public static int[] mergeSort(int[] c, int start, int last){
        if(last > start){       //边界条件，不可再拆
            int mid = start + (last-start)/2;       // (start+last)/2, 防止数字太大超过int最大值
            mergeSort(c, start, mid);
            mergeSort(c, mid+1, last);
            merge(c, start, mid, last);
            SortUtil.display(c);
        }
        return c;
    }

    //合并左右两个数组
    public static void merge(int[] c, int start, int mid, int last){
        int[] temp = new int[last-start + 1];
        int i = start;      //定义左边数组的下标
        int j = mid + 1;    //定义右边数组的下标
        int k = 0;
        while(i<=mid && j<=last){
            if(c[i] < c[j]){
                temp[k++] = c[i++];
            } else {
                temp[k++] = c[j++];
            }
        }

        //左边数组剩下的元素移入新数组中
        while(i<=mid){
            temp[k++] = c[i++];
        }

        //右边数组剩下的元素移入新数组中
        while(j<=last){
            temp[k++] = c[j++];
        }

        //新数组中的数覆盖到原数组c中
        for(int m=0; m < temp.length; m++){
            c[m+start] = temp[m];
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 6, 2, 1, 9, 7, 8, 4, 0};
        System.out.println("未排序数组顺序为: ");
        SortUtil.display(array);
        System.out.println("-------------------------------");
        mergeSort(array, 0, array.length-1);
        System.out.println("-------------------------------");

        System.out.println("排序后数组顺序为: ");
        SortUtil.display(array);
    }
}
