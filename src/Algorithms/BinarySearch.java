package Algorithms;

public class BinarySearch {
    int[] arr;

    public BinarySearch(int n){
        arr = new int[n];
    }

    // e.g. nums = [ 4, 5, 5, 6 ] target = 5
    //             [ F  T  T  T ]

    // e.g. nums = [ 1, 2, 3, 4 ] target = 5 => value doesn't exist
    //             [ F  F  F  F ] => returns

    // e.g. nums = [ 11, 12, 15, 20 ] target = 5
    //             [ T   T   T   T ] => returns 0
    public int binarySearchFirstValueGreaterOrEqualToTarget(int target){
        int left = 0;
        int right = arr.length - 1;
        int ans = -1; // if there is no value >= target
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target){
                ans = mid;
                right = mid - 1; // search for smaller value, so I get the first value >= target
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    public int binarySearchFirstValueLessThanOrEqualToTarget(int target){
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] <= target){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
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
