//Programmer:  John Chapin  email: john.chapin@lcps.org
//Programmer: Chris Schroeder email: chris@4schroeders.com - Modified to use the ISortPanel

public class MergeSort implements Runnable {
	int[] sortArray;
	ISortPanel panel;

	public MergeSort(int[] anArray, ISortPanel aPanel) {
		sortArray = anArray;
		panel = aPanel;
	}

	public void merge(int begIndex, int middleIndex, int endIndex) {
		int helperSize = endIndex - begIndex + 1;
		int leftIndex = begIndex;
		int rightIndex = middleIndex + 1;
		int[] helperArr = new int[helperSize];
		int helperArrayIndex = 0;

		// ***** WRITE CODE HERE **************
		// Fill helper array with values from the two halves
		// of the sorted array
		//
		while(leftIndex <= middleIndex && rightIndex <= endIndex)  {
			if(sortArray[leftIndex] > sortArray[rightIndex])  {
				helperArr[helperArrayIndex] = sortArray[rightIndex];
				rightIndex++;
			}
			else {
				helperArr[helperArrayIndex] = sortArray[leftIndex];
				leftIndex++;
			}
			helperArrayIndex++;
		}
		
		while(leftIndex <= middleIndex)  {
			helperArr[helperArrayIndex] = sortArray[leftIndex];
			leftIndex++;
			helperArrayIndex++;
		}
		
		while(rightIndex <= endIndex)  {
			helperArr[helperArrayIndex] = sortArray[rightIndex];
			rightIndex++;
			helperArrayIndex++;
		}
		
		
		helperArrayIndex = 0;
		

		/*  ******* This is written for you already
		 * - Set values in sortArray to the values that were merged merged into the
		 * helperArray - Display after each move from one element of the helper array to
		 * the sortArray using panel.updateArray
		 */

		for (int index = begIndex; index <= endIndex; index++) {
			sortArray[index] = helperArr[helperArrayIndex];
			helperArrayIndex++;
			panel.updateArray(sortArray);//Display the array
		}
	}

	public void mergeSort(int begIndex, int endIndex) {

		/* **** WRITE CODE HERE ********
		 if terminating case - return
		 else
		   - find the middle of the range and recursively call, mergesort twice,
		   - once with the left half and
		   - once with the right half
		   - then merge the two halves using the merge method
         */		
		if (begIndex == endIndex)

			return;
			else
			{
			int middleIndex = (begIndex + endIndex) / 2;
			mergeSort(begIndex, middleIndex);
			mergeSort(middleIndex + 1, endIndex);
			merge(begIndex, middleIndex, endIndex);
			}

	}

	// This is the sort routine on sortArray
	public void run() {
		
		mergeSort(0, sortArray.length - 1);
		
	}//

}// MergeSort class