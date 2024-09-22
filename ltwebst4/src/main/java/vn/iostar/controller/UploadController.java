package vn.iostar.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceimpl;
import vn.iostar.ultis.Constant;

@WebServlet(name = "MultiPartServlet", urlPatterns = { "/multiPartServlet" })

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadController extends HttpServlet{

	private static final long serialVersionUID = 6030309815409909602L;

		private String getFileName(Part part) {
			for (String content : part.getHeader("content-disposition").split(";")) {
				if (content.trim().startsWith("fullname"))
					return content.substring(content.indexOf("=") + 2, content.length() - 1);
			}
			return Constant.DEFAULT_FILENAME;
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String uploadPath = File.separator + Constant.UPLOAD_DIRECTORY; // upload vào thư mục bất kỳ
			// String uploadPath = getServletContext().getRealPath("") + File.separator +
			// UPLOAD_DIRECTORY; //upload vào thư mục project
			String fullname = request.getParameter("fullname");
			String phone = request.getParameter("phone");
			
			File uploadDir = new File(uploadPath);
			
			if (!uploadDir.exists())
				uploadDir.mkdir();
			
			try {
				String fileName = "";
				for (Part part : request.getParts()) {
					fileName = getFileName(part);
					part.write(uploadPath + File.separator + fileName);
				}
				
				HttpSession session = request.getSession(false);				
				UserModel user = (UserModel)session.getAttribute("account");
				
				
				IUserService service = new UserServiceimpl();
				user=service.get(user.getUsername());
				
				
				if (user!=null)
				{
					if (phone != "" && service.checkExistPhone(phone)) {
						request.setAttribute("message", "So dien thoai da ton tai");
					}
					else {
						if (fullname.isEmpty())
							fullname=user.getFullname();
						if (phone.isEmpty())
							phone=user.getPhone();
						service.updateProfile(fullname, phone, fileName, user.getUsername());
						request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
					}
					
				}		
				else 
				{
					request.setAttribute("message", user.getUsername());
				}
			} catch (FileNotFoundException fne) {
				request.setAttribute("message", "There was an error: " + fne.getMessage());
			}
			request.getRequestDispatcher("/views/result.jsp").forward(request, response);
		}
}
