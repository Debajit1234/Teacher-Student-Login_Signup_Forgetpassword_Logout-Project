package Student;

import Factory.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/slogin")
public class StudentLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            resp.setHeader("Cache-Control","no-cache");
            resp.setHeader("Cache-Control","no-store");
            resp.setHeader("Cache-Control","must-revalidate");
            resp.setHeader("Pragma","no-cache");
            resp.setDateHeader ("Expires", 0);

            PrintWriter out=resp.getWriter();

            int id = Integer.parseInt(req.getParameter("studentlid"));
            req.setAttribute("id", id);

            HttpSession session=req.getSession();
            session.setAttribute("id",id);

//            resp.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
            System.out.println(session.getAttribute("id"));
            if(session.getAttribute("id")==null){
//                resp.sendRedirect("teacherLogin.html");
                resp.sendRedirect("studentLogin.html");
            }



            System.out.println(id);
            int password = Integer.parseInt(req.getParameter("studentlpassword"));
            req.setAttribute("password", password);
            System.out.println(password);


            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();


            String HQL = "FROM StudentLogDetail WHERE id=:Id AND password=:password";
            Query<StudentLogDetail> query = s.createQuery(HQL, StudentLogDetail.class);
            query.setParameter("password", password);
            query.setParameter("Id", id);

            StudentLogDetail student = query.uniqueResult();
            System.out.println(student);

//            System.out.println(teacher.getId() + " : " + teacher.getPassword() + " : " + teacher.getName());

            if(student==null){
                System.out.println("password is wrong");

                out.println("<html>");
                out.println("<head><title>Title Name</title></head>");
                out.println("<body>");
                out.println("<h2 style='font-weight: 600;text-align: center;background-color: #ba3c3c;color: #fff;padding: 10px 0px;box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);border-radius: 80px;text-transform: uppercase;font-family:Cambria, Cochin, Georgia, Times, serif;margin: 9px 20px;' >wrong input</h2>");
                out.println("</body></html>");

                RequestDispatcher rd = req.getRequestDispatcher("studentLogin.html");
                rd.include(req,resp);
            }else {
                System.out.println("password is correct");
                RequestDispatcher rd = req.getRequestDispatcher("studentMark.jsp");
                rd.forward(req,resp);
            }

            tx.commit();
            s.close();
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
