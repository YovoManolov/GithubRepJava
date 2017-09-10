public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,6,1,3,4};
        arr=  bubbleSort(arr);
        for(int i = 0;i<arr.length ;i++){
            System.out.println(arr[i]);
        }
    }
    public static int[] bubbleSort(int [] arr){
        int length = arr.length;
        for(int i = 0 ;i < length-1 ; i++){
            for(int j = 0; j< length- i -1 ; j ++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
