package com.czz.optimization.sort;

import java.util.Arrays;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-16 11:39
 */
public class InsertSort {


    public static void main(String[] args) {
        interSort ();
        dichotomizeInsertSort();
        long startTime = System.nanoTime(); // 获取排序结束时间
        quickSort(new int[]{1, 4, 5, 67, 2, 7, 8, 6, 9, 44},0,9);
        long endTime = System.nanoTime(); // 获取排序结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

    }

    /**
     * 插入排序   直接插入排序
     * 最差的时间复杂度 O(2n)
     */
    private static void interSort() {
        //定义一个长度为10的数组
        int[] a = { 1, 3, 4, 2, 6, 7, 8, 0, 5 };
        int i,j;
        long startTime = System.nanoTime(); // 获取排序开始时间
        for( i=1;i<a.length;i++) { // 遍历元素
            int temp=a[i]; // 轮询取出数组中的元素
            // 插入排序 即时把无序的队列插入到有序的队列之中
            // j=i-1;
            for( j = i-1;j>=0&&temp<a[j];j--) {// 如果临时元素小于被比较元素 交换位置 一直到数组遍历结束
                a[j+1]=a[j];
            }
            a[j+1]=temp;
        }
        long endTime = System.nanoTime(); // 获取排序结束时间
        System.out.println("排序結果:" + Arrays.toString(a));
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }


    public static void dichotomizeInsertSort(){
        //定义一个长度为10的数组
        int[] arr = { 1, 3, 4, 2, 6, 7, 8, 0, 5 };
        long startTime = System.nanoTime(); // 获取排序开始时间
        for(int i=1;i<=arr.length-1;i++) {
            if(arr[i]<arr[i-1]) {
                int temp=arr[i];
                int low=0;
                int hight=i-1;
                while(low<=hight) {
                    int mid=(low+hight)/2;
                    if(temp<arr[mid]) {
                        hight=mid-1;
                    }else {
                        low=mid+1;
                    }
                }
                for(int j=i-1;j>=low;j--) {
                    arr[j+1]=arr[j];
                }
                arr[low]=temp;
            }
        }
        long endTime = System.nanoTime(); // 获取排序结束时间
        System.out.println("排序結果:" + Arrays.toString(arr));
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

    }


    /**
     * 快速排序
     *
     * @param arr
     * @param L   指向数组第一个元素
     * @param R   指向数组最后一个元素
     */
    public static void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;



        //支点
        int pivot = arr[(L + R) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            //寻找直到比支点大的数
            while (pivot > arr[i])
                i++;

            //寻找直到比支点小的数
            while (pivot < arr[j])
                j--;

            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。


        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j) {
            quickSort (arr, L, j);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R) {
            quickSort (arr, i, R);
        }


    }
}

