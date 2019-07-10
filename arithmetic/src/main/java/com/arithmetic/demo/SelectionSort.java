package com.arithmetic.demo;

import java.util.Arrays;

public class SelectionSort {

    /**
     * @Description: 快速排序
     * 时间复杂度O(n²)【两个for循环】,空间复杂度O(1)【temp临时变量一个】
     * 不稳定
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 7, 4, 2};

        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) { // 从第一个和第二个开始比较，如果小余，就赋值给minPos，然后继续。循环完之后交换。
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }
}
