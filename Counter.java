
public class Counter {

	private int value;

	public Counter(int maxSize) {
		this.value = maxSize;
	}

	public void decrement() {
		value--;
	}

	public void increment() {
		value++;
	}

	@Override
	public boolean equals(Object arg0) {
		return value == (int) arg0;
	}
}
