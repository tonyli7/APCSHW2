public class MyDEQ{
    private int[] deck;
    private int head,tail;
    private int size;

    public MyDEQ(int size){
	deck=new int[size];
	head=0;
	tail=deck.length-1;
	this.size=0;
    }
    
    public void addFirst(int value){	      
	deck[head]=value;
	head++;
	size++;
    }

    public void addLast(int value){
	deck[tail]=value;
	tail--;
	size++;
    }

    public int removeFirst(){
	int temp=deck[head-1];
	head--;
	size--;
	return temp;
    }

    public int removeLast(){
	int temp=deck[tail+1];
	tail++;
	size--;
	return temp;
    }

    public String toString(){
	String deq="[ ";
	for (int i=0;i<deck.length;i++){
	    deq+=deck[i]+" ";
	}
	return deq+"]\n\n head: "+(head-1)+"   tail: "+(tail+1);
    }

    public String toStringX(){
	String deq="[ ";
	if (head-1>=tail+1){
	    for (int i=head-1;i>=tail+1;i--){
		deq+=deck[i]+" ";
	    }
	    return deq+="]";
	}else{
	    for (int i=head-1;i>=0;i--){
		deq+=deck[i]+" ";
	    }
	    for (int i=deck.length-1;i>tail;i--){
	       
		deq+=deck[i]+" ";
	    }
	    return deq+="]";
	}
    }
}
