package minheap;

public class MinHeap {
	private int capacity;
	private int size=0;
	int[] array;
	
	public static void main(String[] args) {
		MinHeap heap=new MinHeap();
		heap.insert(30);
		heap.insert(25);
		heap.insert(20);
		heap.insert(15);
		heap.insert(18);
	}
	public MinHeap() {
		capacity=64;
		array=new int[capacity];
	}
	public MinHeap(int capacity) {
		this.capacity=capacity;
		array=new int[capacity];
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
	private void percolateDown() {
		int last=array[1];
		int hole=1,childIdx;
		while(2*hole<=size) {
			childIdx=2*hole;
			if(array[childIdx]>array[childIdx+1])childIdx++;
			if(array[childIdx]<last) {
				array[hole]=array[childIdx];
				hole=childIdx;
			}
			else break;
		}
		array[hole]=last;
	}
	public int deleteMin() {
		int min=array[1];
		array[1]=array[size--];
		percolateDown();
		return min;
	}
}
