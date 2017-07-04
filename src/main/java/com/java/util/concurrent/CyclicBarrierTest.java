package com.java.util.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	public static void main(String[] args) {
		while(true){
			int n = 5;
			CyclicBarrier barrier = new CyclicBarrier(4);
			for (int i = 1; i < n; i++) {
				new Writer(barrier,i).start();
			}
			try {
				Thread.sleep(9000);
				System.out.println("CyclicBarrier重用！");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Writer extends Thread {
		private CyclicBarrier barrier;
		
		private int n;
		
		public Writer(CyclicBarrier barrier,int n) {
			this.barrier = barrier;
			this.n = n;
		}
		
		@Override
		public void run() {
			System.out.println("线程"+Thread.currentThread().getName()+"正在读入数据....");
			try {
				Thread.sleep(n*1000);
				System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕！");
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("所有线程写入数据完毕，等待处理其他任务！！！");
		}
		
	}
}
