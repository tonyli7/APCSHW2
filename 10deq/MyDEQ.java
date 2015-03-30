public class MyDEQ<T>{
    private T[] deck;
    private int head,tail;
    private int size;

    public MyDEQ(){
	this(10);
    }

    public MyDEQ(int size){
	deck=(T[]) new Object[size];
	head=0;
	tail=deck.length-1;
	this.size=0;
    }
    
    public int size(){
	return size;
    }
    public void resize(){
	T[] storage=(T[]) new Object[size];
	if (head-1>=tail+1){
	    for (int i=head-1;i>=tail+1;i--){
		storage[i]=deck[i];
	    }
	}else{
	    for (int i=head-1;i>=0;i--){
		storage[i]=deck[i];
	    }
	    for (int i=deck.length-1;i>tail;i--){
		storage[i]=deck[i];
	    }
	}
	if (size==deck.length){
	    deck=(T[]) new Object[size*2];
	    head=size;
	    tail=deck.length;
	}else if ((size<=deck.length/4) && deck.length>=100000){
	    deck=(T[])new Object[deck.length/2];
	    head=size;
	    tail=deck.length;
	}
	for (int i=0;i<size;i++){
	    deck[i]=storage[i];
	}
    }

    public void addFirst(T value){	  
	if (size==deck.length){
	    resize();
	}
	deck[head]=value;
	head++;
	size++;
    }

    public void addLast(T value){
	if (size==deck.length){
	    resize();
	}
	deck[tail]=value;
	tail--;
	size++;
    }

    public T removeFirst(){
	if ((size<=deck.length/4) && deck.length>=100000){
	    resize();
	}
	T temp=deck[head-1];
	head--;
	size--;
	return temp;
    }

    public T removeLast(){
	if ((size<=deck.length/4) && deck.length>=100000){
	    resize();
	}
	T temp=deck[tail+1];
	tail++;
	size--;
	return temp;
    }

    public T getFirst(){
	return deck[head-1];
    }

    public T getLast(){
	if (deck[deck.length-1]==null){
	    return deck[0];
	}
	return deck[tail+1];
    }

    /* public String toString(){
	String deq="[ ";
	for (int i=0;i<deck.length;i++){
	    deq+=deck[i]+" ";
	}
	return deq+"]\n\n head: "+(head-1)+"   tail: "+(tail+1);
    }
    */
    public String toString(){
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
