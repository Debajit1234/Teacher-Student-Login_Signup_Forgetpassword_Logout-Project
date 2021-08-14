package Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tsignup")
public class teachersignupget extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            PrintWriter out = resp.getWriter();

            String name = req.getParameter("teachersname");
            req.setAttribute("name", name);
            int password = Integer.parseInt(req.getParameter("teacherspassword"));
            req.setAttribute("password", password);

            if (password != 1234) {
                out.println("<html>");
                out.println("<head><title>Title Name</title></head>");
                out.println("<body>");
                out.println("<h2 style='font-weight: 600;text-align: center;background-color: #ba3c3c;color: #fff;padding: 10px 0px;box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);border-radius: 80px;text-transform: uppercase;font-family:Cambria, Cochin, Georgia, Times, serif;margin: 9px 20px;' >wrong input</h2>");
                out.println("</body></html>");
                RequestDispatcher rd = req.getRequestDispatcher("teacherSignUp.html");
                rd.include(req, resp);

            } else {
                RequestDispatcher rd = req.getRequestDispatcher("teacherPasswordChange.jsp");
                rd.forward(req, resp);


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
