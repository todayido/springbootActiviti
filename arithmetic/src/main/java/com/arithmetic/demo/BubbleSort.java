package com.arithmetic.demo;

import java.util.Arrays;

public class BubbleSort {

    /**
     * @Description: 冒泡排序
     * 时间复杂度O(n²)【两个for循环】,空间复杂度O(1)【temp临时变量一个】
     * 稳定的
     * 最右边开始--，从
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 7, 4, 2};

        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j,j+1);
                }
            }

            System.out.println(Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void findMax(int []arr, int i){
        for (int i1 = 0; i1 < i; i1++) {
            if (arr[i1]>arr[i1+1]) {
                swap(arr, i1, i1 + 1);
            }
        }
    }
}
