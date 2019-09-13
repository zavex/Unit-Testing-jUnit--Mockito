package com.in28minutes.unittesting.unittesting.business;

import java.util.Arrays;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;
	
	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int [] data) {
		//Functional programming
		
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);  //Thats it !! ...easy right xD
		
		
/*		int sum = 0;
		for(int value:data) {
			sum+= value;
		}
		return sum;
*/
	}
	
	public int calculateSumUsingDataService() {
		//int sum = 0;
		int [] data = someDataService.retrieveAllData();
		
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
/*		
		for(int value:data) {
			sum+= value;
		}
		return sum;
*/		
	}
	
	public int calculateEmptySumUsingDataService() {
		int sum = 0;
		int [] data = someDataService.retrieveEmptyDataSet();
		for(int value:data) {
			sum+= value;
		}
		return sum;
	}
	
	
	
	
}
