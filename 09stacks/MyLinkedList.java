import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private LNode<T> head;
    private LNode<T> tail;
    private int size;

 
    public MyLinkedList(){
	size=0;
    }

    public String name(){
	return "li.tony";
    }
    public String toString(){
	if (size==0){
	    return "[]";
	}
	String list="[ ";
	LNode<T> current=head;
	while (current!=tail){
	    list+=""+current.getValue()+",";
	    current=current.getNext();
	}
	return list+current.getValue()+"]";
    }

    public boolean add(T value){
	if (size==0){
	    head=new LNode<T>(value);
	    tail=head;
	}else{
	    LNode<T> tempTail=new LNode<T>(value);
	    tail.setNext(tempTail);
	   
	    tail=tail.getNext();
	}
	size++;
	return true;
    }

    public void add(T value, int index){
	if (index<0){
	    throw new IndexOutOfBoundsException();
	}
	if (size==0){
	    head=new LNode<T>(value);
	    tail=head;
	}if (index>=size){
	    add(value);
	}else if (index==0){  
	    head=new LNode<T>(value,head); 
	}else{
	    LNode<T> current=head;
	    int crntIndex=0;
	    while (crntIndex!=index-1){
		current=current.getNext();
		crntIndex++;
	    }
	    LNode<T> temp=new LNode<T>(value,current.getNext());
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
	    current.setNext(new LNode<T>(current.getNext().getNext().getValue(),current.getNext().getNext()));
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

    public T set(int index, T value){
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

    public int indexOf(T value){
	LNode<T> current=head;
	int ctr=0;
	while (current.getNext()!=null){
	    if (current.getValue().equals(value)){
		return ctr;
	    }
	    ctr++;
	    current=current.getNext();
	}
	return -1;
    }

    public int size(){
	return size;
    }

    private class MLLIterator<T> implements Iterator<T>{
	private LNode<T> l;


	public MLLIterator(LNode<T> n){
	    l=n;
	}

	public boolean hasNext(){
	    if (l.getNext()!=null){
		return true;
	    }
	    return false;
	}

	public T next(){
	    if (!(this.hasNext())){
		throw new NoSuchElementException();
	    }else{
		l=l.getNext();
		return l.getValue();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    public Iterator<T> iterator(){
	return new MLLIterator<T>(head);
    }
   
    public T getEnd(){
	return tail.getValue();
    }
}
