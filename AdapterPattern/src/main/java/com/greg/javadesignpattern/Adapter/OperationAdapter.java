package com.greg.javadesignpattern.Adapter;

import com.greg.javadesignpattern.Target.ScoreOperation;
import com.greg.javadesignpattern.adaptee.*;

public class OperationAdapter implements ScoreOperation {

	private QuickSort sortObj; 
	private BinarySearch searchObj; 

	public OperationAdapter() {
		sortObj = new QuickSort();
		searchObj = new BinarySearch();
	}

	@Override
	public int[] sort(int[] array) {
		return sortObj.quickSort(array);
	}

	@Override
	public int search(int[] array, int key) {
		return searchObj.binarySearch(array, key);
	}

}
