public class MyLinkedList{
    private LNode head;
    private LNode current;

    public MyLinkedList(int start){
	head.setValue(start);
	current.setValue(start);
    }
    public String toString(){
	String str=""+current.getValue+"";
	return str;
    }

    public void add(int value){
	while (current.getNext()!=null){
	    head=current.getNext();
	}
    }
}