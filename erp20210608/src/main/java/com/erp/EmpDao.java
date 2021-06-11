package com.erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class EmpDao {
	
	Logger logger = Logger.getLogger(EmpDao.class);
	public SqlSessionFactory sqlMapper = MyBatisCommonFactory.getSqlSessionFactory();
	public SqlSession sqlSec = null;
	private int result = 0;
	public EmpDao() {
		logger.info("EmpDao() 호출 성공"); 
		//sqlMapper= MyBatisCommonFactory.getSqlSessionFactory();
		logger.info("sqlMapper ===> "+sqlMapper);
		sqlSec = sqlMapper.openSession();
	}
	
	public List<Map<String, Object>> login(Map<String, Object> loginMap) {
		//로그인 이벤트
		logger.info("EmpDao() => 로그인"); 
		List<Map<String, Object>> rMap = new ArrayList<>();
		System.out.println(loginMap.get("emp_no"));
		System.out.println(loginMap.get("emp_pw"));
		sqlSec.selectOne("proc_empLogin",loginMap);
		rMap = (List<Map<String,Object>>) loginMap.get("key");
		System.out.println(rMap.get(0).get("EMP_NO"));
		System.out.println(rMap.get(0).get("EMP_NAME"));
		return rMap;
	}
   
	public List<Map<String, Object>> inoutList(Map<String, Object> pMap) {
		//오늘 출근정보 담기
		logger.info("EmpDao() => 메인페이지 오늘 출근 정보 담기"); 
		List<Map<String, Object>> inoutList = new ArrayList<>();
		sqlSec.selectList("proc_commute",pMap);
		inoutList=(List<Map<String,Object>>)pMap.get("key");
		return inoutList;
	}

	
//	  public List<Map<String, Object>> todayList(Map<String, Object> pMap) {
//		  //오늘일정 얻어오기 
//	 logger.info("EmpDao() => 메인페이지 일정 정보"); 
//	 List<Map<String,Object>> todayList = new ArrayList<>();
//	  sqlSec.selectList("proc_taskTime",pMap);
//	  todayList=(List<Map<String,Object>>)pMap.get("key"); 
//	  return todayList; }
	 
	
	public List<Map<String, Object>> commuteList(Map<String, Object> pMap) {
		//오늘 일정 얻어오기
		logger.info("EmpDao() => 오늘 업무시간 리스트"); 
		List<Map<String, Object>> todayTaskList = new ArrayList<>();
		sqlSec.selectList("proc_taskTime",pMap);
		todayTaskList=(List<Map<String,Object>>)pMap.get("key");
		return todayTaskList;
	}

	public List<Map<String, Object>> roomList(Map<String, Object> pMap) {
		//오늘 회의실 예약일정 얻어오기
		logger.info("EmpDao() => 메인페이지 회의실 예약 정보 담기"); 
		List<Map<String, Object>> roomList = new ArrayList<>();
		sqlSec.selectList("proc_todaycfr",pMap);
		roomList = (List<Map<String,Object>>) pMap.get("key");
		return roomList;
	}

	public int myUpdImformation(Map<String, Object> pMap) {
		//내 정보 수정 저장
		logger.info("EmpDao() => 내 정보 수정 저장버튼"); 
		result=sqlSec.update("myUpdImformation",pMap);
		return result;
	}

	public List<Map<String, Object>> myInfoMap(Map<String, Object> pMap) {
		//내 정보 리스트 가져오기
		logger.info("EmpDao() => 내 정보 설정 리스트 가져오기"); 
		List<Map<String, Object>> myInfoList = new ArrayList<Map<String,Object>>();
		sqlSec.selectOne("PROC_NEMPLIST",pMap);
		myInfoList=(List<Map<String, Object>>)pMap.get("key");
		return myInfoList;
	}

	public String newPassword(Map<String, Object> pMap) {
		//비밀번호 재설정
		logger.info("EmpDao => 내 정보 리스트 => password 설정");
		sqlSec.selectOne("proc_newPassword",pMap);
		String result = pMap.get("msg").toString();
		return result;
	}

	
}
