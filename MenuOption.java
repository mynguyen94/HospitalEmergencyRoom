/*Name: My Nguyen
 Class: CS 146
 Due Date: 10/20/17
 Date Submitted: 10/20/17
 */

package Menu;

import java.util.Scanner;

import hospitalWaitingRoom.*;

public class MenuOption{
	
	public void Menu(){
						
		Scanner input = new Scanner(System.in);
		
		ReadFromFile file = new ReadFromFile();
		PriorityQueue heap = new PriorityQueue();
		
		file.randomNumber();
		
		PatientInfo patient = new PatientInfo();
		PatientInfo[] patients = file.readFile();
		
		int indexNumArray = 21;
		char repeat;
		String name;
		
		//Print the list of patient before building the heap
		System.out.printf("Unsorted list of patients \n");
		System.out.printf("---------------------------\n");
		heap.printHeap(patients);
		
		do{
		
		System.out.printf("Please chose one of the following options\n");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("1. Build max heap of patients\n");
		System.out.printf("2. Sorted list of patients\n");
		System.out.printf("3. See who currently being helped\n");
		System.out.printf("4. Add a new patient\n");
		
		System.out.printf("\nYour choice: ");
		int choice = input.nextInt();
		System.out.printf("\n");
		
		while(choice != 1 &&choice != 2 &&choice != 3 &&choice != 4)
		{
			System.out.printf("Invalid choice. Please enter again(from 1 to 4 only): ");
			choice = input.nextInt();
			System.out.printf("\n");
		}
			
		switch(choice){
			case 1:
				//Case 1. Build max heap of patients
				heap.BuildMaxHeap(patients);
				System.out.printf("List of patients after building max heap\n");
				System.out.printf("----------------------------------------\n");
				heap.printHeap(patients);
				break;
			case 2:
				//Case 2. print the list with priority
				heap.HeapSort(patients);
				System.out.printf("List of patients according to the priority numbers\n");
				System.out.printf("---------------------------------------------------\n");
				heap.printHeap(patients);
				break;
			case 3:
				//Case 3. Print the patient with most priority
				heap.BuildMaxHeap(patients);
				System.out.printf("We are helping patient: ");
				heap.HeapMaximum(patients).print();
				break;
			
			case 4:	
				//Case 4. Remove the most priority person		
				System.out.printf("Please enter a name: ");
				name = input.next();
				if(name != null){
				patient.setName(name);
				}
				patient.setNumber(file.numArray[indexNumArray]);
				heap.HeapExtractMax(patients);
				heap.MaxHeapInsert(patients, patient);
				heap.HeapSort(patients);
				System.out.printf("\nCurrent list of patients\n");
				System.out.printf("------------------------\n");
				heap.printHeap(patients);
			
				indexNumArray++;
				break;
		}//end switch
		
		System.out.printf("Do you want to chose another option? (y or n) ");
		repeat = input.next().charAt(0);
		
		}while(repeat == 'y' || repeat == 'Y');
		input.close();
		
	}//end Menu	

}//end MenuOption
