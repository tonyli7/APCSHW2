public class Driver{
    public static void main(String[]args){
	MyDEQ d=new MyDEQ(5);
	d.addFirst(1);
	d.addFirst(3);
	d.addFirst(5);
	System.out.println(d);
	System.out.println(d.toStringX());


    }
}
