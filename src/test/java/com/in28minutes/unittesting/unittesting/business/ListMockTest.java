package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;


public class ListMockTest {
	
	List <String> mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}

	@Test
	public void returnMultipleValues () {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("Xavi");
		assertEquals("Xavi",mock.get(0));
		assertEquals(null, mock.get(1));		
	}
	
	@Test
	public void returnWithGenericParameters() {  //using argument matchers
		when(mock.get(anyInt())).thenReturn("Xavi");
		assertEquals("Xavi",mock.get(0));
		assertEquals("Xavi", mock.get(1));		
	}
	
	@Test 
	public void verificationBasics () {   // to verify if a value its passed
		//SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		//Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);	
	}

	
	@Test
	public void captureMethod () {		
		//SUT
		mock.add("Something");
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("Something", captor.getValue());
	}
	
	
	@Test
	public void multipleCaptureMethod () {		
		//SUT
		mock.add("Something1");
		mock.add("Something2");
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("Something1", allValues.get(0));
		assertEquals("Something2", allValues.get(1));
		
	}
	
	@Test 
	public void mocking () {
		ArrayList arrayListMock = mock(ArrayList.class);   // a mock does not retain behavior (code) of the original class
		System.out.println(arrayListMock.get(0)); // null
		System.out.println(arrayListMock.size()); // 0
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size()); // 0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); // 5
	}
	
	
	@Test 
	public void spying () {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0)); // null
		System.out.println(arrayListSpy.size()); // 1
		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size()); // 3
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); // 5
		
		verify(arrayListSpy).add("Test2");
	}	
	
		
}
