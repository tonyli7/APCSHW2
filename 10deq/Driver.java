public class Driver{
    public static void main(String[]args){
	MyDEQ<Integer> d=new MyDEQ<Integer>(10);
	for (int i=0;i<10;i++){
	    d.addFirst(i);
	}
	System.out.println(d.size());
	d.addFirst(10);
	System.out.println(d.getLast());
	


    }
}
