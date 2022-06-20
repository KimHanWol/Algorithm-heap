package mainPakage;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr = new Integer[] {13, 17, 76, 88, 35, 112};
		
		BinaryHeap<Integer> bh = new BinaryHeap<Integer>(arr);
		bh.delMin();
		bh.delMin();
		bh.delMin();
		
		bh.delMax();
	}

}
