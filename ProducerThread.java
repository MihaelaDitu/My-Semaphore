import java.util.Stack;
import java.util.concurrent.Semaphore;

public class ProducerThread extends Thread {

	private MySemaphore fullSemapfore;
	private MySemaphore freeSemapfore;
	private Stack<Product> stack;
	private Product newProduct;

	public ProducerThread(Stack stack, MySemaphore fullSemapfore, MySemaphore freeSemapfore) {
		this.stack = stack;
		this.fullSemapfore = fullSemapfore;
		this.freeSemapfore = freeSemapfore;
	}

	@Override
	public void run() {
		while (true) {
			produceProduct();

			freeSemapfore.acquire();

			pushProduct();
			fullSemapfore.release();
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void pushProduct() {
		stack.push(newProduct);
	}

	public void produceProduct() {
		newProduct = new Product();
		System.out.println("Product produced");
	}

}
