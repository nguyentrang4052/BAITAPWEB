package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.ultis.Constant;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2448267996061649374L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		session.removeAttribute("account");

		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
				break;

			}
		}
	
		req.getRequestDispatcher("/views/topbar.jsp").forward(req, resp);
//		resp.sendRedirect("/ltwebst4/views/topbar.jsp");
	}
}
