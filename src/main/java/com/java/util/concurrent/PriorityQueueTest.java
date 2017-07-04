package com.java.util.concurrent;

import java.util.concurrent.PriorityBlockingQueue;

import com.java.util.vo.User;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityBlockingQueue<User> blockingQueue = new PriorityBlockingQueue<User>();
		User u1 = new User(1);
		User u3 = new User(3);
		User u2 = new User(2);
		blockingQueue.add(u1);
		blockingQueue.add(u3);
		blockingQueue.add(u2);
		System.out.println(blockingQueue.poll().getNum());
		System.out.println(blockingQueue.poll().getNum());
		System.out.println(blockingQueue.poll().getNum());
	}

}
