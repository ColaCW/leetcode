import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Book {
	int bookNum = 1;
	private final Lock lock = new ReentrantLock();

	void onlySellOne() {
		System.out.println(Thread.currentThread().getName() + " 进入书店 ");
		System.out.println(Thread.currentThread().getName() + " 还剩 " + bookNum);
		synchronized (this) {
//			lock.lock();
			if (bookNum > 0) {
				System.out.println(Thread.currentThread().getName() + " 买书");
				bookNum--;
				System.out.println(Thread.currentThread().getName() + " 买走书 ，剩余" + bookNum);
			} else {
				System.out.println(Thread.currentThread().getName() + " 已经卖完了");
			}
//			lock.unlock();
		}
		System.out.println(Thread.currentThread().getName() + " 走出书店 ");
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		Book book = new Book();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				book.onlySellOne();

			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				book.onlySellOne();
			}
		});
		t1.start();
		t2.start();
	}
}
