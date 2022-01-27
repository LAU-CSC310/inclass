package sort;
import java.util.Arrays;
public class Sort {

	public static void main(String[] args) {
		
		
		int[] a= {18,14,7,4,3};
	
		int[] r;
		r=insertionSort(a);
		
		System.out.println(Arrays.toString(a));
		System.out.println("comp="+r[0]+" swap="+r[1]);
	}

	public static int[] insertionSort(int[] a) {
		int comp=0;
		int swap=0;
		int n=a.length;
		for(int i=1;i<n;++i) {
			int tmp=a[i];
			int k=i;
			while( k>0 && (++comp>0) && tmp<a[k-1]) {
				a[k]=a[k-1];
				
				swap++;
				k--;
			}
			a[k]=tmp;
		}
		int[] r= {comp,swap};
		return r;
	}
	public static int[] bubbleSort(int[] a) {
		int n=a.length;
		int comp=0;
		int swap=0;
		for(int j=0;j<n-1;++j) {
			for(int i=0;i<n-1;++i)
				if((++comp>0) && a[i]>a[i+1]  ) {
					swap++;
					int tmp=a[i];
					a[i]=a[i+1];
					a[i+1]=tmp;
				}
					
			
		}
		int[] r= {comp,swap};
		return r;
	}
	public static void selectionSort(int[] a) {
		int n=a.length;
		
		
		//once the smallest n-1 elements
		// are in place the last is in place
		for(int j=0;j<n-1;++j) {
			int minIdx=j;
			for(int i=j+1;i<n;++i) 
				if (a[i]<a[minIdx])minIdx=i;
			
			int tmp=a[j];
			a[j]=a[minIdx];
			a[minIdx]=tmp;
			
		}
		
		
	}
	
}
