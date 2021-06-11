package com.erp;

import org.apache.log4j.Logger;

public class ControllerMapper5 {
	static Logger logger = Logger.getLogger(ControllerMapper5.class);
	
//	static Controller controller = null;
	public static Controller getController(String command) {
		Controller controller = null;
		String commands[] = command.split("/"); 
			
			if(commands.length==2) { 
				String work = commands[0];
				String requestName = commands[1];
				logger.info("work ==>"+work   );
				logger.info("requestName ==>"+requestName);
				if("emp".equals(work)) {
					//로그인 컨트롤러
					controller = new EmpController(requestName);
				}else if("myService".equals(work)) {
					//myService메뉴 
					//controller = new MyServiceController(requestName);
				}
			}
		return controller;
	}//////end of getController
}
