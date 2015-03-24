import java.util.*;
public class MyQueue<T> extends MyLinkedList<T>{
    private MyLinkedList<T> q;
  

    public MyQueue(){
	q=new MyLinkedList<T>();
    }

    public boolean enqueue(T element){
	q.add(element);
	return true;
    }

    public T dequeue(){
	if (q.size()==0){
	    throw new NoSuchElementException();
	}
	return q.remove(0);
    }

    public String toString(){
	String list="]";
	for (T val:q){
	    System.out.println(q.size());
	    System.out.println(val);
	    list=" "+val+list;
	}
	return "["+list;
    }
}
