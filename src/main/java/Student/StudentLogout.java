package Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/slogout")
public class StudentLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpSession session=req.getSession();
//
//        resp.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
//        if(session.getAttribute("id")==null){
//        resp.sendRedirect("studentLogin.html");
//        }else if (session.getAttribute("id")!=null) {
//            session.removeAttribute("id");
//            System.out.println(session.getAttribute("id"));
////            session.invalidate();
//            resp.sendRedirect("studentLogin.html");
//            return;
//        }


        HttpSession session=req.getSession();

        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Cache-Control","no-store");
        resp.setHeader("Pragma","no-cache");
        resp.setDateHeader ("Expires", 0);
        if(session.getAttribute("id")==null){

        resp.sendRedirect("studentLogin.html");
        }else if (session.getAttribute("id")!=null) {
            System.out.println("not null");

            session.removeAttribute("id");
            System.out.println(session.getAttribute("id"));
//            session.invalidate();
            resp.sendRedirect("slogout");
            return;
        }

    }
}
