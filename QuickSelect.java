import java.util.*;
public class QuickSelect{
    public static int[] D;
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
	System.out.println(toString(D));
    }

    public static void partition(int[]ary,int si, int ei){
	D=new int[ary.length];
	int pivot=ary[si];
	int gindex=ei;
	int lindex=si;
	for (int i=0;i<ary.length;i++){
	    if ((i<si) || (i>ei)){
		D[i]=ary[i];
	    }else if(i!=si){
		if (ary[i]<pivot){
		    D[lindex]=ary[i];
		    lindex++;
		}else{
		    D[gindex]=ary[i];
		    gindex--;
		}
		
	    }
	}
       
	D[lindex]=pivot;
	
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
