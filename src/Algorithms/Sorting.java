package Algorithms;

import java.util.Arrays;

public class Sorting {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right){
        if(left >= right){ return; }

        int mid = (left + right) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right);
    }

    private void merge(int[] nums, int left, int right){
        int mid = (left + right) / 2;
        int[] leftHalf = Arrays.copyOfRange(nums, left, mid + 1);
        int[] rightHalf = Arrays.copyOfRange(nums, mid + 1, right + 1);
        int leftHalfPtr = 0;
        int rightHalfPtr = 0;
        int index = left;

        while(leftHalfPtr < leftHalf.length && rightHalfPtr < rightHalf.length){
            if(leftHalf[leftHalfPtr] <= rightHalf[rightHalfPtr]){
                nums[index] = leftHalf[leftHalfPtr];
                leftHalfPtr++;
            }else{
                nums[index] = rightHalf[rightHalfPtr];
                rightHalfPtr++;
            }

            index++;
        }

        if(leftHalfPtr >= leftHalf.length){
            // copy rest of rightHalf into array
            System.arraycopy(rightHalf, rightHalfPtr, nums, index, rightHalf.length - rightHalfPtr);
        }
        if(rightHalfPtr >= rightHalf.length){
            // copy rest of leftHalf into array
            System.arraycopy(leftHalf, leftHalfPtr, nums, index, leftHalf.length - leftHalfPtr);
        }
    }
}
