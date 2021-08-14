package Student;

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
@WebServlet("/sfpass")
public class StudentForgetPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try{
            PrintWriter out = resp.getWriter();
            int id=Integer.parseInt(req.getParameter("studentfpid"));

            HttpSession session=req.getSession();
            session.setAttribute("id",id);


            int password1=Integer.parseInt(req.getParameter("studentfpassword"));
            int password2=Integer.parseInt(req.getParameter("studentfpasswordcom2"));
            System.out.println("before entering");

            if(password1!=password2){
                System.out.println("password are not same");
                out.println("<html>");
                out.println("<head><title>Title Name</title></head>");
                out.println("<body>");
                out.println("<h2 style='font-weight: 600;text-align: center;background-color: #ba3c3c;color: #fff;padding: 10px 0px;box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);border-radius: 80px;text-transform: uppercase;font-family:Cambria, Cochin, Georgia, Times, serif;margin: 9px 20px;' >wrong input</h2>");
                out.println("</body></html>");

                RequestDispatcher rd = req.getRequestDispatcher("studentLogin.html");
                rd.include(req, resp);
            }else {

                Session s = FactoryProvider.getFactory().openSession();
                Transaction tx = s.beginTransaction();

                StudentLogDetail t = (StudentLogDetail) s.get(StudentLogDetail.class, id);
                t.setPassword(password1);

                s.update(t);
                tx.commit();
                s.close();
                resp.sendRedirect("studentLogin.html");
            }
        }catch(Exception e){
            e.printStackTrace();

        }
    }

}
