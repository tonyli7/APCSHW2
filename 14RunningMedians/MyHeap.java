import java.util.*;
public class MyHeap{
    private int root;
    private boolean isMax;
    private ArrayList<Integer> heap;

    public MyHeap(){
	heap=new ArrayList<Integer>(10);
	heap.add(0);
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
	    heap.set(0,0);
	    return heap.remove(1);
	}else if(heap.get(0)==2){
	    int temp=heap.remove(1);
	    root=heap.get(1);
	    heap.set(0,1);
	    //    heap.set(1,heap.remove(2));
	    return temp;
	}else{
	    int temp=heap.get(1);
	    heap.set(1,heap.get(size()));
	    heap.remove(size());
	    heap.set(0,size()-1);
	    return pushDown(1,heap.get(1), temp);
	}
    }

    public int pushDown(int currIndex, int root1, int removed){
	this.root=heap.get(1);
	if (currIndex*2>size()){
	    return removed;
	}
	int left=heap.get(currIndex*2);

	int temp;
	if (compare(root1,left)){
	    heap.set(currIndex*2,root1);
	    heap.set(currIndex,left);
	   
	    return pushDown(currIndex*2,root1,removed);
	}
	this.root=heap.get(1);
	if (currIndex*2+1>size()){
	    return removed;
	}
	int right=heap.get(currIndex*2+1);
	if (compare(root1,right)){
	  
	    heap.set(currIndex*2+1,root1);
	    heap.set(currIndex,right);
	    return pushDown(currIndex*2+1,root1,removed);	
	}
	this.root=heap.get(1);
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
	root=heap.get(1);
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

    public int getRoot(){
	return root;
    }

    public int linelength(){
	int length=3;
	int increment=4;
	for (int i=2;i<size()/2;i++){
	    length+=increment;
	    increment+=4;
	}
	return length;
    }

    public int[] getLevel(int level){
	double length=Math.pow(2,level-1);
	int[] values=new int[(int)length];
	for (double i=length, j=0;j<length;i++){
	    values[(int)j]=heap.get((int)i);
	    j++;
	}
	return values;
    }
    
    public String toString(){
	String str="[";

	for (int i=1;i<=heap.get(0);i++){
	    str+=heap.get(i)+" ";
	}
	return str+"]"+"\n\n"+heap.get(0);
    }
    /*
    public String toString(){
	//	String pile[][]=new String[size()/2][linelength()];
	String tree="";
	int spacing=linelength()/2;
	int middlespace=spacing*2;
	int next=0;
	System.out.println(size());
	for (int i=0;i<size()/2;i++){
	    for (int j=0;j<linelength();j++){
		if (i==0){
		    if (spacing>0){
			tree+=" ";
			spacing--;
		    }
		    else if (spacing==0){
			tree+=getLevel(i)[next];
			next++;
			spacing=linelength()/2;
		    }
		}else{
		    if (spacing>0){
			tree+=" ";
			spacing--;
		    }else if (spacing==0){
			tree+=getLevel(i)[next];
			next++;
		    }else if (spacing==0 && middlespace!=0){
			tree+=" ";
			middlespace--;
		    }
		}
	    }
	    spacing--;
	    middlespace=middlespace/2;
	    next=0;
	    tree+="\n";
	}
	return tree;
    }
    */
}
