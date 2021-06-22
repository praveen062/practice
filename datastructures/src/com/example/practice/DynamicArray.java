package com.example.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
        List<List<Integer>> arr = new ArrayList<>(Collections.nCopies(n, null));
        List<Integer> lastAnswers = new ArrayList<Integer>();
        for(List<Integer> query : queries) {
        	int x = query.get(1);
        	int y = query.get(2);
        	int lastAnswer = 0;
        	int k = (x ^ lastAnswer) %2;
        	if(query.get(0) == 1) {
        		
        		if(arr.get(k) == null) {
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(y);
        			arr.add(k,list);
        		}else {
        			arr.get(k).add(y);
        		}
        		
        	}else if(query.get(0) == 2) {
        		int idx = y % arr.get(k).size();
        		lastAnswer = arr.get(k).get(idx);
        		lastAnswers.add(lastAnswer);
        	}
        }
        return lastAnswers;
    }

}

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.Oi));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);
        System.out.println(result);
    }
}
