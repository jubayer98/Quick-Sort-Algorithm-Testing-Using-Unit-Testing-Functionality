public class Quicksort  {
	private int[] numbers;
	private int number;
	public void sort(int[] values) { //S1
        // check for empty or null array
		if (values ==null || values.length==0){ //C1
            return; //S2
        }
		this.numbers = values; //S3
        number = values.length; //S4
        quicksort(0, number - 1); //S5
    }
	private void quicksort(int low, int high) {
		int i = low, j = high; //S6
        // get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2]; //S7
        // divide into two lists
		while (i <= j) { //C2
            // if the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
			while (numbers[i] < pivot) { //C3 
                i++; //S8
            }
            // if the current value from the right list is larger than the pivot
            // element then get the next element from the right list
			while (numbers[j] > pivot) { //C4
                j--; //S9
            }

            // if we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // as we are done we can increase i and j
			if (i <= j) { //C5
                exchange(i, j); //S10
                i++; //S11
                j--; //S12
            }
        }
        // recursion method
		if (low < j) //C6
            quicksort(low, j); //S13
        if (i < high) //C7
            quicksort(i, high); //S14
    }
	private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}