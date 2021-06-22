package com.example.datastructures.string;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortestSegment {
	static Map.Entry<Integer, Integer> documentSearch(Collection<String> document, Collection<String> query) {
	    Queue<KeywordIndexPair> queue = new ArrayDeque<>(query.size());
	    HashSet<String> words = new HashSet<>();

	    query.stream()
	        .forEach(words::add);

	    AtomicInteger idx = new AtomicInteger();
	    IndexPair interval = new IndexPair(0, Integer.MAX_VALUE);
	    AtomicInteger size = new AtomicInteger();
	    document.stream()
	        .map(w -> new KeywordIndexPair(w, idx.getAndIncrement()))
	        .filter(pair -> words.contains(pair.word)) // Queue.contains is O(n) so we trade space for efficiency
	        .forEach(pair -> {
	            // only the first and last elements are useful to the algorithm, so we don't bother removing
	            // an element from any other index. note that removing an element using equality
	            // from an ArrayDeque is O(n)
	            KeywordIndexPair first = queue.peek();
	            if (pair.equals(first)) {
	                queue.remove();
	            }
	            queue.add(pair);
	            first = queue.peek();
	            int diff = pair.index - first.index;
	            if (size.incrementAndGet() == words.size() && diff < interval.interval()) {
	                interval.begin = first.index;
	                interval.end = pair.index;
	                size.set(0);
	            }
	        });

	    return new AbstractMap.SimpleImmutableEntry<>(interval.begin, interval.end);
	}
	
	public static void main(String args[])
	{
		String sentence = "This is a test. This is a programming test. This is a programming test in any language.";
		String[] words = { "this", "a", "test","programming" };
		sentence=sentence.replaceAll("\\W", " ") ;
		List<String>  sencentce= Arrays.asList(sentence.split(" "));
		Entry<Integer, Integer> m =documentSearch(sencentce, Arrays.asList( words));
		
		System.out.println(m);
		for(int i = m.getKey(); i<= m.getValue();i++) {
			System.out.println(sencentce.get(i));
		}
	}
}
