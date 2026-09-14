class Solution {
    public void reverseArray(int arr[]) {
        int left = 0; 
        int right = arr.length -1 ;

        while(left < right){
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];

            left++;
            right--;
        }

    }
}