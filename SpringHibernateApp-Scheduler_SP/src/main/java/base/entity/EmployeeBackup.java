package base.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "EMPLOYEE_BACKUP")
@Entity
public class EmployeeBackup {
	@Id
	@GeneratedValue
	private Integer emp_backup_id;

	private Integer emp_id;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_date;

	public EmployeeBackup() {
		super();
	}

	public EmployeeBackup(Integer emp_backup_id, Integer emp_id, Date created_date, Date updated_date) {
		super();
		this.emp_backup_id = emp_backup_id;
		this.emp_id = emp_id;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}

	public Integer getEmp_backup_id() {
		return emp_backup_id;
	}

	public void setEmp_backup_id(Integer emp_backup_id) {
		this.emp_backup_id = emp_backup_id;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	@Override
	public String toString() {
		return "EmployeeBackup [emp_backup_id=" + emp_backup_id + ", emp_id=" + emp_id + ", created_date="
				+ created_date + ", updated_date=" + updated_date + "]";
	}

}
