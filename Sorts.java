import java.util.*;
public class Sorts{
    public static void main(String[]args){
	Random rand=new Random();
	int[]a=new int[10];
	for (int i=0;i<10;i++){
	    a[i]=rand.nextInt(10);
	}
	System.out.println(toString(a));
	QuickSort(a);
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

    public static void QuickSort(int[] a){
	QuickSort(a,0,a.length-1);
    }

    public static void QuickSort(int[] a, int li, int gi){
	int temp=partition(a,li,gi);
	if (li==gi){
	    return;
	}
	QuickSort(a,li,temp-1);
	QuickSort(a,temp+1,gi);
	
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