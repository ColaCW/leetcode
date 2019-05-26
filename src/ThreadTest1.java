
public class ThreadTest1 {

	public static String a = "a";
	public static String b = "b";
	public static String lock_status = "true";

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(lock_status) {
					synchronized (a) {
						System.out.println("我是A方法中获得到了A锁");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						synchronized (b) {
							System.out.println("我是A方法中获取到B锁");
						}
					}
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(lock_status) {
					synchronized (b) {
						System.out.println("我是B方法中获得到了B锁");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						synchronized (a) {
							System.out.println("我是B方法中获取到A锁");
						}
					}
				}
			}
		});
		thread1.start();
		thread2.start();
	}

}
