import java.util.*;
public class MyHeap{
    private int root;
    private boolean isMax;
    private ArrayList<Integer> heap;

    public MyHeap(){
	heap=new ArrayList<Integer>(10);
	heap.add(7);
	heap.add(20);
	heap.add(10);
	heap.add(15);
	heap.add(9);
	heap.add(8);
	heap.add(14);
	heap.add(13);
	isMax=true;
    }

    public MyHeap(boolean isMax){
	this();
	this.isMax=isMax;
    }

    public int remove() {
	if (heap.get(0)==0){
	    throw new NoSuchElementException();
	}else if(heap.get(0)==1){
	    return heap.remove(1);
	}else if(heap.get(0)==2){
	    int temp=heap.remove(1);
	    heap.set(1,heap.remove(2));
	    return temp;
	}else{
	    return pushDown(1,heap.get(1));
	}
    }

    public int pushDown(int currIndex, int root){
	if (currIndex*2>heap.size()){
	    heap.remove(currIndex);
	    heap.set(0,heap.get(0)-1);
	    return root;
	}
	int left=currIndex*2;
	if (compare(heap.get(left), heap.get(left+1))){
	    heap.set(currIndex,heap.get(left));
	    heap.set(left, root);
	    return pushDown(left, root);
	}
	heap.set(currIndex,heap.get(left+1));
	heap.set(left+1, root);
	return pushDown(left+1, root);
    }

    public boolean compare(int v1, int v2){
	if (isMax){
	    return v1 > v2;
	}
	return v1 < v2;
    }

    public void add(int element){
	add(1, element)
    } 

    public void add(int currIndex, int element){
	if (currIndex*2>heap.get(0)){
	    
	}
    }

    public int peek() {
	return root;
    }

    public String toString(){
	String str="[";
	for (int i=1;i<heap.get(0)+1;i++){
	    str+=heap.get(i)+" ";
	}
	return str+"]"+"\n\n"+heap.get(0);
    }
}
