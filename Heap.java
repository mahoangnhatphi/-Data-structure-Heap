package heap;

import java.util.ArrayList;

class Heap {
	ArrayList<Integer> heap = new ArrayList<>();
	
	public Heap() {
	}
	
	public void heaplify(int size, int index) {
		int largest = index;
		int leftChildNode = 2 * index + 1;
		int rightChildNode = 2 * index + 2;
//		System.out.println(leftChildNode + " " + rightChildNode + " " + index);
		if (leftChildNode < size && heap.get(largest) < heap.get(leftChildNode))
			largest = leftChildNode;
		if (rightChildNode < size && heap.get(largest) < heap.get(rightChildNode)) 
			largest = rightChildNode;
		if (largest != index) {
			Integer tmp = heap.get(largest);
			heap.set(largest, heap.get(index));
			heap.set(index, tmp);
			heaplify(size, largest);
		}
	}
	
	public void add(Integer el) {
		heap.add(el);
		for (int i = 0; i < heap.size() / 2; i++) {
			heaplify(heap.size(), i);
		}
	}
	
	public void sort() {
		for (int i = heap.size() - 1; i >= 0; i--) {
			Integer tmp = heap.get(0);
			heap.set(0, heap.get(i));
			heap.set(i, tmp);
			heaplify(i, 0);
		}
	}
}

public class TestHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap heap = new Heap();
		heap.add(2);
		heap.add(8);
		heap.add(6);
		heap.add(1);
		heap.add(10);
		heap.add(15);
		heap.add(3);
		heap.add(12);
		heap.add(11);
		heap.sort();
		System.out.println(heap.heap);
		}

}
