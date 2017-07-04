package com.java.util.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	public static void main(String[] args) {
		int n = 8;//8个工人
		Semaphore semaphore = new Semaphore(2); //5台机器
		for (int i = 0; i < n; i++) {
			new Worker(i, semaphore).start();
		}
	}
	
	static class Worker extends Thread{
		private int num;
		private Semaphore semaphore;
		
		public Worker(int num, Semaphore semaphore) {
			this.num = num;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("工人"+this.num+"占用一个 机器在生产！");
				Thread.sleep(2000);
				System.out.println("工人"+this.num+"释放出机器！");
				Thread.sleep(1000);
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
