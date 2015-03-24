public class Driver{
    public static void main(String[]args){
	MyStack p=new MyStack();
	p.push("hey");
	p.push("you");
	p.pop();
	System.out.println(p);
	MyQueue<String> q=new MyQueue<String>();
	q.enqueue("dak");
	q.enqueue("bam");
	q.enqueue("woo");
	q.enqueue("hai");
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
    }
}
