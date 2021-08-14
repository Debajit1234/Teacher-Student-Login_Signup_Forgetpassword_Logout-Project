package Teacher;

import Factory.FactoryProvider;
import Student.Marks;
import Student.StudentLogDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit")
public class EditMarks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            System.out.println("inside edit");
            PrintWriter out = resp.getWriter();

            int id=Integer.parseInt(req.getParameter("id"));
            req.setAttribute("id",id);
            System.out.println(id);

            String name = req.getParameter("name");
            req.setAttribute("name",name);
            System.out.println(name);

            String roll=req.getParameter("rollno");
            req.setAttribute("rollno",roll);

            RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
            rd.forward(req, resp);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
