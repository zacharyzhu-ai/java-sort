//Programmer:  John Chapin  email: john.chapin@lcps.org
//Programmer: Chris Schroeder email: chris@4schroeders.com - Modified to use the ISortPanel

public class InsertionSort implements Runnable {
  int[] sortArray;
  ISortPanel panel;

  public InsertionSort(int[] anArray, ISortPanel aPanel) {
    sortArray = anArray;
    panel = aPanel;
  }
  
  // ***** SWAP CODE GOES HERE (PASS THE ARRAY REFERENCE and INDEXES) ****
  
  public void swap(int ind1, int ind2)  {
	  int change = sortArray[ind1];
	  sortArray[ind1] = sortArray[ind2];
	  sortArray[ind2] = change;
  }

  // *********  SORT ROUTINE GOES IN THE RUN METHOD
  public void run() {
	  
	  for(int i = 0; i < sortArray.length; i++)  {
		  int j = i; 
		  while(j > 0 && sortArray[j] < sortArray[j-1])  {
				  swap(j, j-1);
				  panel.updateArray(sortArray);
				  j--;
				  
				  
		  }
	  }
	  
	  
	  
  // Displays the whole array - put after a change is made
      								
  }// selectionSort() in run method
}// SelectionSort class