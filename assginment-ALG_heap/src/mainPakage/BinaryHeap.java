package mainPakage;

public class BinaryHeap <T extends Comparable<T>>{
	
	private T[] arr;
	private int tail;
	
	public BinaryHeap(T[] arr) {
		this.arr = arr;
		tail = arr.length-1;
		printArray();
	}
	
	public void insert(T e) {
		if(tail == arr.length-1) resize(2);
		tail++;
		arr[tail] = e;
		swim(tail);
	}
	
	public T delMax() {
		T max = arr[tail--];
		System.out.println("max data out : " + max);
		printArray();
		return max;
	}
	
	public T delMin() {
		T min = arr[0];
		System.out.println("min data out : " + min);
		arr[0] = arr[tail--];
		printArray();
		
		sink(0);
		if(tail <= arr.length/4) resize(0.5f);
		return min;
	}
	
	private void sink(int index) {
		int pos = index + 1;
		
		while((pos * 2) - 1<= tail) {
			int leftChildPos = pos*2;
			int rightChildPos = leftChildPos + 1;
			int parentPos = pos;
			
			T parent = arr[parentPos - 1];
			T leftChild = arr[leftChildPos - 1];
			T rightChild = arr[rightChildPos - 1];
			
			if(less(parent, leftChild) && less(parent, rightChild)) break;

			if(less(leftChild, rightChild)) pos = leftChildPos; 
			else pos = rightChildPos;
			
			exchange(parentPos-1, pos-1);
			printArray();
		}
	}
	
	private void swim(int pos) {
		while(1<pos) {
			T child = arr[pos];
			T parent = arr[pos/2];
			if(less(parent, child)) break;
			else {
				exchange(pos, pos/2);
				pos = pos / 2;
			}
		}
	}
	
	private void exchange(int first, int second) {
		T tmp = arr[first];
		arr[first] = arr[second];
		arr[second] = tmp;
	}
	
	private void resize(float size) {
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) new Object[(int)(arr.length * size)];
		for(int i = 0; i<arr.length; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
	
	private boolean less(T first, T second) {
		if(first.compareTo(second) < 0) {
			return true;
		}
		else return false;
	}
	
	public void printArray() {
		for(int i = 0;i <= tail; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
