package com.erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);	
	EmpDao empDao = null;
	
	
	private int result =0;
	public EmpLogic() {
		logger.info("EmpLogic 호출 성공");
		this.empDao = new EmpDao();
	}
	
	public List<Map<String, Object>> login(Map<String, Object> loginMap) {
		//로그인 이벤트 시작
		logger.info("EmpLogic => 로그인 버튼");
		List<Map<String, Object>> rMap = new ArrayList<>();
		rMap = empDao.login(loginMap);
		return  rMap;
	}

	public List<Map<String, Object>> inoutList(Map<String, Object> pMap) {
		//메인페이지 오늘 출근 정보
		logger.info("EmpLogic => 메인페이지 출근 정보");
		List<Map<String, Object>> rList = new ArrayList<>();
		rList = empDao.inoutList(pMap);
		return rList;
	}

//	public List<Map<String, Object>> todayList(Map<String, Object> pMap) {
//		//메인페이지 오늘 나의 일정 정보
//		logger.info("EmpLogic => 메인페이지 일정 정보");
//		List<Map<String, Object>> rList = new ArrayList<>();
//		rList = empDao.todayList(pMap);
//		return rList;
//	}

	public List<Map<String, Object>> roomList(Map<String, Object> pMap) {
		//메인페이지 오늘 회의실예약 정보
		logger.info("EmpLogic => 메인페이지 회의실 예약 정보");
		List<Map<String, Object>> rList = new ArrayList<>();
		rList = empDao.roomList(pMap);
		return rList;
	}
	
	public List<Map<String, Object>> commuteList(Map<String, Object> pMap) {
		//메인페이지 오늘 업무시간 리스트
		logger.info("EmpLogic => 오늘 업무시간 리스트");
		List<Map<String, Object>> rList = new ArrayList<>();
		rList = empDao.commuteList(pMap);
		return rList;
	}

	public int myUpdImformation(Map<String, Object> pMap) {
		//내 정보 수정
		logger.info("EmpLogic => 내정보 수정");
		result = empDao.myUpdImformation(pMap);
		return result;
	}

	public List<Map<String, Object>> myInfoMap(Map<String, Object> pMap) {
		//내 정보 리스트
		logger.info("EmpLogic => 내 정보 리스트");
		List<Map<String, Object>> rList= new ArrayList<Map<String,Object>>();
		rList = empDao.myInfoMap(pMap);
		return rList;
	}

	public String newPassword(Map<String, Object> pMap) {
		logger.info("EmpLogic => 내 정보 리스트 => password 설정");
		String result = empDao.newPassword(pMap);
		return result;
	}

}
