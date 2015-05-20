import java.util.*;
import java.lang.*;
public class Sorts{
    public static void main(String[]args){
	int[] a=new int[10];
	for (int i=0;i<10;i++){
	    a[i]=i;
	}
	System.out.println(toString(a));
	heapSort(a);
	System.out.println(toString(a));
    }

    public static void bubbleSort(int[] a){
	int temp=0;
	for (int j=0;j<a.length-1;j++){
	    boolean check=true;
	    for (int i=0;i<a.length-1;i++){
		if (a[i]>a[i+1]){
		    temp=a[i+1];
		    a[i+1]=a[i];
		    a[i]=temp;
		    check=false;
		}
	    }
	    if (check){
		break;
	    }
	}
    }

    public static void selectionSort(int[] a){
	int min;
	int temp;
	for (int j=0;j<a.length-1;j++){
	    min=a[j];
	    int i=j+1;
	    for (;i<a.length;i++){
		if (a[i]<min){
		    min=a[i];
		}
	    }
	    a[find(min,a)]=a[j];
	    a[j]=min;
	}
    }
   

    public static void insertionSort(int[] a){
	int temp=0;
	for (int i=0;i<a.length-1;i++){
	    if (a[i+1]<a[i]){
		temp=a[i+1];
		int j=i;
	
		for (;(j>=0)&&(temp<a[j]);j--){
		    a[j+1]=a[j];
		}
	
		a[j+1]=temp;
	    }
	}
    }

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

    public static void MergeSort(int[] a){
	MergeSort(a, 0, a.length/2);
    }

    public static void MergeSort(int[] a, int start1, int start2){
	if (start1==start2){
	    //compare and merge
	}
	else{
	    //split 
	}
    }


    //helpers
    public static int find(int target, int[] a){
	for (int i=0;i<a.length;i++){
	    if (target==a[i]){
		return i;
	    }
	}
	return -1;
    }

    public static int digits(int a){
	if (a/10==0){
	    return 1;
	}
	return digits(a/10)+1;
    }
  
    public static void heapSort(int[] a){
	for (int i=a.length-1;i>-1;i--){
	    heapify(a,i);
	}
	for (int i=a.length-1;i>-1;i--){
	    int temp=a[i];
	    a[i]=a[0];
	    a[0]=temp;
	   
	    pushDown(0,a[0],a, i-1);
	  
	}
	
    }

    public static void heapify(int[] a, int currIndex){
	int left,right;
	if (currIndex*2+1>a.length-1){
	    return;
	}if (currIndex*2+2>a.length-1){
	    left=a[currIndex*2+1];
	    if (left>a[currIndex]){
		int temp=a[currIndex];
		a[currIndex]=left;
		a[currIndex*2+1]=temp;
		heapify(a,currIndex*2+1);
	    }
	}else{
	    left=a[currIndex*2+1];
	    right=a[currIndex*2+2];
	    int curr=a[currIndex];
	    if (left>curr && left>right){
		int temp=a[currIndex];
		a[currIndex]=left;
		a[currIndex*2+1]=temp;
		heapify(a,currIndex*2+1);
	    }else if (right>curr && right>left){
		int temp=a[currIndex];
		a[currIndex]=right;
		a[currIndex*2+2]=temp;
		heapify(a,currIndex*2+2);
	    }	   
	}

    }

    public static void pushDown(int currIndex, int root, int[] a, int index){
	if (currIndex*2+1>index && currIndex*2+2>index){
	  
	    return;
	}
	if (currIndex*2+2>index){
	    int left=a[currIndex*2+1];
	    if (left>root){
		a[currIndex*2+1]=root;
		a[currIndex]=left;
		pushDown(currIndex*2+1,root,a,index);
	    }
	}else{
	    int left=a[currIndex*2+1];
	    int right=a[currIndex*2+2];
	    if (left>root && left>right){
		a[currIndex*2+1]=root;
		a[currIndex]=left;
		pushDown(currIndex*2+1,root,a,index);
	    } else if (right>root && right>left){
		a[currIndex*2+2]=root;
		a[currIndex]=right;
		pushDown(currIndex*2+2,root,a,index);
	    }
	}

    }

    public static String toString(int[]a){
	String s="[";
	for (int i=0;i<a.length;i++){
	    s=s+(a[i]+"");
	    if (i!=a.length-1){
		s+=" , ";
	    }  
	}
	s+="]";
	return s;
    }

}
