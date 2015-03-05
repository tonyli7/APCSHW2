import java.util.*;
public class Sorts{
    public static void main(String[]args){
	int[] ary=new int[4];
	randomAry(20,ary);
	System.out.println(toString(ary));
	int[] ar=new int[4];
	randomAry(20,ar);
	System.out.println(toString(ar));
	mergeSort(ar);
	System.out.println(toString(ar));
	//	System.out.println(toString(merge(ary,ar)));
	
    }
    
  

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
		p1[i1]=a[i];
		i1++;
	    }else{
		p2[i2]=a[i];
		i2++;
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
	if (asize>bsize){
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
    public static void randomAry(int range, int[] a){

	Random rand=new Random();
	
	for (int i=0;i<a.length;i++){
	    a[i]=rand.nextInt(range)-(range/2);
	}
	
	
    }
  
    public static String toString(int[] a){
	String list="[";
	for (int i=0;i<a.length;i++){
	    list+=""+a[i]+" ";
	}
	list+="]";
	return list;
    }

    public static boolean sorted(int[] a){
	for (int i=0;i<a.length-1;i++){
	    if (a[i]>a[i+1]){
		return false;
	    }
	}
	return true;
    }
}
