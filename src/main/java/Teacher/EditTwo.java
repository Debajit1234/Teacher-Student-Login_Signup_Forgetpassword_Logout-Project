package Teacher;

import Factory.FactoryProvider;
import Student.Marks;
import Student.StudentLogDetail;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edittwo")
public class EditTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("inside edit two");
        int id=Integer.parseInt(req.getParameter("id"));
        System.out.println("inside "+id);
        int c=Integer.parseInt(req.getParameter("c"));
        int java=Integer.parseInt(req.getParameter("java"));


        Session s = FactoryProvider.getFactory().openSession();
        Transaction tx = s.beginTransaction();

        StudentLogDetail sdd=(StudentLogDetail) s.get(StudentLogDetail.class,id);
        sdd.setMark(new Marks(c,java));

        tx.commit();
        s.close();

        resp.sendRedirect("studentMarksTeacher.jsp");
    }
}
