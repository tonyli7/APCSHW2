public class LNode{
    private int value;
    private LNode next;

    public LNode(int k){
	value=k;
    }
    
    public void setNext(int n){
	next.setValue(n);
    }

    public void setValue(int v){
	value=v;
    }
    
    public int getNext(){
	return next;
    }

    public int getValue(){
	return value;
    }


    
}
