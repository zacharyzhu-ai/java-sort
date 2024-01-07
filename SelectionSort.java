//Programmer:  John Chapin  email: john.chapin@lcps.org
//Programmer: Chris Schroeder email: chris@4schroeders.com - Modified to use the ISortPanel

public class SelectionSort implements Runnable {
  int[] sortArray;
  ISortPanel panel;

  public SelectionSort(int[] anArray, ISortPanel aPanel) {
    sortArray = anArray;
    panel = aPanel;
  }
  
  //Write a swap helper method
  public void swap(int ind1, int ind2)  {
	  int change = sortArray[ind1];
	  sortArray[ind1] = sortArray[ind2];
	  sortArray[ind2] = change;
  }

  // This is the sort routine on sortArray
  public void run() {
	  for(int i = 0; i < sortArray.length; i++) {
		  int min = i;
		  for(int j = i; j < sortArray.length; j++)  {
			  if(sortArray[j] < sortArray[min])  {
				   min = j;
			  }
		  }
		  swap(i, min);
		  panel.updateArray(sortArray);
	  }
	  
     
	  panel.updateArray(sortArray);// this code goes after every change in the array
 
  }// selectionSort()
}// SelectionSort class