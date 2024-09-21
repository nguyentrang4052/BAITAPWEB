package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceimpl;

@WebServlet(urlPatterns = "/forgot")
public class ForgotController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6326417010195645501L;
	IUserService service = new UserServiceimpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IUserService service = new UserServiceimpl();
		
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		boolean userExist = checkExistUsername(user);
		String alertMsg="";
			
		if (userExist) {
			service.changePassword(user, pass);	
			alertMsg = "Đổi mật khẩu thành công";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		} else {
			alertMsg = "Người dùng không tồn tại!!!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);		
		}
	}

	private boolean checkExistUsername(String username) {
		return service.checkExistUsername(username);
	}
}
