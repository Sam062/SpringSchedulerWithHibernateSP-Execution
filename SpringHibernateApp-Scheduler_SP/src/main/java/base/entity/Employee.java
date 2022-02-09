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

@Table
@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer emp_id;
	private String emp_name;
	private String emp_age;
	private String emp_sal;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_date;

	public Employee() {
		super();
	}

	public Employee(Integer emp_id, String emp_name, String emp_age, String emp_sal, Date created_date,
			Date updated_date) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_age = emp_age;
		this.emp_sal = emp_sal;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_age() {
		return emp_age;
	}

	public void setEmp_age(String emp_age) {
		this.emp_age = emp_age;
	}

	public String getEmp_sal() {
		return emp_sal;
	}

	public void setEmp_sal(String emp_sal) {
		this.emp_sal = emp_sal;
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
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_age=" + emp_age + ", emp_sal=" + emp_sal
				+ ", created_date=" + created_date + ", updated_date=" + updated_date + "]";
	}
	
}
