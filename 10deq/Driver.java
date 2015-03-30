public class Driver{
    public static void main(String[]args){
	MyDEQ d=new MyDEQ(10);
	d.addFirst(1);
	d.addFirst(3);
	d.addFirst(5);
	d.addLast(4);
	d.addLast(10);
	d.removeFirst();
	d.removeLast();
	System.out.println(d);
	System.out.println(d.toStringX());


    }
}
