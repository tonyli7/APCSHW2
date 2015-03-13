public class MyLinkedList{
    private LNode head;
    private LNode tail;
    private int size;

    public MyLinkedList(){
	size=0;
	head=new LNode();
	tail=head;
    }

    public MyLinkedList(int s){
	size=s;
	LNode current=head;
	int i=0;
	while (i<s){
	    current=head.getNext();
	}
	tail=current;
    }

   
    public String toString(){
	String list="[ ";
	LNode current=head;
	while (current.getNext()!=null){
	    list+=current.getValue()+" , ";
	    current=current.getNext();
	    System.out.println(current.getValue());
	}
	return list.substring(0,size-1)+"]";
    }

    public boolean add(int value){
	if (size==0){
	    head=new LNode(value);
	    tail=head;
	}else{
	    tail.setNext(new LNode(value));
	    System.out.println(value);
	}
	size++;
	return true;
    }

    public void add(int value, int index) throws IndexOutOfBoundsException{
	if (size==0){
	    head=new LNode(value);
	    tail=head;
	}else{
	    LNode current=head;
	    int crntIndex=0;
	    while (crntIndex!=index){
		current=current.getNext();
	    }
	    current.setNext(new LNode(value,current.getNext()));
	}
			   
    }

    public int remove(int index){
	LNode current=head;
	int crntIndex=0;
	while (crntIndex!=index-1){
	    current=current.getNext();
	    crntIndex++;
	}
	current.setNext(new LNode(current.getValue(),current.getNext()));
	return current.getNext().getValue();
    }

    public int get(int index){
	LNode current=head;
	int crntIndex=0;
	while (crntIndex!=index){
	    current=current.getNext();
	}
	return current.getValue();
    }

    public int set(int index, int value){
	LNode current=head;
	int crntIndex=0;
	while (crntIndex!=index-1){
	    current=current.getNext();
	    crntIndex++;
	}
	int replaced=current.getNext().getValue();
	current.setNext(new LNode(value,current.getNext()));
	return replaced;
    }

    public int size(){
	return size;
    }

    
}
