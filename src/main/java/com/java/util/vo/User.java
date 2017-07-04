package com.java.util.vo;

public class User implements Comparable<User>{
	
	private int num;
	
	public User(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public int compareTo(User o) {
		if(this.getNum()>o.getNum()){
			return -1;
		}
		return 0;
	}

	

}
