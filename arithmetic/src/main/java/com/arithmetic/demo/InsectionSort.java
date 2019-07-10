package com.arithmetic.demo;

import java.util.Arrays;

public class InsectionSort {

    /**
     * @Description: 插入排序
     * 时间复杂度O(n²)【两个for循环】,空间复杂度O(1)【temp临时变量一个】
     * 稳定的
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 7, 4, 2, 100, 98, 70, 90};


        for (int i = 0; i < arr.length - 1; i++) { // 从第一个开始循环，拿到前两个数，倒着循环，如果前一个数大于后一个就交换。
            for (int j = i+1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
