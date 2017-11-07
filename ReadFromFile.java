/*Name: My Nguyen
 Class: CS 146
 Due Date: 10/20/17
 Date Submitted: 10/20/17
 */

package hospitalWaitingRoom;

import java.io.*;
import java.util.*;

public class ReadFromFile {
	
	public Integer[] numArray = new Integer[30];
	//create an array of 20 students
	public  PatientInfo[] info = new PatientInfo[20];
	
	public void randomNumber(){
		
		for(int i = 0; i < 30; i++){
			numArray[i] = i+1;
		}
		
		//shuffle the array
		Collections.shuffle(Arrays.asList(numArray));		
	}
	
	public void setPatients(PatientInfo info, int i){
		
		this.info[i] = info;
	}	

	public PatientInfo[] readFile(){
		
		int count = 0;
		
		try{
			//open the file
			FileReader file = new FileReader("ListofPatients");
			BufferedReader buff = new BufferedReader(file);
			
			boolean eof = false;
			
			while(!eof){
				//read one line at a time
				String line = buff.readLine();
	
				if(line == null){
					eof = true;
				}
				else{			
					count++;
					buildPatientsInfo(count-1, line);									
				}				
			}// end while
			
			buff.close();
			
		}catch(IOException e){
			//display error message when text file cannot be opened
			System.out.println("Error-- " + e.toString());	
		}
				
		return info;
	}//end readFile
	
	public void buildPatientsInfo(int index, String name){
		
		PatientInfo info = new PatientInfo();
		
		//set name for each patient
		info.setName(name);
		
		//set the number for each patient
		info.setNumber(numArray[index]);
		
		setPatients(info, index);
			
	}//end buildPatientsInfo
			
}//end ReadFromFile

