public class LNode{
    private int value;
    private LNode next;

  
    
    public void setNext(int n){
	next.setValue(n);
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


    
}
