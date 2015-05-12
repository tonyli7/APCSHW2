public class MyHeap{
    private int max,min;
    private int[] heap;

    public MyHeap(){
	heap=int[10];
    }

    public MyHeap(boolean isMax){
	super();
	if (isMax){
	    max=20;
	}else{
	    min=10;
	}
    }

    public String toString(){
	String str="[";
	for (int i=1;i<heap[0];i++){
	    str+=heap[i]+" ";
	}
	return str+"]";
    }
}