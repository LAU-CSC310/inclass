package minheap;

public class MinHeapForGraphs {
	private int capacity;
	private int size=0;
	int[] keys;//used for min values that are usually updated during an algorithm
	int [] v_indices;// corresponding vertex indices that DO NOT change
	
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
	public MinHeapForGraphs() {
		capacity=64;
		keys=new int[capacity];
	}
	public MinHeapForGraphs(int capacity) {
		this.capacity=capacity;
		keys=new int[capacity];
	}
	public MinHeapForGraphs(int[] a) {
		capacity=64;
		keys=new int[capacity];
		size=a.length;
		for(int i=0;i<a.length;++i)
			keys[i+1]=a[i];
		
		for(int i=size/2;i>0;i--) {
			percolateDown(i);
		}
	}
	private void percolateUp(int hole) {
		int tmp=keys[hole];
		int v_idx=v_indices[hole];
		while(hole/2>=1 && tmp<keys[hole/2]) {
			keys[hole]=keys[hole/2];
			v_indices[hole]=v_indices[hole/2];
			hole=hole/2;
		
		}
		keys[hole]=tmp;
		v_indices[hole]=v_idx;
	}
	public void insert(int val,int v_idx) {
		//add code to check if the keys array is full
		keys[++size]=val;
		v_indices[size]=v_idx;
		percolateUp(size);
	}
	private void percolateDown(int hole) {
		int tmp=keys[hole];
		int v_idx=v_indices[hole];//to keep track of vertex idx
		int childIdx;
		while(2*hole<=size) {
			childIdx=2*hole;
			if(childIdx<size && keys[childIdx]>keys[childIdx+1])childIdx++;
			if(keys[childIdx]<tmp) {
				keys[hole]=keys[childIdx];
				v_indices[hole]=v_indices[childIdx];
				hole=childIdx;
			}
			else break;
		}
		keys[hole]=tmp;
		v_indices[hole]=v_idx;
	}
	public int deleteMin() {
		int min=keys[1];
		int min_idx=v_indices[1];
		keys[1]=keys[size];
		v_indices[1]=v_indices[size];
		size--;
		percolateDown(1);
		return min;
	}
}
