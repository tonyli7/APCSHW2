public class LNode{
    private int value;
    private LNode next;

    public LNode(int v){
	this(v,null);
    }
    
    public LNode(int v, LNode n){
	value=v;
	next=n;
    }

    public void setNext(LNode n){
	next=n;
    }

    public void setValue(int v){
	value=v;
    }
    
    public LNode getNext(){
	return next;
    }

    public int getValue(){
	return value;
    }

    public String toString(){
	return ""+value;
    }
    
}
