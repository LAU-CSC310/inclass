package quicksort;
import java.util.Arrays;
import java.util.Random;
public class QuickSort {
	static Random generator=new Random();
	int depth=0;

	
	int partition(int[] a,int start,int end) {
		//int pivotIdx=generator.nextInt(end-start+1)+start;
		int pivotIdx=end;
		
		int pivot=a[pivotIdx];
		a[pivotIdx]=a[end];
		a[end]=pivot;
		//assume the last element is the pivot;
		
		int i=start-1,tmp;
		for(int k=start;k<=end;++k) {
			if(a[k]<=pivot) {
				tmp=a[k];
				a[k]=a[i+1];
				a[i+1]=tmp;
				i++;
			}
		}
		return i;
	}
	void quickSort(int a[],int start,int end) {
		if(start>=end)return ;
		if(depth>1000) {
			insertionSort(a,start,end);
		}
		else {
			depth++;
			int pivotIdx=partition(a,start,end);
			quickSort(a,start,pivotIdx-1);
			quickSort(a,pivotIdx+1,end);
		}
	}
	void insertionSort(int[] a,int start,int end) {
		
		
		for(int i=start+1;i<=end;++i) {
			int tmp=a[i];
			int k=i;
			while( k>start && tmp<a[k-1]) {
				a[k]=a[k-1];
				k--;
			}
			a[k]=tmp;
		}
	}
	public static void main(String[] args) {
		//int[] a= {1,45,13,9,28,29,7,15};
		int n=1<<2;//  1<<1=> 10, 1<<2=>100, 1<<3=>1000, 1<<n=>2^n
		int[] a=new int[n];
		for(int i=0;i<n;++i)a[i]=i;
		int[] b=a.clone();
		QuickSort q=new QuickSort();
	
		long start=System.nanoTime();
		q.quickSort(b,0,b.length-1);
		long end=System.nanoTime();
		
		System.out.println((float)(end-start)/10e6+"milliseconds");
		Arrays.sort(a);
		System.out.println(Arrays.equals(a,b));
			

		

	}

}
