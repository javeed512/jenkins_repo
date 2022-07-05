package com.wipro.springbootapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wipro.springbootapp.bean.Employee;

@Controller
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	@ResponseBody
	public String  hello() {
		
		
		return "Hello friends";
		
	}
	
	@RequestMapping("/display")
	public String  displayPage() {
		
		return "display";    // display.jsp
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String  addFormData(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		
		
		String eid =	request.getParameter("eid");
		String ename =	request.getParameter("ename");
		String salary =	request.getParameter("salary");
		
		Employee emp = new Employee();
			emp.setEid(Integer.parseInt(eid));
			emp.setEname(ename);
			emp.setSalary(Double.parseDouble(salary));
		
		session.setAttribute("emp", emp);	
		
		return "success";  //success.jsp
		
	}
	
	
	
	

}
