import java.util.*;
public class MyHeap{
    private int max,min;
    private ArrayList<Integer> heap;

    public MyHeap(){
	heap=new ArrayList<Integer>(10);
	heap.add(0);
    }

    public MyHeap(boolean isMax){
	this();
	if (isMax){
	    max=20;
	}else{
	    min=10;
	}
    }

    public int remove() {
	if (heap.get(0)==0){
	    throws new NullPointerException();
	}else if(heap.get(0)==1){
	    return heap.remove(1);
	}else if(heap.get(0)==2){
	    int temp=heap.remove(1);
	    heap.set(1,heap.remove(2));
	    return heap.get(1);
	}else{
	    
	}
    }

    public void add(int){} 
    public int peek() {}

    public String toString(){
	String str="[";
	for (int i=1;i<heap.get(0);i++){
	    str+=heap.get(i)+" ";
	}
	return str+"]";
    }
}