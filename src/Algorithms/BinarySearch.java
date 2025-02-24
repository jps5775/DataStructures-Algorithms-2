package Algorithms;

public class BinarySearch {
    int[] arr;

    public BinarySearch(int n){
        arr = new int[n];
    }

    public int binarySearch(int target){
        if(arr == null){ return -1; }

        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearchRecursively(int target){
        return binarySearchRecursively(target, 0, arr.length - 1);
    }

    public int binarySearchRecursively(int target, int left, int right){
        if(left > right){ return -1; }

        int mid = (left + right) / 2;

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return binarySearchRecursively(target, mid + 1, right);
        }else{
            return binarySearchRecursively(target, left, mid -1);
        }
    }
}
