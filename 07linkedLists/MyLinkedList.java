public class MyLinkedList{
    private LNode head;
    private int size;

    public MyLinkedList(){
	size=0;
    }

    public MyLinkedList(int s){
	size=s;
    }

   
    public String toString(){
	String list="[";
	LNode current=head;
	while (current.getNext()!=null){
	    list+=current.getValue()+" , ";
	    current=current.getNext();
	}
	return list.substring(0,size-1)+"]";
    }

    public void add(int value){
	if (size==0){
	    head=new LNode(value);
	}else{
	    LNode current=head;
	    while (current.getNext()!=null){
		current=current.getNext();
	    }
	    current.setNext(new LNode(value));
	}
	size++;
    }

    public int size(){
	return size;
    }

    
}
