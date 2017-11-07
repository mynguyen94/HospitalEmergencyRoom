/*Name: My Nguyen
 Class: CS 146
 Due Date: 10/20/17
 Date Submitted: 10/20/17
 */

package hospitalWaitingRoom;

import java.util.*;

public class PriorityQueue {
	
	private int heapSize;
	
	public int getSize(){
		return heapSize;
	}
	
	public int getParent(int child){
			return (child-1) / 2;
	}
		
	public void swap(int index1, int index2, PatientInfo[] arr){
		PatientInfo temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public void MaxHeapify(PatientInfo[] array, int i){
		
		int largest = 0;
		
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left <= heapSize && array[left].getNumber() > array[i].getNumber()){
			largest = left;
		}
		else
			largest = i;
		
		if(right <= heapSize && array[right].getNumber() > array[largest].getNumber()){
			largest = right;
		}
		if(largest != i){
			swap(i, largest, array);		
			MaxHeapify(array, largest);
		}
		
	}//end MaxHeapify
	
	public void BuildMaxHeap(PatientInfo[] array){
		heapSize = array.length-1;
		
		for(int i = (array.length/2) - 1; i >= 0; i--){
			MaxHeapify(array, i);
		}
		
	}//end BuildMaxHeap
	
	public void HeapSort(PatientInfo[] array){
		
		BuildMaxHeap(array);
		for(int i = array.length-1; i >= 0; i--){
			//swap
			swap(0, i, array);
			heapSize = heapSize - 1;
			MaxHeapify(array, 0);					
		}
		Collections.reverse(Arrays.asList(array));
		
	}//end HeapSort
	
	public void MaxHeapInsert(PatientInfo array[], PatientInfo key){
		
		heapSize = heapSize + 1;
		
		double ninf = Double.NEGATIVE_INFINITY;
		array[heapSize].setNumber((int) ninf);
				
		HeapIncreaseKey(array, heapSize, key);	
			
	}//end MaxHeapInsert
	
	public void HeapIncreaseKey(PatientInfo[] array, int i, PatientInfo key){
		
		if(key.getNumber() < array[i].getNumber()){
			System.out.printf("Error. New key is smaller than current key.\n");
		}
		
		array[i].setNumber(key.getNumber()); 
		array[i].setName(key.getName());
		
		while(i > 0 && array[getParent(i)].getNumber() < array[i].getNumber()){
			swap(i, getParent(i), array);
			i = getParent(i);			
		}

	}//end HeapIncreaseKey
		
	public PatientInfo HeapExtractMax(PatientInfo[] array){
		
		heapSize = array.length-1;
		if(heapSize < 0){
			System.out.printf("Error. Heap is underflown\n");
		}
		PatientInfo max = new PatientInfo();
		
		max.setName(array[0].getName());
		max.setNumber(array[0].getNumber());
		
		array[0].setName(array[heapSize].getName());
		array[0].setNumber(array[heapSize].getNumber());
		
		--heapSize;
		MaxHeapify(array, 0);
		
		return max;
		
	}//end HeapExtractMax*
	
	public PatientInfo HeapMaximum(PatientInfo[] array){
		return array[0];
		
	}//end HeapMaximum
	
	public void printHeap(PatientInfo[] array){
		
		for(int i = 0; i < array.length; i++){
			System.out.print((i+1) + ". ");
			array[i].print();
		}		
		
		System.out.printf("\n");
	}//end printHeap
	
}// end Priority Queue
