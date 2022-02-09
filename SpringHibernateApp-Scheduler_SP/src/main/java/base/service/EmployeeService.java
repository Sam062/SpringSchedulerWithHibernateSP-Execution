package base.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.dao.EmployeeDao;
import base.entity.Employee;
import base.entity.EmployeeBackup;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	
	@Transactional
	public Integer add(Employee emp) {
		return dao.saveEmp(emp);
	}
	@Transactional
	public Integer add(EmployeeBackup emp) {
		return dao.saveEmp(emp);
	}
	
	public List<?> getEmpById(Integer emp_id) {
		return dao.getEmpById(emp_id);
	}
	
	@Transactional
	public void getAllEmpBySp() {
		 dao.getAllEmpBySp();
	}
	public Integer delByEmpId(Integer emp_id) {
		return dao.delEmpById(emp_id);
	}
	
	public List<EmployeeBackup> getEmpBackupList() {
		return dao.getEmpBackupList();
		
		
	}

}
