package com.alibaba.demo.test.algorithm;

/**
 * @Description 从1亿个数里面找出前100个最大的
 * @Author byg
 * @Date 2021/11/5 8:01
 * @Version 0.1
 * @see `https://blog.csdn.net/csdn15698845876/article/details/88409016`
 **/
public class MaxHeap_1 {
    public static void main(String[] args) {
        int n = 10000;
        int m = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        print(arr, n);
        for (int i = 0; i < m; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //剩下的n-m个数与堆顶元素依次比较，并调整堆结构
    public static void print(int[] arr, int m) {
        //把前m个数建成最小堆
        createSmallHeap(arr, m);
        //把剩下的arr.length-m个数字依次与最小堆的堆顶元素比较
        //如果比堆顶元素大，那么就替换为堆顶，然后对堆顶进行调整。
        //当所有的元素遍历一遍后，堆中元素就是前m个最大的。
        for (int i = m; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                arr[0] = arr[i];
                adjustHeap(arr, m, 0);
            }
        }
    }

    //新建堆
    public static void createSmallHeap(int[] arr, int m) {
        for (int i = m / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, m, i);
        }
    }

    //调整为最小堆
    public static void adjustHeap(int[] arr, int m, int i) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < m; k = 2 * k + 1) {
            if (k + 1 < m && arr[k + 1] < arr[k]) k++;
            if (temp > arr[k]) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }
}
