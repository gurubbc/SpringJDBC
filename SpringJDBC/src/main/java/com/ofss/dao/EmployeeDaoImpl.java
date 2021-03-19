package com.ofss.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ofss.model.Employee;

@Repository
public class EmployeeDaoImpl  extends JdbcDaoSupport implements EmployeeDao {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public void insertEmployee(Employee emp) {
		String sql = "INSERT INTO employee " +
				"(EMPID, EMPNAME) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getEmpId(), emp.getEmpName()
		});
		System.out.println("Done inserting");

		
	}

	public void insertEmployees(final List<Employee> emp) {
		System.out.println("insert employees method size "+employees.size());
		String sql = "INSERT INTO employee " + "(EMP_ID, EMP_NAME) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				System.out.println("Cursor i is "+i);
				Employee employee = employees.get(i);
				ps.setInt(1, employee.getEmpId());
				ps.setString(2, employee.getEmpName());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});
		System.out.println("Inserted records");
	}

	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setEmpId(Integer.parseInt((String)row.get("EMPID")));
			emp.setEmpName((String)row.get("EMPNAME"));
			result.add(emp);
		}
		
		return result;
	}

	public Employee getEmployeeById(String empId) {
		String sql = "SELECT * FROM employee WHERE EMP_ID = ?";
		return (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<Employee>(){
			public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(Integer.parseInt(rs.getString("EMP_ID")));
				emp.setEmpName(rs.getString("EMP_NAME"));
				return emp;
			}
		});
	}

	
}
