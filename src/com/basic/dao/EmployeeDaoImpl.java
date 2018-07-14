package com.basic.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.basic.model.Employee;
@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl  implements EmployeeDao  {

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(employee);
		
	}

	@Override
	public List<Employee> listEmployeess() {
		// TODO Auto-generated method stub
		//getHibernateTemplate().cre
		List<Employee> listofEmps=sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		return listofEmps ;
	}

	@Override
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
		Employee employee=(Employee)sessionFactory.getCurrentSession().get(Employee.class, empid);
		return employee;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete("Employee" ,employee.getEmpId());
		
	}

}