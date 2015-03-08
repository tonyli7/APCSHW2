import java.util.*;
public class QuickSelect{
    public static void main(String[]args){
	Random rand=new Random();
	int[]a=new int [8];
	a[0]=5;
	a[1]=7;
	a[2]=9;
	a[3]=8;
	a[4]=6;
	a[5]=1;
	a[6]=4;
	a[7]=2;

	System.out.println(QuickSelect(a,6));
	System.out.println(toString(a));
    }

    public static int partition(int[]ary,int si, int ei){
	Random rand=new Random();
	int pindex=rand.nextInt(ei-si+1)+si;
	int pivot=ary[pindex];

	int gindex=ei;
	int lindex=si;
	ary[pindex]=ary[gindex];
	ary[gindex]=pivot;
	int temp;
	for (int i=si;i<ei;i++){
	    if (ary[i]<pivot){
		temp=ary[i];
		ary[i]=ary[lindex];
		ary[lindex]=temp;
		lindex++;
	    }
	}
	temp=ary[lindex];
	ary[lindex]=ary[gindex];
	ary[gindex]=temp;
	System.out.println(toString(ary)+" : "+pivot+" "+lindex);
	return lindex;
    }

    public static int QuickSelect(int[] a, int n){
	Random rand=new Random();
	try{
	    return QuickSelect(a,n,0,a.length-1);
	}catch(IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public static int QuickSelect(int[] a, int n, int li, int gi){
	int temp=partition(a,li,gi);
	if (temp==n-1){
	    return a[n-1];
	}else if(temp>n-1){
	    return QuickSelect(a,n,li,temp-1);
	}
	return QuickSelect(a,n,temp+1,gi);
	
    }

    public static String toString(int[]a){
	String str="[";
	for (int i=0;i<a.length;i++){
	    str+=a[i]+",";
	}
	str+="]";
	return str;
    }
}
