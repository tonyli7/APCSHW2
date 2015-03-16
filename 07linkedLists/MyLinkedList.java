public class MyLinkedList{
    private LNode<T> head;
    private LNode<T> tail;
    private int size;

    public MyLinkedList(){
	size=0;
    }

    public String name(){
	return "tony.li";
    }
    public String toString(){
	String list="[ ";
	LNode<T> current=head;
	while (current.getNext()!=tail){
	    list+=""+current.getValue()+",";
	    current=current.getNext();
	}
	return list+current.getValue()+","+tail.getValue()+"]";
    }

    public boolean add(int value){
	if (size==0){
	    head=new LNode<T>(value);
	    tail=head;
	}else{
	    LNode<T> tempTail=new LNode(value);
	    tail.setNext(tempTail);
	   
	    tail=tail.getNext();
	}
	size++;
	return true;
    }

    public void add(int value, int index){
	if (index<0){
	    throw new IndexOutOfBoundsException();
	}
	if (size==0){
	    head=new LNode(value);
	    tail=head;
	}if (index>=size){
	    add(value);
	}else if (index==0){  
	    head=new LNode(value,head); 
	}else{
	    LNode<T> current=head;
	    int crntIndex=0;
	    while (crntIndex!=index-1){
		current=current.getNext();
		crntIndex++;
	    }
	    LNode<T> temp=new LNode(value,current.getNext());
	    current.setNext(temp);
	    temp.setNext(current.getNext().getNext());
	}
			   
    }

    public T remove(int index){
	if (index==0){
	    T ihead=head.getValue();
	    head=head.getNext();
	    return ihead;
	}else if(index==size-1){
	    LNode<T> current=head;
	    int crntIndex=0;
	    while (crntIndex<index-1){
		current=current.getNext();
		crntIndex++;
	    }
	    T itail=current.getNext().getValue();
	    tail=current;
	    return itail;
	}else{
	    LNode<T> current=head;
	    int crntIndex=0;
	    while (crntIndex!=index-1){
		current=current.getNext();
		crntIndex++;
	    }
	    T removed=current.getNext().getValue();
	    current.setNext(new LNode(current.getNext().getNext().getValue(),current.getNext().getNext()));
	    return removed;
	}
    }

    public T get(int index){
	LNode<T> current=head;
	int crntIndex=0;
	while (crntIndex!=index){
	    current=current.getNext();
	    crntIndex++;
	}
	return current.getValue();
    }

    public T set(int index, int value){
	LNode<T> current=head;
	int crntIndex=0;
	while (crntIndex!=index){
	    current=current.getNext();
	    crntIndex++;
	}
	T replaced=current.getValue();
	current.setValue(value);
	return replaced;
    }

    public int size(){
	return size;
    }

    
}
