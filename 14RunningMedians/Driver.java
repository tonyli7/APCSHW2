public class Driver{
    public static void main(String[]args){
	/*
	RunningMedian m=new RunningMedian();
	for (int i=0;i<10;i++){
	    m.add(i);
	}
	System.out.println(m.getMedian());
	*/
	MyHeap h=new MyHeap(true);
	h.add(10);
	h.add(8);
	h.add(7);
	System.out.println(h);
    }
}