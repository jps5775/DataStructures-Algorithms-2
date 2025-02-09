package DataStructures;

public class MyArrayList {
    int[] arr;
    int currIndex;

    public MyArrayList(int size){
        arr = new int[size];
    }

    public void add(int val){
        if(currIndex == arr.length){ resize(); }

        arr[currIndex] = val;
        currIndex++;
    }

    public int get(int index){
        return index >= arr.length || index < 0 ? -1 : arr[index];
    }

    private void resize(){
        int[] newArray = new int[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            newArray[i] = arr[i];
        }

        this.arr = newArray;
    }
}
