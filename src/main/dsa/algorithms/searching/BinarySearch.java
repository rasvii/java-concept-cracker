package src.main.dsa.algorithms.searching;

public class BinarySearch {
    
    public static void main(String[] args) {
        int[] numbers = new int[]{1,4,5,6,7,12,14,16,18,24,34,45};
        
        int index = binarySearch(numbers, 24);
        System.out.println("index = " + index);
    }
    
    private static int binarySearch(int[] numbers, int numToSearch){
        int low=0, high = numbers.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(numbers[mid] == numToSearch){
                return mid;
            }
            
            if(numbers[mid] <numToSearch){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
