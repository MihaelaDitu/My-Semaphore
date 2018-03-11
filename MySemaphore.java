
public class MySemaphore {

	private int maxSize;
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	private Counter counter = new Counter(maxSize);

	public MySemaphore(int maxSize) {
		this.maxSize = maxSize;
	}

	public synchronized void acquire() {
		synchronized (counter) {
			if (counter.equals(0)) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			counter.increment();
		}
		notify();
	}

	public synchronized void release() {
		synchronized (counter) {
			if (counter.equals(maxSize)) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			counter.decrement();
		}
		notify();

	}

}
