package com.example.javatest.accessspecifiers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


public class MainTest {
	static int count =0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[][] a =  [[6,4,7,[9,5,4,[2,4,8]]],[2,2,7],[9,0,7,[9,3,1,8,5]]];
//		System.out.println("count: "+count);
//		if(count < 2) {
//			count++;
//			main(null);
//		}
//		System.out.println("END program");
//		test1 t = new B();
//		t.test();
//		System.out.println(new Cal().getData(10).get());
//		Integer t1 = 5;
//		new Node<Integer>(t1).print();
	//	new TestCompletableFuture().test();
		
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		List<Future> d = new ArrayList<Future>();
		for(int i = 0; i<100; i++) {
			d.add(executorService.submit(new TestCallable(i)));
		}
		for(Future d1 : d) {
			try {
				 d1.get();
				System.out.println( d1.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}

class TestCallable implements Callable<String>{
	 private final int i;
	 
	 public TestCallable(int i) {
		// TODO Auto-generated constructor stub
		 this.i = i;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "test "+i;
	}
	
}

class TestCompletableFuture {
	void test() {
		List<CompletableFuture<String>> futures = new ArrayList<CompletableFuture<String>>();
		for(int i=0; i< 100; i++) {
			futures.add(test1(i));
		}
		
		CompletableFuture<Void> d = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
		CompletableFuture<Object> a = d.thenApply(v-> 
			futures.stream().map(future -> future.join()).collect(Collectors.<String>toList())
		);
		try {
			List<String> d1 = (List<String>) a.get();
			System.out.println(d1);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	CompletableFuture<String> test1(int i){
		return CompletableFuture.supplyAsync(() -> {
			return concat(i);
		});
	}
	
	
	String concat(int i ) {
		try {
			if(i%2 ==0)
			Thread.sleep(1000);
			System.out.println(new Date()+" "+i);
			return "test "+i;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}



class Test {
	int a;
}


class Node<T>{
	T data;
	Node(T t){
		this.data = t;
	}
	
	void print() {
		System.out.println("the data is"+data);
	}
}

interface test1 {
	void test();
}

interface GetData<Ca,K> {
	Ca getData(K k);
}

class Cal implements GetData<Optional<String>, Integer>{

	@Override
	public Optional<String> getData(Integer k) {
		// TODO Auto-generated method stub

		Optional<String> s = Optional.ofNullable("K is "+k);
		return s;
	}

	

	
}

class B extends Test implements test1{
	int c;
	
	public void test() {
		System.out.println("hello");
	}
}