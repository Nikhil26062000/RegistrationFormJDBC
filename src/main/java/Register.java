

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public Register() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password  = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		Member member = new Member(uname,password,email,phone);
		
		RegistrationDao rdao = new RegistrationDao();
//		String result = ((RegistrationDao) rdao).insert(member);
		String result = rdao.insert(member);
		
		response.getWriter().print(result);
		
		
	}

}
