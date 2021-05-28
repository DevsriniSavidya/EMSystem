package employee.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.dao.EmployeeDAO;
import employee.model.Employee;

/**
 * Servlet implementation class Employeeservlet
 */
@WebServlet("/")
public class Employeeservlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
       private EmployeeDAO employeeDAO;
    
       public Employeeservlet() {
         this.employeeDAO = new EmployeeDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String action = request.getServletPath();
		  
		    switch(action) {
	
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					try {
						insertEmployee(request, response);
					}catch (SQLException e) {
						e.printStackTrace();
					}	
					break;
					
				case "/delete":
					try {
					   deleteEmployee(request, response);
					}catch(SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case "/edit":
					try {
						showEditForm(request, response);
						}catch(SQLException e) {
							e.printStackTrace();
						}
					break;
					
				case "/update":
					try {
						updateEmployee(request, response);
						}catch(SQLException e) {
							e.printStackTrace();
						}
					break;
					
				default:
					try {
						listEmployee(request, response);
						}catch(SQLException e) {
							e.printStackTrace();
						}
					break;
							
			}
		}

	

			private void showNewForm(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
				dispatcher.forward(request, response);
			}
			
	
			private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException {
				String name = request.getParameter("name");
				String type = request.getParameter("eType");
				String department = request.getParameter("edept");
				String address = request.getParameter("address");
				String gender = request.getParameter("gender");
				Integer age = Integer.parseInt(request.getParameter("age"));
				Employee newEmployee = new Employee(name,type,department, address, gender,age);
				
				employeeDAO.insertEmployee(newEmployee);
				response.sendRedirect("list");
			}
			
			private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				employeeDAO.deleteEmployee(id);
				response.sendRedirect("list");

			}
			
			private void showEditForm(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				Employee existingEmployee = employeeDAO.selectEmployee(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
				request.setAttribute("employee", existingEmployee);
				dispatcher.forward(request, response);

			}
			
			private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String type = request.getParameter("eType");
				String department = request.getParameter("edept");
				String address = request.getParameter("address");
				String gender = request.getParameter("gender");
				Integer age = Integer.parseInt(request.getParameter("age"));
				Employee employee = new Employee(id,name,type,department, address, gender,age);
				employeeDAO.updateEmployee(employee);
				response.sendRedirect("list");
			}
			
			private void listEmployee(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				List<Employee> listEmployee = employeeDAO.selectAllEmployees();
				request.setAttribute("listEmployee", listEmployee);
				RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
				dispatcher.forward(request, response);
			}

}
