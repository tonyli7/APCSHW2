public class MyDEQ{
    private int[] deck;
    private int head,tail;
    private int size;
    private int headpos,tailpos;

    public MyDEQ(int size){
	deck=new int[size];
	this.size=0;
    }
    
    public void addFirst(int value){	      
	if (size==0){
	    deck[0]=value;
	    headpos=0;
	    tailpos=0;
	    size++;
	}else{
	    headpos++;
	    deck[headpos]=value;
	    size++;
	}
    }

    public String toString(){
	String deq="[ ";
	for (int i=headpos;i<size;i++){
	    deq+=deck[i]+" ";
	}
	for (int j=tailpos;j<headpos;j++){
	    deq+=deck[j]+" ";
	}
	return deq+"]";
    }
}