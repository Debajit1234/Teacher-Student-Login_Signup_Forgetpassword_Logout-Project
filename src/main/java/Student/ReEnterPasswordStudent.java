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

@WebServlet("/scngpass")
public class ReEnterPasswordStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");

            String name=req.getParameter("studentcpname");
            req.setAttribute("name",name);

            int password1=Integer.parseInt(req.getParameter("studentcppassword"));
            int password2=Integer.parseInt(req.getParameter("studentcppasswordcom2"));

            if(password1!= password2){
                out.println("<html>");
                out.println("<head><title>Title Name</title></head>");
                out.println("<body>");
                out.println("<h2 style='font-weight: 600;text-align: center;background-color: #ba3c3c;color: #fff;padding: 10px 0px;box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);border-radius: 80px;text-transform: uppercase;font-family:Cambria, Cochin, Georgia, Times, serif;margin: 9px 20px;' >wrong input</h2>");
                out.println("</body></html>");
                System.out.println("password is worng");
                RequestDispatcher rd = req.getRequestDispatcher("studentPasswordChange.jsp");
                rd.include(req, resp);
            }else {
                System.out.println("out side for loop ..");
                req.setAttribute("password", password1); //new password


                StudentLogDetail stud = new StudentLogDetail(name, password1, new Marks(-1, -1));
                int id = stud.getId();
                req.setAttribute("id", id);

                HttpSession session=req.getSession();
                session.setAttribute("id",id);

                Session s = FactoryProvider.getFactory().openSession();
                Transaction tx = s.beginTransaction();

                s.save(stud);

                tx.commit();
                s.close();


                RequestDispatcher rd = req.getRequestDispatcher("studentMark.jsp");
                rd.forward(req,resp);
            }




        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
