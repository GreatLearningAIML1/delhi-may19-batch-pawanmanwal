package com.main.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.main.model.Employee;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addEmployee(Employee employee) {
		boolean retVal = true;
		try {
			entityManager.persist(employee);
		} catch (Exception e) {
			retVal = false;
			System.out.println(printStackTrace(e));
		}
		return retVal;
	}

	@Override
	public List<Employee> getEmployeeDetails(String name, Date startDate, Date endDate) {

		String query = "select emp from Employee emp where (upper(first_name) = :name or Upper(Last_NAME)=:name)"
				+ " AND startdate between :startDate AND :endDate";

		System.out.println(query);
		Query q = entityManager.createQuery(query);
		q.setParameter("name", name.toUpperCase());
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		return q.getResultList();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return entityManager.createQuery("select emp from Employee emp").getResultList();
	}

	public String printStackTrace(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
}
