package main.java.sorting;

public class MergeSort {

    private static int[] input;
    private static int[] helper;

    public MergeSort(int[] arr) {
        input = arr;
        helper = new int[arr.length];
    }

    public static int[] mergeSort() {
        mergeSortHelper(0,input.length-1);
        return input;
    }

    private static void mergeSortHelper(int start, int end) {
        if (start < end) {
            int middle = start + (end -start)/2;
            mergeSortHelper(start, middle);
            mergeSortHelper(middle+1, end);
            merge(start, middle, end);
        }
    }

    private static void merge(int start, int middle, int end) {
        for(int i = start; i <= end; i++) {
            helper[i] = input[i];
        }
        int i = start, j = middle+1, k = start;
        while (i <= middle && j <= end) {
            if (helper[i] < helper[j]) {
                input[k] = helper[i];
                i++;
            }
            else {
                input[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            input[k] = helper[i];
            k ++;
            i ++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10,2,5,1,3,4,7,4,6};
        MergeSort mergeSort = new MergeSort(arr);
        System.out.println("\nInput : ");
        for (int c : arr) {
            System.out.print("\t" + c);
        }
        System.out.println("\nSorted output : ");
        for (int c : mergeSort.mergeSort()) {
            System.out.print("\t" + c);
        }
    }
}
