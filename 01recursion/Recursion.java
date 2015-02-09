public class Recursion implements hw1{
    

    public String name(){
	return "Li,Tony";
    }

    public int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException("n must be non-negative");	
	}
	if (n==0){
	    return 1;
	}
	return n*fact(n-1);
    }

    public int fib(int n){
	if (n<0){
	    throw new IllegalArgumentException("n must be non-negative");	
	}
	if (n==0){
	    return 0;
	}
	if (n==1){
	    return 1;
	}
	return fib(n-1)+fib(n-2);
    }

    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException("n must be non-negative");	
	}
	double guess=1;
	if ((((int)((guess*guess)*1000000))/1000000.0)==n){
	    return guess;
	}
	return newGuess(n, guess);
    }

    public double newGuess(double n,double g){
	double guess=(n/g + g)/2;
	if ((((int)((guess*guess)*1000000))/1000000.0)==n){
	    return guess;
	}
	return newGuess(n, guess);
    }
}
