import java.util.*;
public class Sorts{
    public static void main(String[]args){
	int[] ary=new int[4];
	randomAry(20,ary);
	System.out.println(toString(ary));
	mergeSort(ary);
	System.out.println(toString(ary));
    }
    
    
    public static void mergeSort(int[] ary){
	ArrayList<Comparable>aL=new ArrayList<Comparable>();
	for (int a: ary){
	    aL.add(a);
	}
	mhelp(aL);
	
	for (int start=0;start<aL.size();start++){
	    ary[start]=(int)aL.get(start);
	}
    }

    public static void mhelp(ArrayList<Comparable> aL){
	ArrayList<Comparable>a=new ArrayList<Comparable>();
	ArrayList<Comparable>b=new ArrayList<Comparable>();

	if (aL.size()>1){
	    //	aL.clear();
	
	    boolean even=true;
	    for (int i=0;i<aL.size();i++){
		if (even=!even){
		    a.add(aL.get(i));
		}else{
		    b.add(aL.get(i));
		}
	    }
	
	}
	mhelp(a);
	mhelp(b);
	
       

	int asize=a.size();
	int bsize=b.size();
	int ctr1=0;
	int ctr2=0;
	int ctr3=0;
	while ((asize>0) && (bsize>0)){
	    System.out.println(toString(aL));
	    if (a.get(ctr1).compareTo(b.get(ctr2))<0){
		aL.set(ctr3,a.get(ctr1));
		ctr1++;
	    }else{
		aL.set(ctr3,b.get(ctr2));
		ctr2++;
	    }
	    ctr3++;
	    asize--;
	    bsize--;
	}
	aL.addAll(a);
	aL.addAll(b);
	   
    
    }

    public static void randomAry(int range, int[] a){

	Random rand=new Random();
	
	for (int i=0;i<a.length;i++){
	    a[i]=rand.nextInt(range)-(range/2);
	}
	
	
    }

    public static String toString(ArrayList<Comparable> c){
	String list="[";
	for (int i=0;i<c.size();i++){
	    list+=""+c.get(i)+" ";
	}
	list+="]";
	return list;
    }

    public static String toString(int[] a){
	String list="[";
	for (int i=0;i<a.length;i++){
	    list+=""+a[i]+" ";
	}
	list+="]";
	return list;
    }
}
