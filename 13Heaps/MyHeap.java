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
	    int temp=heap.get(1);
	    heap.set(1,heap.get(size()));
	    heap.remove(size());
	    heap.set(0,size()-1);
	    return pushDown(1,heap.get(1), temp);
	}
    }

    public int pushDown(int currIndex, int root, int removed){
	if (currIndex*2>size()){
	    return removed;
	}
	int left=heap.get(currIndex*2);

	int temp;
	if (compare(root,left)){
	    heap.set(currIndex*2,root);
	    heap.set(currIndex,left);
	    return pushDown(currIndex*2,root,removed);
	}
	if (currIndex*2+1>size()){
	    return removed;
	}
	int right=heap.get(currIndex*2+1);
	if (compare(root,right)){
	  
	    heap.set(currIndex*2+1,root);
	    heap.set(currIndex,right);
	    return pushDown(currIndex*2+1,root,removed);	
	}
	return removed;
    }

    public boolean compare(int v1, int v2){
	if (isMax){
	    return v1 < v2;
	}
	return v1 > v2;
    }

    public int size(){
	return heap.get(0);
    }
    
    public void add(int element){
	heap.add(element);
	heap.set(0,size()+1);
	add(size(), element);
    } 

    public void add(int currIndex, int element){
	if (currIndex==1){
	    return;
	}
	int parent=heap.get(currIndex/2);
	if (compare(parent, element)){
	    heap.set(currIndex/2,element);
	    heap.set(currIndex,parent);
	    add(currIndex/2,element);
	}else{
	    return;
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
