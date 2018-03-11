import java.util.Stack;
import java.util.concurrent.Semaphore;

public class ConsumerThread extends Thread {

	private MySemaphore fullSemapfore;
	private MySemaphore freeSemapfore;
	private Stack stack;
	private IProduct product;

	public ConsumerThread(Stack stack, MySemaphore fullSemapfore, MySemaphore freeSemapfore) {
		this.stack = stack;
		this.fullSemapfore = fullSemapfore;
		this.freeSemapfore = freeSemapfore;
	}

	@Override
	public void run() {
		while (true) {

			fullSemapfore.acquire();

			freeSemapfore.release();
			consumeProduct();
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void popProduct() {
		product = (IProduct) stack.pop();
	}

	public void consumeProduct() {
		System.out.println("Product consumed");
	}

}
