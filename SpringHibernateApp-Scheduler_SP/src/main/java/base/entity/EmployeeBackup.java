package base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "EMPLOYEE_BACKUP")
@Entity
public class EmployeeBackup {
	@Id
	@GeneratedValue
	private Integer emp_backup_id;

	public EmployeeBackup() {
		super();
	}

	public Integer getEmp_backup_id() {
		return emp_backup_id;
	}

	public void setEmp_backup_id(Integer emp_backup_id) {
		this.emp_backup_id = emp_backup_id;
	}


}
