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
    //QuickSort
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

    //MergeSort
    public static void mergeSort(int[] a){
	if (a.length<2){
	    return;
	}
	int[]p1=new int[a.length/2];
	int[]p2=new int[a.length-p1.length];
	int i1=0;
	int i2=0;
	for (int i=0;i<a.length;i++){
	    if (i%2==0){
		p2[i2]=a[i];
		i2++;
	    }else{
		p1[i1]=a[i];
		i1++;
	    }
	}
	if (!sorted(p1)){
	    mergeSort(p1);
	}
	if (!sorted(p2)){
	    mergeSort(p2);
	}
	int[]merged=merge(p1,p2);

	for (int i=0;i<merged.length;i++){
	    a[i]=merged[i];
	}
    }

    public static int[] merge(int[] a, int[] b){
	int[] merged=new int[a.length+b.length];
	int asize=a.length;
	int bsize=b.length;
	int ai=0;
	int bi=0;
	int ctr=0;
	while ((ai<asize) && (bi<bsize)){
	    if (a[ai]<=b[bi]){
		merged[ctr]=a[ai];
		ai++;
	    }else{
		merged[ctr]=b[bi];
		bi++;
	    }
	    ctr++;
	}
	if (bi==bsize){
	    for (int i=ai;i<asize;i++){
		merged[ctr]=a[i];
		ctr++;
	    }
	}else{
	    for (int i=bi;i<bsize;i++){
		merged[ctr]=b[i];
		ctr++;
	    }
	}
	return merged;
    }

    //radixSort
    public static void radixSort(int[] a){
	int power=1;
	int max=a[0]%10;
	for (int i=0;;i++){
	    ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>(10);
	    for (int z=0;z<10;z++){
		ArrayList<Integer> al=new ArrayList<Integer>();
		l.add(al);
	    }
	    for (int j=0;j<a.length;j++){
		l.get((a[j]/power)%10).add(a[j]);
		if (a[j]%10>max){
		    max=a[j]%10;
		}
	    }
	    int index=0;
	    int ctr=0;
	    for (int x=0;x<a.length;){
		if (l.get(ctr).size()>index){
		    a[x]=l.get(ctr).get(index);
		    index++;
		    x++;
		}else{
		    index=0;
		    ctr++;
		}
	    }
	    if (i==max){
		break;
	    }
	    power=power*10;
	}
	
    }
}
