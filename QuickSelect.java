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
	System.out.println(toString(a));
	partition(a,2,7);
	System.out.println(toString(a));
    }

    public static void partition(int[]ary,int si, int ei){
	Random rand=new Random();
	int pindex=rand.nextInt(ei-si+1)+si;
	int pivot=ary[pindex];
	System.out.println(pivot);
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
    }

    public static int QuickSelect(int kth,int[] a){
	return 1;
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
