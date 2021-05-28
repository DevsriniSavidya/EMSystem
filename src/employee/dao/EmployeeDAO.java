package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import employee.model.Employee;

//DAO class provides CRUD operations for the employees table in the database.

public class EmployeeDAO {
     
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees"+"(name,type,department,address,gender,age) VALUES"+"(?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select id,name,type,department,address,gender,age from employees where id = ?";
    private static final String SELECT_ALL_EMPLOYEES ="select * from employees ";
    private static final String DELETE_EMPLOYEES_SQL = "delete from employees where id =? ;";
    private static final String UPDATE_EMPLOYEES_SQL =" update employees set name = ?,type = ? ,department = ?, address = ? ,gender = ?, age =? where id = ?;";
    
    
    protected Connection getConnection() {
    	Connection connection = null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return connection;
    } 
    
    //Create or insert employee
    public void insertEmployee(Employee employee) throws SQLException {
    	 try(Connection connection = getConnection();
    			 PreparedStatement  preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)){
    		        preparedStatement.setString(1, employee.getName());
    		        preparedStatement.setString(2, employee.getType());
    		        preparedStatement.setString(3, employee.getDepartment());
    		        preparedStatement.setString(4, employee.getAddress());
    		        preparedStatement.setString(5, employee.getGender());
    		        preparedStatement.setInt(6, employee.getAge());
    		        preparedStatement.executeUpdate();
    	 } catch (Exception e) {
    		 e.printStackTrace();
    	 }  
    			 
    }
    
    //Update employee
    public boolean updateEmployee(Employee employee) throws SQLException {
    	boolean rowUpdated;
    	try(Connection connection = getConnection();
    			PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL)){
    		    statement.setString(1, employee.getName());
    		    statement.setString(2, employee.getType());
		        statement.setString(3, employee.getDepartment());
		        statement.setString(4, employee.getAddress());
		        statement.setString(5, employee.getGender());
		        statement.setInt(6, employee.getAge());
    			statement.setInt(7, employee.getId());
    				
    				rowUpdated = statement.executeUpdate() >0;
    			}
    	return rowUpdated;
    }


    
    //Select employee by id
    public Employee selectEmployee(int id) {
    	Employee employee = null;
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatment = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);){
    		preparedStatment.setInt(1, id);
    		System.out.println(preparedStatment);
			ResultSet rs = preparedStatment.executeQuery();

    		while (rs.next()) {
				String name = rs.getString("name");
				String type = rs.getString("type");
				String department = rs.getString("department");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				employee = new Employee(id, name, type, department, address, gender,age);}
    	}catch (SQLException e) {
    		e.printStackTrace();
    	  }
    	return employee;	
    }


    //Select employees
    

	public List<Employee> selectAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				String department = rs.getString("department");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				employees.add(new Employee(id, name, type, department, address, gender,age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	
    //Delete employee
	
	public  boolean deleteEmployee(int id) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;	
		
	}
	

    
}
