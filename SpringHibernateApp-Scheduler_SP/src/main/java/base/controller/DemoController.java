package base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import base.entity.Employee;
import base.entity.EmployeeBackup;
import base.service.EmployeeService;

@RestController
public class DemoController {
	@Autowired
	private EmployeeService serv;

	@PostMapping("/save")
	public @ResponseBody String saveEmp(@RequestBody Employee emp) {
		Integer add = serv.add(emp);
		return "EMPLOYEE DETAILS SAVED TO DB :: "+add +" :: "+emp ;
	}
	@PostMapping("/empbackupsave")
	public @ResponseBody String saveEmpBackup(@RequestBody EmployeeBackup emp) {
		Integer add = serv.add(emp);
		return "EMPLOYEE BACKUP DETAILS SAVED TO DB :: "+add +" :: "+emp ;
	}

	@GetMapping(value = "/emp")
	public @ResponseBody String showEmp() {
		Employee employee = new Employee(101, "SAM", "25", "5.5LPA", null, null);

		ObjectMapper mapper=new ObjectMapper();
		String writeValueAsString=null;
		try {
			writeValueAsString = mapper.writeValueAsString(employee);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return writeValueAsString;
	}
//	@GetMapping(value = "/empbackup")
//	public @ResponseBody String showEmpBackup() {
//		EmployeeBackup eb = new EmployeeBackup(101, 101, null, null);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		String writeValueAsString=null;
//		try {
//			writeValueAsString = mapper.writeValueAsString(eb);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return writeValueAsString;
//	}

	@GetMapping(value = "/empbyid")
	public @ResponseBody String showEmp(@RequestParam("empid") Integer id) {

		List<?> empById = serv.getEmpById(id);

		ObjectMapper mapper=new ObjectMapper();
		String writeValueAsString=null;
		try {
			writeValueAsString = mapper.writeValueAsString(empById);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return writeValueAsString;
	}
	@GetMapping(value = "/delbyempid")
	public @ResponseBody String delByEmpId(@RequestParam("empid") Integer id) {

		Integer flag = serv.delByEmpId(id);

		ObjectMapper mapper=new ObjectMapper();
		String writeValueAsString=null;
		try {
			writeValueAsString = mapper.writeValueAsString(flag);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return writeValueAsString;
	}

}
