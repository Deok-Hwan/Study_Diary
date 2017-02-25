package com.model;

public class TetrisScore {
	public int score;//�쁽�옱 �젏�닔
	
	public TetrisScore(){
		score = 0;
	}
	
	public void scoreUp(){
		score = score + 100;
	}
}
