package com.vo;

import java.io.Serializable;
/*
 * private
 * public  차이점 생각해 보기
 * 로컬 시스템
 * 설치하고 개인 컴에서 작업진행 
 * 웹시스템
 * 외부에서 공격 당할 수 있다.
 * 동시에 많은 사용자가 접속을 한다.
 * 프로토콜을 활용해서 통신
 * 인스턴스화를 해서 사용하게 되므로 얼마든지 복제본이 만들어 지고
 * 사용되고 나면 서블릿과 함께 파기됨.(init()-service()-destroy())
 */
public class DeptVO implements Serializable{
	private int deptno=0;
	private String dname=null;
	private String loc=null;
	private EmpVO empVO = null;
	//VO패턴에서도 생성자가 역할이 있을까요?
	public DeptVO() {
	}
	public DeptVO(int deptno) {
		
	}
	public DeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public EmpVO getEmpVO() {
		return empVO;
	}
	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}
}
