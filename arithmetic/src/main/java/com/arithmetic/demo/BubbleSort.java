package com.arithmetic.demo;

import java.util.Arrays;

public class BubbleSort {

    /**
     * @Description: 冒泡排序
     * 时间复杂度O(n²)【两个for循环】,空间复杂度O(1)【temp临时变量一个】
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 7, 4, 2};

        for (int i = 0; i < arr.length-1; i++) {
            int max = i;
            for (int j = i+1; j < arr.length; j++) { //
                if (arr[max] < arr[i]) {
                    max = i;
                }
            }

            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            System.out.println("===========");
            System.out.println(Arrays.toString(arr));
        }
    }
}
