package com.erp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class EmpController implements Controller {
	String requestName = null;
	EmpLogic empLogic = null;
	Logger logger = Logger.getLogger(EmpController.class);
	
	public EmpController(String requestName) {
		logger.info("EmpController 생성 성공");
		this.requestName=requestName;
		empLogic = new EmpLogic();

	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("process 호출 성공");
		String path = null;
		int result = 0;
		Map<String,Object> pMap = null;
		HttpSession session = req.getSession();
		if("login".equals(requestName)) {
			logger.info("EmpController => 로그인 호출");
			/////////////////////// 실제 코드    /////////////////////
			Map<String,Object> loginMap= HashMapBuilder.hashMapBuilder(req.getParameterMap());
			List<Map<String,Object>> rList = new ArrayList<>();
			rList =empLogic.login(loginMap);
			
			String emp_no =rList.get(0).get("EMP_NO").toString();
			String emp_name =rList.get(0).get("EMP_NAME").toString();
			String dept_name =rList.get(0).get("DEPT_NAME").toString();
			System.out.println(emp_name);
			session.setAttribute("emp_no",emp_no);
			session.setAttribute("emp_name",emp_name);
			session.setAttribute("dept_name",dept_name);
			
			if("비밀번호가 틀립니다".equals(emp_name)||"아이디가 없습니다".equals(emp_name)){
				path="redirect:./login.jsp?msg="+emp_name;
			}else {
				logger.info("메인페이지 호출");
				pMap = new HashMap<>();
				pMap.put("emp_no", emp_no);
				//pMap.put("emp_no", session.getAttribute("emp_no"));
//				List<Map<String,Object>> inoutList = empLogic.inoutList(pMap);
//				System.out.println("오늘 출근 리스트 사이즈 => "+inoutList.size());
//				req.setAttribute("inOutList", inoutList);
//				List<Map<String,Object>> todayList = empLogic.todayList(pMap);
//				System.out.println("오늘일정 리스트 사이즈 => "+todayList.size());
//				req.setAttribute("todayList", todayList);
//				List<Map<String,Object>> roomList = empLogic.roomList(pMap);
//				System.out.println("오늘 회의실 예약 리스트 => "+roomList.size());
//				req.setAttribute("roomList", roomList);
				List<Map<String,Object>> taskTimeList = empLogic.commuteList(pMap);
				System.out.println("오늘 업무시간 리스트 => "+taskTimeList.size());
				req.setAttribute("taskTimeList", taskTimeList);
				path="forward:main.jsp";
			}
		}
//		else if("roomList".equals(requestName)) {
//			pMap = new HashMap<>();
//			List<Map<String,Object>> roomList = empLogic.roomList(pMap);
//			System.out.println("오늘 회의실 예약 리스트 => "+roomList.size());
//			req.setAttribute("roomList", roomList);
//			path="forward:jsonRoomList.jsp";
//		}
//		else if("inoutList".equals(requestName)) {
//			String emp_no = session.getAttribute("emp_no").toString();
//			pMap = new HashMap<>();
//			pMap.put("emp_no", emp_no);
//			List<Map<String,Object>> inoutList = empLogic.inoutList(pMap);
//			System.out.println("오늘 출근 리스트 사이즈 => "+inoutList.size());
//			req.setAttribute("inOutList", inoutList);
//			path="forward:./jsonInOutList.jsp";
//		}
		else if("myUpdImformation".equals(requestName)) {
			logger.info("EmpController => 내정보 수정 버튼 호출");
			/////////////////////// 실제 코드    /////////////////////
			pMap= HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", session.getAttribute("emp_no"));
			result =empLogic.myUpdImformation(pMap);
			System.out.println("회원정보 등록 성공 여부 : "+result);
			if(result == 1) path="redirect:xxx.erp"; 
			else if(result == 0) path="redirect:error.jsp"; 
			///////////////////////  테스트 코드   /////////////////////
			/*
			Map<String,Object> pMap = new HashMap<>();
			pMap.put("emp_no", 10001);
			pMap.put("emp_photo", "test1.jpg");
			pMap.put("emp_pw", "1234");
			pMap.put("emp_phone", "010-1234-5678");
			pMap.put("emp_email", "test11@naver.com");
			pMap.put("emp_address", "경기도 안산시 단원구 103번지");
			result =empLogic.myUpdImformation(pMap);
			System.out.println("회원정보 등록 성공 여부 : "+result);
			if(result == 1) path="redirect:xxx.jsp"; 
			else if(result == 0) path="redirect:error.jsp"; 
			*/
		}
		else if("newPassword".equals(requestName)) {
			logger.info("EmpController => 비밀번호 변경 검증");
			/////////////////////// 실제 코드    /////////////////////
			pMap= HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", session.getAttribute("emp_no"));
			String new_pw =empLogic.newPassword(pMap);
			if(new_pw.equals("1")) path="redirect:xxx.erp"; 
			else path="redirect:error.jsp"; 
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			Map<String,Object> pMap = new HashMap<>();
			pMap.put("emp_no", 10001);
			pMap.put("emp_pw", 1234);
			pMap.put("new_pw", 123);
			pMap.put("new_repw", 123);
			String new_pw =empLogic.newPassword(pMap);
			System.out.println(new_pw);
			if(new_pw.equals("1")) path="redirect:xxx.jsp"; 
			else path="redirect:error.jsp"; 
			 */
		}
		
		return path;
	}

	@Override
	public ModelAndView process(String cud,HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Map<String,Object> rMap = new HashMap<>();
		Map<String,Object> pMap = new HashMap<>();
		//pMap.put("emp_no", session.getAttribute("emp_no"));
		//pMap.put("emp_no", 10001);
		ModelAndView mav = new ModelAndView(req,res);
		
//		if("empEdit".equals(cud)) {
//			logger.info("내정보 수정 호출");
//			List<Map<String,Object>> myInfoList = empLogic.myInfoMap(pMap);
//			System.out.println("내정보 리스트 사이즈 =>"+myInfoList.size());
//			Gson g = new Gson();
//			String imsi = g.toJson(myInfoList);
//			System.out.println(imsi);
//			mav.addObject("myInfoList", myInfoList);
//			mav.setViewName("");
//		}
		
		///메인 페이지 json
		 if("roomList".equals(cud)) {
			pMap = new HashMap<>();
			List<Map<String,Object>> roomList = empLogic.roomList(pMap);
			System.out.println("오늘 회의실 예약 리스트 => "+roomList.size());
			mav.addObject("roomList", roomList);
			mav.setViewName("jsonRoomList");
		}
		else if("inoutList".equals(cud)) {
			String emp_no = session.getAttribute("emp_no").toString();
			pMap = new HashMap<>();
			pMap.put("emp_no", emp_no);
			List<Map<String,Object>> inoutList = empLogic.inoutList(pMap);
			System.out.println("오늘 출근 리스트 사이즈 => "+inoutList.size());
			mav.addObject("inOutList", inoutList);
			mav.setViewName("jsonInOutList");
		}
		return mav;
	}

}
