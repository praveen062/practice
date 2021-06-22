package com.example.javatest.ascii;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MainTest {
	public static void main(String[] args) {
		String [] arr = {"abc","1","12","22","45","5"};
		List<String> str = Arrays.asList(arr);
		Collections.sort(str);
		System.out.println(str);
		str.stream().forEach(a-> {
			byte[] bytes = a.getBytes(StandardCharsets.US_ASCII);
 			System.out.println(new String(bytes));
 			System.out.println(a.chars().boxed().collect(Collectors.toList()));
		});
	}
}
