package Servlets;

import Accounts.UserProfile;
import Services.AccountService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserProfile newProfile = new UserProfile(login, password, email);
        AccountService.addNewUser(newProfile);
        AccountService.addSession(req.getSession().getId(), newProfile);
        File f = new File( String.format("C:\\usersFiles\\%s", login));
        f.mkdir();
        getServletContext().getRequestDispatcher(String.format("/files?path=C:\\usersFiles\\%s",login)).forward(req, resp);
    }

    @Override
    public void destroy() {

    }
}
