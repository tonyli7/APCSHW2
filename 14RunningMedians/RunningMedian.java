import java.util.*;
public class RunningMedian{
    private MyHeap maxHeap,minHeap;
    private int totalsize;

    public RunningMedian(){
	maxHeap=new MyHeap(true);
	minHeap=new MyHeap(false);
	totalsize=0;
    }

    public double getMedian(){
	if (maxHeap.size()==0 && minHeap.size()){
	    throw new NoSuchElementException();
	}
    }

    public void add(int value){
	if (totalsize==0){
	    maxHeap.add(value);
	}
	if (value > maxHeap.getRoot()){
	    minHeap.add(value);
	}else if (value < minHeap.getRoot()){
	    maxHeap.add(value);
	}
	if (Math.abs(maxHeap.size()-minHeap.size())>=2){
	    if (maxHeap.size()>minHeap.size()){
		minHeap.add(maxHeap.remove());
	    }else{
		maxHeap.add(minHeap.remove());
	    }
	}
    }

	
}