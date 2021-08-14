package com.example.Teacher_Student_Login_Marksheet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.Teacher_Student_Login_Marksheet.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println(" <h2 style=\"font-weight: 600;\n" +
                "        text-align: center;\n" +
                "        background-color: #ba3c3c;\n" +
                "        color: #fff;\n" +
                "        padding: 10px 0px;\n" +
                "\n" +
                "        box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);\n" +
                "        border-radius: 80px;\n" +
                "        text-transform: uppercase;\n" +
                "        font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;\n" +
                "        margin: 9px 20px;\">wrong input</h2>");
    }
}
