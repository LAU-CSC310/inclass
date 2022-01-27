package countsort;
import java.util.Arrays;
public class CountingSort {

	public static void main(String[] args) {
		int[] a= {5,4,2,6,2,5};
		CountingSort cs=new CountingSort();
		cs.countingSort(a,6);
		System.out.println(Arrays.toString(a));
		
	}
	void countingSort(int a[], int max) {
		int[] c=new int[max+1];
		//initialize c
		for(int i=0;i<c.length;++i)
			c[i]=0;
		// count
		for(int i=0;i<a.length;++i)
			c[a[i]]++;
		
		int offset=0;
		for(int i=0;i<=max;++i)
			for(int j=0;j<c[i];++j) {
				a[offset]=i;
				offset++;
			}
		
	}
	
}
