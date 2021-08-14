<%@ page import="Factory.FactoryProvider" %>
<%@ page import="Student.StudentLogDetail" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.query.Query" %>
<%--
  Created by IntelliJ IDEA.
  User: BEBAJIT
  Date: 09-Aug-21
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            /* outline: none; */
            box-sizing: border-box;
            font-family: "Trebuchet MS", "Lucida Sans Unicode",
            "Lucida Grande", "Lucida Sans", Arial, sans-serif;
        }
        body {
            height: 100vh;
            width: 100%;
            background: linear-gradient(115deg, #56d8e4 10%, #09698f 90%);
        }

        body {
            padding: 0px;
            margin: 0;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
        }

        table {
            border-radius: 10px;
            background: #fff;
            position: absolute;
            left: 50%;
            top: 380px;
            transform: translate(-50%, -50%);
            border-collapse: collapse;
            width: 90%;
            /* height: 200px; */
            /* border: 1px solid black; */
            box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2),
            -1px -1px 8px rgba(0, 0, 0, 0.2);
        }

        tr {
            transition: all 0.15s ease-in-out;
            cursor: pointer;
        }

        th,
        td {
            padding: 12px;
            text-align: center;

            border-bottom: 1px solid rgb(33, 172, 214);
            border-collapse: collapse;
        }

        #header {
            background-color: #40b6de;
            color: #fff;
            transform: scale(1.02);
            box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2),
            -1px -1px 8px rgba(0, 0, 0, 0.5);
        }

        h1 {
            font-weight: 600;
            text-align: center;
            background-color: #61aac2;
            color: #fff;
            padding: 10px 0px;

            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
            border-radius: 0 20px;
            margin: 9px 20px;
        }

        tr:hover {
            background-color: #f5f5f5;
            transform: scale(1.02);
            box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2),
            -1px -1px 8px rgba(0, 0, 0, 0.2);
        }

        td a {
            background: #fff;
            padding: 2px 6px;
            text-transform: capitalize;
            margin-left: -4px;
            border-radius: 6px;
            text-decoration: none;
            font-size: 16px;
            font-weight: 600;
            box-shadow: 0 0 2px rgba(0, 0, 0, 0.4);
        }

        header {
            margin-top: 7px;
            padding: 10px 20px;
            margin-inline: 70px;
            /* border: 2px solid black; */
        }
        .tr {
            text-align: right;
        }

        header a {
            background: #fff;
            padding: 2px 6px;
            text-transform: capitalize;
            margin-left: 20px;
            border-radius: 6px;
            text-decoration: none;
            font-size: 16px;
            font-weight: 600;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
        }
    </style>

</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Cache-Control","must-revalidate");

    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    System.out.println("inside marks");
//    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    System.out.println(session.getAttribute("id"));
    if(session.getAttribute("id")==null){
        response.sendRedirect("teacherLogin.html");
//        response.sendRedirect("studentLogin.html");
    }
%>

<h1>STUDENT DETAILS</h1>

<header>
    <div class="tr">
        <tr>
            <td class="td"><a href="tlogout">Logout</a></td>
        </tr>
    </div>
</header>

<table>
    <tr id="header">
        <th>ID</th>
        <th>NAME</th>
        <th>ROLL NO</th>
        <th>LANG C</th>
        <th>LANG JAVA</th>
        <td>EDIT-MARKS</td>
    </tr>

    <%



        Session s = FactoryProvider.getFactory().openSession();
        Transaction tx = s.beginTransaction();

        String HQL="FROM StudentLogDetail";
        Query<StudentLogDetail> query = s.createQuery(HQL, StudentLogDetail.class);


        List<StudentLogDetail> list = query.list();

        for(int i=0;i<list.size();i++){

    %>

    <tbody>
    <tr>
        <td><%out.println(list.get(i).getId()); %></td>
        <td><%out.println(list.get(i).getName()); %></td>
        <td><%out.println(list.get(i).getRoll()); %></td>
        <td><%out.println(list.get(i).getMark().getC()); %></td>
        <td><%out.println(list.get(i).getMark().getJava()); %></td>
        <td><a href='edit?id=<%=list.get(i).getId()%>&name=<%=list.get(i).getName()%>&rollno=<%=list.get(i).getRoll()%>'>edit</a></td>

    </tr>
    </tbody>

    <%
        }

        tx.commit();
        s.close();
    %>
</table>


</body>
</html>
