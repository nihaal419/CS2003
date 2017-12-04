package Algorithms;

public class sortAlgorithms {
	
	private static void merge(Comparable [] array, int first, int middle, int last) {
		int max = array.length;
		Comparable[] temp = new Comparable[max];
		int tempFirst1 = first;
		int tempLast1 = middle;
		int tempFirst2 = middle+1;
		int tempLast2 = last;
		
		int location = tempFirst1;
		
		while((tempFirst1 <= tempLast1) && (tempFirst2 <= tempLast2)) {
			if(array[tempFirst1].compareTo(array[tempFirst2]) < 0) {
				temp[location] = array[tempFirst1];
				tempFirst1++;
			}
			else {
				temp[location] = array[tempFirst2];
				tempFirst2++;
			}
			location++;
		}
		
		while(tempFirst1 <= tempLast1) {
			temp[location] = array[tempFirst1];
			tempFirst1++;
			location++;
		}
		
		while(tempFirst2 <= tempLast2) {
			temp[location] = array[tempFirst2];
			tempFirst2++;
			location++;
		}
		
		for(location = first; location <= last; location++) {
			array[location] = temp[location];
		}
	}
	
	public static void mergeSort(Comparable [] array, int first, int last) {
		if(first < last) {
			int mid = (first+last)/2;
			
			mergeSort(array, first, mid);
			
			mergeSort(array, mid+1, last);
			
			merge(array, first, mid, last);
		}
	}
	
	public static void bubbleSort(Comparable [] array, int a) {
		boolean isSorted = false;
		for(int i=1; i<a && !isSorted; i++) {
			isSorted = true;
			for(int j=0; j<a-i; j++) {
				int next = j++;
				if(array[j].compareTo(array[next]) > 0) {
					Comparable tmp = array[j];
					array[j] = array[next];
					array[next] = tmp;
					isSorted = false;
				}
			}
		}
	}
	
	public static void insertionSort(Comparable [] array, int a) {
		for(int i = 1; i<a; i++) {
			Comparable next = array[i];
			int location = i;
			while((location > 0) && (array[location-1].compareTo(next) > 0)) {
				array[location] = array[location-1];
				location--;
			}
			array[location] = next;
		}
	}
	
	private static int indexOfLargest(Comparable [] array, int size) {
		int largest = 0;
		
		for(int i=1; i<size; i++) {
			if(array[i].compareTo(array[largest]) > 0) {
				largest = i;
			}
		}
		
		return largest;
	}
	
	public static void selectionSort(Comparable [] array, int a) {
		for(int i = a-1; i>=1; i--) {
			int largest = indexOfLargest(array, i+1);
			
			Comparable tmp = array[largest];
			
			array[largest] = array[i];
			array[i] = tmp;
		}
	}
	
	private static void swap(Comparable [] array, Comparable a, Comparable b, int loca, int locb) {
		array[loca] = b;
		array[locb] = a;
	}
	
	private static int partition(Comparable [] array, int low, int high) {
		int pivot = high-1;
		int pIndex = 0;
		
		for(int i = 0; i<high-1; i++) {
			if(array[pivot].compareTo(array[i]) > 0) {
				swap(array, array[i], array[pIndex], i, pIndex);
				pIndex++;
			}
		}
		swap(array, array[pIndex], array[pivot], pIndex, pivot);
		return pIndex;
	}
	
	public static void quicksort(Comparable [] array, int low, int high) {
		if(low >= high) {
			return;
		}
		int pivot = partition(array, low, high);
		quicksort(array, low, pivot-1);
		quicksort(array, pivot+1, high);
	}
}