import java.util.ArrayList;
import java.util.List;

class Heap {
	List<Integer> heap = new ArrayList<>();

	public Heap() {
		super();
	}

	public void swap(int a, int b) {
		if (a == b)
			return;
		heap.set(a, heap.get(a) + heap.get(b));
		heap.set(b, heap.get(a) - heap.get(b));
		heap.set(a, heap.get(a) - heap.get(b));
	}

	public void heaplify(int size, int index) {
		int largest = index;
		int leftChildNode = 2 * index + 1;
		int rightChildNode = 2 * index + 2;
		if (leftChildNode < size && heap.get(leftChildNode) > heap.get(largest))
			largest = leftChildNode;
		if (rightChildNode < size && heap.get(rightChildNode) > heap.get(largest))
			largest = rightChildNode;
		if (largest != index) {
			swap(index, largest);
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
			swap(0, i);
			heaplify(i, 0);
		}
	}
}

public class TestHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap h = new Heap();
		h.add(10);
		h.add(8);
		h.add(9);
		h.add(7);
		h.add(6);
		h.add(7);
		h.sort();
		System.out.println(h.heap);
	}

}
