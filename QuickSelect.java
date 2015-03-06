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
	int pivot=(rand.nextInt(0,ei-si+1)+si);
	int gindex=ei;
	int lindex=si;
	for (int i=si;i<=ei;i++){
	    if (ary[i]<pivot){
		ary[lindex]=ary[i];
		lindex++;
	    }else if(ary[i]>pivot){
		ary[gindex]=ary[i];
		gindex--;
	    }
	}
       
	ary[lindex]=pivot;
	
    }

    public static int QuickSelect(int kth,int[] a){
	
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
