package rbca.com.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rbca.com.dao.Permission;

@WebServlet("/employees")
public class Employee extends HttpServlet {

 protected void doGet(HttpServletRequest req,HttpServletResponse res)
 throws ServletException, IOException {

  HttpSession session = req.getSession(false);
  int roleId = (int) session.getAttribute("roleId");

  if(!Permission.canView(roleId,"employees","name")) {
      res.getWriter().println("ACCESS DENIED");
      return;
  }

  // fetch employees and send to JSP
 }
}

