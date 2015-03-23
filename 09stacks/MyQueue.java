public class MyQueue extends MyLinkedList<T>{
    private MyLinkedList<T> q;
  

    public MyQueue(){
	q=new MyLinkedList<T>();
    }

    public boolean enqueue(T element){
	if (q.size()==0){
	    head=new LNode<T>(element);
	    return true;
	}
	tail.setNext(new LNode<T>(element));
	tail=new LNode<T>(element);
	return true;
    }

    public T dequeue(){
	if (q.size()==0){
	    return -1;
	}
	T dequeued=head.getValue();
	head=null;
	return dequeued;
    }
}