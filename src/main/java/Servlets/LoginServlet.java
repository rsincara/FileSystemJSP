package Servlets;
import Accounts.UserProfile;
import Services.AccountService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserProfile profile = AccountService.getUserByLogin(login);
        if (profile == null || !profile.getPass().equals(password)) {
            req.setAttribute("error", "Неверный логин или пароль");
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(req,resp);
            return;
        }
        AccountService.addSession(req.getSession().getId(), profile);
        getServletContext().getRequestDispatcher(String.format("/files?path=C:\\usersFiles\\%s",login)).forward(req,resp);
    }


    @Override
    public void destroy() {

    }
}
