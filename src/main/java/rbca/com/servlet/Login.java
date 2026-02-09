package rbca.com.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rbca.com.doa.AuthDao;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        int roleId = AuthDao.validateUser(username,password);

        if(roleId != -1) {
            HttpSession session = req.getSession();
            session.setAttribute("roleId", roleId);
            session.setAttribute("username", username);

            if(roleId == 1)
                res.sendRedirect("admin.jsp");
            else
                res.sendRedirect("dashboard.jsp");

        } else {
            res.sendRedirect("login.jsp?error=1");
        }
    }
}

