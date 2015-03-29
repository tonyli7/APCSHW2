public class MyDEQ{
    private int[] deck;
    private int head,tail;
    private int size;

    public MyDEQ(int size){
	deck=new int[size];
	this.size=0;
    }
    
    public void addFirst(int value){	      
	if (size==0){
	    deck[0]=value;
	    head=0;
	    tail=0;
	    size++;
	}else{
	    head++;
	    deck[head]=value;
	    size++;
	}
    }

    public String toString(){
	String deq="[ ";
	for (int i=0;i<deck.length;i++){
	    deq+=deck[i]+" ";
	}
	return deq+"]\n\n head: "+head+"   tail: "+tail;
    }

    public String toStringX(){
	String deq="[ ";
	if (head>=tail){
	    for (int i=head;i>=tail;i--){
		deq+=deck[i]+" ";
	    }
	    return deq+="]";
	}else{
	    for (int i=head;i>=0;i--){
		deq+=deck[i]+" ";
	    }
	    for (int i=deck.length;i>=tail;i--){
		deq+=deck[i]+" ";
	    }
	    return deq+="]";
	}
    }
}
