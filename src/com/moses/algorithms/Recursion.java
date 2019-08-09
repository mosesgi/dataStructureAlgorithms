package com.moses.algorithms;

/**
 * 递归常见应用
 */
public class Recursion {

    /**
     * For循环方式 求阶乘 n!
     * n! = n * (n-1) * (n-2) * ... 1
     * 0! = 1
     * 1! = 1
     *
     * @param n
     * @return
     */
    public static int getFactorialFor(int n) {
        int result = 1;
        if (n < 0) {
            return -1;
        }
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    /**
     * 递归方式求阶乘 n! = n*(n-1) !
     *
     * @param n
     * @return
     */
    public static int getFactorial(int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            System.out.println(n + "! = 1");
            return 1;
        } else {
            System.out.println(n);
            int result = n * getFactorial(n - 1);
            System.out.println(n + "! = " + result);
            return result;
        }
    }

    /**
     * 二分查找
     * 从有序数组中找到key所在位置
     * 比中间值小，就在左边找，比中间值大，就在右边找
     *
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] array, int key, int low, int high) {
        int mid = (high - low) / 2 + low;
        if (key == array[mid]) {
            return mid;
        } else if (low > high) {  //查找不到，返回-1
            return -1;
        } else {
            if (key < array[mid]) {
                return binarySearch(array, key, low, mid - 1);
            }
            if (key > array[mid]) {
                return binarySearch(array, key, mid + 1, high);
            }
        }
        return -1;
    }

    /**
     * 汉诺塔
     */
    public static void hanoiTower(int dish, String from, String temp, String to){
        if(dish == 1){  //递归边界
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
        } else {
            hanoiTower(dish-1, from, to, temp); //A为初始塔座，B为目标塔座，C为中介塔座. 把n-1层搬到B
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);       //把最下面的第N层搬到C
            hanoiTower(dish-1, temp, from, to); //B为初始塔座，C为目标塔座，A为中介塔座. 把前面的n-1层从B搬到C
        }
    }




    public static void main(String[] args) {
//        int result = getFactorial(4);
//        System.out.println(result);
//
//        int[] arraySearch = new int[]{2, 8, 10, 14, 18, 20, 25, 30, 39, 48, 49, 55, 59, 70, 88, 90, 91, 93, 100};
//        System.out.println(binarySearch(arraySearch, 20, 0, arraySearch.length - 1));

        hanoiTower(4, "A", "B", "C");
    }
}
