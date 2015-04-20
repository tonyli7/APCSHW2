public class MyDEQ<T>{
    private T[] deck;
    private int[] priorities;
    public int head,tail;
    private int size;

    public MyDEQ(){
	this(10);
    }

    public MyDEQ(int size){
	deck=(T[]) new Object[size];
	priorities=new int[size];
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
	T[] storage=(T[]) new Object[size*2];
	int[] pstorage=new int[size*2];
	if (head<=tail){
	    for (int i=head;i<=tail;i++){
		storage[i]=deck[i];
		pstorage[i]=priorities[i];
	    }
	    
	}else{
	    for (int i=head;i<deck.length;i++){
		storage[i]=deck[i];
		pstorage[i]=priorities[i];
	    }
	    for (int i=0;i<=tail;i++){
	       
		storage[i]=deck[i];
		pstorage[i]=priorities[i];
	    }
	    
	}
	head=0;
	tail=size-1;
	deck=storage;
	priorities=pstorage;
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

    public void add(T o,int i){
	if (size==deck.length){
	    resize();
	}
	addLast(o);
	priorities[tail]=i;
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

    public T removeSmallest(){
	if ((size<=deck.length/4) && deck.length>=100000){
	    resize();
	}
	int smallest=priorities[head];
	//	System.out.println(priorities[head+1]);
	int index=head;
	if (head<=tail){
	    for (int i=head;i<=tail;i++){
		if (priorities[i]<smallest){
		    smallest=priorities[i];
		    index=i;
		}
	    }
	    
	}else{
	    for (int i=head;i<priorities.length;i++){
		if (priorities[i]<smallest){
		    smallest=priorities[i];
		    index=i;
		}
	    }
	    for (int i=0;i<=tail;i++){
	       	if (priorities[i]<smallest){
		    smallest=priorities[i];
		    index=i;
		}
	    }
	    
	}
	T temp=deck[index];

	deck[index]=deck[head];
	priorities[index]=priorities[head];
	//	deck[head]=null;
	head=render(head+1);
	size--;
	return temp;
    }

    public T getFirst(){
	return deck[head];
    }

    public T getLast(){

	return deck[tail];
    }

   

    public T remove(int method){
	if (method==0){
	    return removeFirst();
	}
	if (method==1){
	    return removeLast();
	}
	else{
	    return removeSmallest();
	}
    }

    public void customAdd(T val, int method, int priority){
	if (method>=2){
	    add(val,priority);
	}
	else{
	    addLast(val);
	}
    }

    public T get(int method){
	if (method>=2){
	    return getSmallest();
	}
	else{
	    return getLast();
	}
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

    public String priorityList(){
	String list="[ ";
	if (head<=tail){
	    for (int i=head;i<=tail;i++){
		list+=priorities[i]+" ";
	    }
	    
	}else{
	    for (int i=head;i<priorities.length;i++){
		list+=deck[i]+" ";
	    }
	    for (int i=0;i<=tail;i++){
	       
		list+=priorities[i]+" ";
	    }
	    
	}
	return list+="]";
    }
    
}
