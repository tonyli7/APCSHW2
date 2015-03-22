public class LNode<T>{
    private T value;
    private LNode<T> next;
    private LNode<T> prev;

    public LNode(T v){
	this(v,null);
    }
    
    public LNode(T v, LNode<T> n){
	value=v;
	next=n;
    }

    public void setNext(LNode<T> n){
	next=n;
    }

    public void setPrev(LNode<T> n){
	prev=n;
    }

    public void setValue(T v){
	value=v;
    }
    
    public LNode<T> getNext(){
	return next;
    }
    
    public LNode<T> getPrev(){
	return prev;
    }

    public T getValue(){
	return value;
    }

    public String toString(){
	return ""+value;
    }

    public String name(){
	return "li.tony";
    }
    
}
