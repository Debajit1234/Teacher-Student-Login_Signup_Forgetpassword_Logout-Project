package Teacher;

import Factory.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tfpass")
public class TeacherForgetpassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try{
            PrintWriter out = resp.getWriter();
            int id=Integer.parseInt(req.getParameter("teacherfpid"));

            HttpSession session=req.getSession();
            session.setAttribute("id",id);


            int password1=Integer.parseInt(req.getParameter("teacherfpassword"));
            int password2=Integer.parseInt(req.getParameter("teacherfpasswordcom2"));

            if(password1!=password2){
                out.println("<html>");
                out.println("<head><title>Title Name</title></head>");
                out.println("<body>");
                out.println("<h2 style='font-weight: 600;text-align: center;background-color: #ba3c3c;color: #fff;padding: 10px 0px;box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);border-radius: 80px;text-transform: uppercase;font-family:Cambria, Cochin, Georgia, Times, serif;margin: 9px 20px;' >wrong input</h2>");
                out.println("</body></html>");

                RequestDispatcher rd = req.getRequestDispatcher("teacherLogin.html");
                rd.include(req, resp);
            }else {

                Session s = FactoryProvider.getFactory().openSession();
                Transaction tx = s.beginTransaction();

                TeacherLogDetails t = (TeacherLogDetails) s.get(TeacherLogDetails.class, id);
                t.setPassword(password1);

                s.update(t);
                tx.commit();
                s.close();
                resp.sendRedirect("teacherLogin.html");
            }
        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
