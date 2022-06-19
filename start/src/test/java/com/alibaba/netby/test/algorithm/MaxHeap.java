package com.alibaba.netby.test.algorithm;

import java.util.Arrays;

/**
 * @Description 堆排序
 * @Author byg
 * @Date 2021/11/5 8:01
 * @Version 0.1
 * @see `https://www.cnblogs.com/neuzk/p/9476419.html`
 **/
public class MaxHeap {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 6, 1, 12, 10, 7};
        sortHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void sortHeap(int[] arr) {
        //构建最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //首位交换，并重新调整堆结构
        for (int j = arr.length - 1; j >= 0; j--) {
            //交换
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //继续调整
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 调整最大堆
     *
     * @param arr    原数组
     * @param i      当前需要调整的节点的编号
     * @param length 剩余节点的个数
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//当前节点的值
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //获取当前节点的孩子节点的最大值
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k = k + 1;
            }
            //如果孩子节点更大，则把最大的孩子节点的值赋值给父节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else break; //说明当前节点往下都不需要调整了
        }
        arr[i] = temp;
    }
}
