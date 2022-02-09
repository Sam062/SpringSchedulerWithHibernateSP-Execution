package base.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import base.entity.Employee;
import base.entity.EmployeeBackup;

@Repository
public class EmployeeDao {

	@Autowired
	private HibernateTemplate ht;

	@Autowired
	private SessionFactory sf;

	public Integer saveEmp(Employee emp) {
		return (Integer) ht.save(emp);
	}
	public Integer saveEmp(EmployeeBackup emp) {
		return (Integer) ht.save(emp);
	}

	public List<?> getEmpById(Integer emp_id) {
		String q="SELECT * FROM EMPLOYEE WHERE emp_id= :emp_id";
		List<?> list=new ArrayList<>(); 
		try {
			Session session=sf.openSession();
			Query<?> query=session.createSQLQuery(q).addEntity(Employee.class);
			query.setParameter("emp_id", emp_id);

			list = query.list();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void getAllEmpBySp() {
		String q="CALL getAllEmployees()";
		Transaction tx=null;
		int list; 
		try {
			Session session=sf.openSession();
			tx=session.beginTransaction();
			Query<?> query=session.createSQLQuery(q);

			list = query.executeUpdate();
			tx.commit();
			System.out.println("***** ***** SP CALLED AND AFFACTED RECORDS :: ->"+list);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public Integer delEmpById(Integer emp_id) {
		String q="DELETE FROM EMPLOYEE WHERE emp_id= :emp_id";
		Integer flag=null;
		Transaction tx=null;
		try {
			Session session=sf.openSession();
			tx = session.beginTransaction();
			Query<?> query=session.createSQLQuery(q);
			query.setParameter("emp_id", emp_id);

			flag = query.executeUpdate();
			if(tx!=null)
				tx.commit();
			System.out.println(flag);
		} catch (Exception e) {
			try {
				if(tx!=null)
					tx.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}

}
