package trng.imcs.servlet.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Train1.Employee;
import com.Train1.EmployeeDBOperations;
import com.Train1.IEmployeeArrayOpertions;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeID=Integer.parseInt(request.getParameter("empID"));
		IEmployeeArrayOpertions dbOperation = new EmployeeDBOperations();
	
		try {
        Employee emp = dbOperation.findEmployee(employeeID);
        if(emp!=null) {
		request.setAttribute("empId", +(Integer)(emp.getEmployeeId()));
		request.setAttribute("empNo", (Integer)(emp.getEmpNo()));
		request.setAttribute("empName", (String)(emp.getName()));
		request.setAttribute("empSalary", (Float)(emp.getSalary()));
		request.setAttribute("empDoj", (Date)(emp.getDoj()));
		request.setAttribute("empAge", (Integer)(emp.getAge()));
			RequestDispatcher rd = request.getRequestDispatcher("pages/employeeSearch.jsp");
			rd.forward(request, response);
			}
			 else {
             	request.setAttribute("notanEmployee", "Invalid EmployeeId !!");
				RequestDispatcher rd = request.getRequestDispatcher("pages/employeeSearch.jsp");
				rd.forward(request, response);
			 }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
