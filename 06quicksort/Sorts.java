import java.util.*;
public class Sorts{
    public static void main(String[]args){
	Random rand=new Random();
	int[]a=new int[10];
	for (int i=0;i<10;i++){
	    a[i]=rand.nextInt(10);
	}
	/*
	int[]a=new int [8];
	a[0]=5;
	a[1]=7;
	a[2]=9;
	a[3]=8;
	a[4]=6;
	a[5]=1;
	a[6]=4;
	a[7]=2;
	*/
	System.out.println(toString(a));
	QuickSort(a);
	System.out.println(toString(a));
    }

     public static int partition(int[]ary,int si, int ei){
	Random rand=new Random();
	//	System.out.println(si+"---"+ei);
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
	System.out.println(toString(ary)+" : "+pivot+" "+lindex+" "+si+" "+ei);
	return lindex;
    }

    public static void QuickSort(int[] a){
	QuickSort(a,0,a.length-1);
    }

    public static void QuickSort(int[] a, int li, int gi){
	if (li>=gi){
	    return;
	}
	
	int temp=partition(a,li,gi);
	   
	System.out.println(temp);
	QuickSort(a,li,temp-1); //left
	QuickSort(a,temp+1,gi); //right
	    
	//    if(temp!=gi){
	//	QuickSort(a,temp+1,gi); //right
	// }
    }
    

    public static String toString(int[]a){
	String str="[";
	for (int i=0;i<a.length;i++){
	    str+=a[i]+",";
	}
	str+="]";
	return str;
    }

    public String name(){
	return "li.tony";
    }

    
}
