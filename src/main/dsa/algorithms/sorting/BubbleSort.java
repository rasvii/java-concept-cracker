package src.main.dsa.algorithms.sorting;

public class BubbleSort {
    
    public static void main(String[] args) {
        int[] toSort = new int[]{6, 4, 2, 7, 9, 3, 67, 32, 87, 43, 7, 23};

        System.out.print("To sort:  ");
        for(int i =0; i< toSort.length;i++){
            System.out.print(toSort[i] + " ");
        }
        
        int[] sortedAsc = bubbleSortAsc(toSort);

        System.out.println("Sorted:  ");
        for(int i =0; i< sortedAsc.length;i++){
            System.out.print(sortedAsc[i] + " ");
        }

        int[] sortedDsc = bubbleSortDsc(toSort);

        System.out.println("Sorted:  ");
        for(int i =0; i< sortedDsc.length;i++){
            System.out.print(sortedDsc[i] + " ");
        }

    }
    
    
    private static int[] bubbleSortAsc(int[] toSort){
        int temp = 0;
        for(int i = 0; i < toSort.length; i++){
            for(int j = 0; j < toSort.length - 1 - i; j++){
                if (toSort[j] > toSort[j+1]) {
                    temp = toSort[j];
                    toSort[j] = toSort[j+1];
                    toSort[j+1] = temp;
                }
            }
        }
        
        return toSort;
    }

    private static int[] bubbleSortDsc(int[] toSort){
        int temp = 0;
        for(int i = 0; i < toSort.length; i++){
            for(int j = 0; j < toSort.length - 1 - i; j++){
                if (toSort[j] < toSort[j+1]) {
                    temp = toSort[j];
                    toSort[j] = toSort[j+1];
                    toSort[j+1] = temp;
                }
            }
        }

        return toSort;
    }

}
