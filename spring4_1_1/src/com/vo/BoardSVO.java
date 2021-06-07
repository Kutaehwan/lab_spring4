package com.vo;

public class BoardSVO {
	// SCOTT 계정의 board_sub2019 테이블
	private int bm_no     = 0; 
	private int bs_seq    = 0; 
	private String bs_file   = ""; 
	private double bs_size   = 0.0;
//	private BoardMVO bmVO = null; // 이 방법도 있지만  Map를 사용하는 것을 권장한다. : JOIN
	
	public int getBm_no() {
		return bm_no;
	}
	public void setBm_no(int bm_no) {
		this.bm_no = bm_no;
	}
	public int getBs_seq() {
		return bs_seq;
	}
	public void setBs_seq(int bs_seq) {
		this.bs_seq = bs_seq;
	}
	public String getBs_file() {
		return bs_file;
	}
	public void setBs_file(String bs_file) {
		this.bs_file = bs_file;
	}
	public double getBs_size() {
		return bs_size;
	}
	public void setBs_size(double bs_size) {
		this.bs_size = bs_size;
	}
}
