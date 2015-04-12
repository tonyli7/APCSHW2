public class MyDEQ<T>{
    private T[] deck;
    public int head,tail;
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

    public int render(int end){
	if (end<deck.length){
	    end+=deck.length;
	}
	return end%deck.length;
    }

    public void resize(){
	T[] storage=(T[]) new Object[size];
	if (head<=tail){
	    for (int i=head;i<=tail;i++){
		storage[i]=deck[i];
	    }
	    
	}else{
	    for (int i=head;i<deck.length;i++){
		storage[i]=deck[i];
	    }
	    for (int i=0;i<=tail;i++){
	       
		storage[i]=deck[i];
	    }
	    
	}
	head=0;
	tail=size-1;
	deck=storage;
    }

    public void addFirst(T value){	  
	if (size==deck.length){
	    resize();
	}
	head=render(head-1);
	deck[head]=value;
	
	size++;
    }

    public void addLast(T value){
	if (size==deck.length){
	    resize();
	}
	tail=render(tail+1);
	deck[tail]=value;
	
	size++;
    }

    public T removeFirst(){
	if ((size<=deck.length/4) && deck.length>=100000){
	    resize();
	    System.out.println("hey");
	}
	T temp=deck[head];
	head=render(head+1);
	size--;
	return temp;
    }

    public T removeLast(){
	if ((size<=deck.length/4) && deck.length>=100000){
	    resize();
	}
	T temp=deck[tail];
	tail=render(tail-1);
	size--;
	return temp;
    }

    public T getFirst(){
	return deck[head];
    }

    public T getLast(){

	return deck[tail];
    }
    /*
    public String toString(){
	String deq="[ ";
	for (int i=0;i<deck.length;i++){
	    deq+=deck[i]+" ";
	}
	return deq+"]\n\n head: "+(head-1)+"   tail: "+(tail+1);
    }
    */
    
    public String toString(){
	String deq="[ ";
	if (head<=tail){
	    for (int i=head;i<=tail;i++){
		deq+=deck[i]+" ";
	    }
	    
	}else{
	    for (int i=head;i<deck.length;i++){
		deq+=deck[i]+" ";
	    }
	    for (int i=0;i<=tail;i++){
	       
		deq+=deck[i]+" ";
	    }
	    
	}
	return deq+="]";
    }
    
}
