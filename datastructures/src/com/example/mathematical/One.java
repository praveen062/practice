package com.example.mathematical;


public class One {
	  public static void main(String args[] ) throws Exception {
		     int[] m = {1};
		     m[0]++;
		     System.out.println(m[0]);
		     
		     int i = 100;
		     for(int j=0;j<i;j++) {
		    	 Thread.sleep(1000);
		    	 System.out.println(j);
		     }
		     
	        //Scanner
	        //969109092 60139073 122541116 75884463
		  //224071575 364495063 502891141 446040648
	        long A = 224071575;                // Reading input from STDIN
	        long B = 364495063;
	        long C = 502891141;
	        long M =  446040648;    
	        long a = modulatExponential(A, B , M);
	        long c = modInverse(C, M);
	        long ans1 = a ;
	        long ans2 = c ;
	        long k = (ans1 * ans2) % M;
	        System.out.println("a -> "+a+" c "+c);
	        System.out.println(k);
	    }

	    static long modInverse(long a , long b){
	        extentedEuclid(a, b);
	        return (x % b + b )%b;
	    }

	    static long x,y,gcd;
	    static void extentedEuclid(long a, long b){
	        if(b == 0){
	            gcd = a;
	            x = 1;
	            y = 0;
	        }else {
	            extentedEuclid(b, a % b);
	            long tmp = x;
	            x = y;
	            y = tmp - ((a/b) * y);
	        }
	            
	    }

	    static  long modulatExponential(long a, long b, long m){
	        if(b== 0 )
	            return 1;
	        if(b % 2 == 0 )
	            return modulatExponential(((a ) * (a ) )% m ,b/2, m);
	        else
	            return  (a * modulatExponential(((a) * (a ) )%m , (b-1)/2, m)) % m ;
	    }
}
