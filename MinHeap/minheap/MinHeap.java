package minheap;

public class MinHeap {
	private int capacity;
	private int size=0;
	int[] array;
	
	public static void main(String[] args) {
		
		int[] a= {53,26,17,23,34,41,12,5,9};
		MinHeap heap=new MinHeap(a);
		//MinHeap heap=new MinHeap();
//		heap.insert(30);
//		heap.insert(25);
//		heap.insert(20);
//		heap.insert(15);
//		heap.insert(18);
		System.out.println("Done");
	}
	public MinHeap() {
		capacity=64;
		array=new int[capacity];
	}
	public MinHeap(int capacity) {
		this.capacity=capacity;
		array=new int[capacity];
	}
	public MinHeap(int[] a) {
		capacity=64;
		array=new int[capacity];
		size=a.length;
		for(int i=0;i<a.length;++i)
			array[i+1]=a[i];
		
		for(int i=size/2;i>0;i--) {
			percolateDown(i);
		}
	}
	private void percolateUp(int hole) {
		int tmp=array[hole];
		while(hole/2>=1 && tmp<array[hole/2]) {
			array[hole]=array[hole/2];
			hole=hole/2;
		
		}
		array[hole]=tmp;
	}
	public void insert(int val) {
		//add code to check if the array is full
		array[++size]=val;
		percolateUp(size);
	}
	private void percolateDown(int hole) {
		int tmp=array[hole];
		int childIdx;
		while(2*hole<=size) {
			childIdx=2*hole;
			if(array[childIdx]>array[childIdx+1])childIdx++;
			if(array[childIdx]<tmp) {
				array[hole]=array[childIdx];
				hole=childIdx;
			}
			else break;
		}
		array[hole]=tmp;
	}
	public int deleteMin() {
		int min=array[1];
		array[1]=array[size--];
		percolateDown(1);
		return min;
	}
}
