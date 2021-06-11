package com.erp;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public ModelAndView process(String cud,HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException;
	public String process(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException;
}
