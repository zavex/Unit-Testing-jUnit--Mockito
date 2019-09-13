package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.in28minutes.unittesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService dataServiceMock;
	
	@Test
	public void calculateSumUsingDataService_basic_mock() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_empty_mock() {
		when(dataServiceMock.retrieveEmptyDataSet()).thenReturn(new int [] {});
		assertEquals(0, business.calculateEmptySumUsingDataService());
	}	

}
