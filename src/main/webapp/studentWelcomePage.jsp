<%--
  Created by IntelliJ IDEA.
  User: BEBAJIT
  Date: 08-Aug-21
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome page</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            outline: none;
            box-sizing: border-box;
            font-family: "Trebuchet MS", "Lucida Sans Unicode",
            "Lucida Grande", "Lucida Sans", Arial, sans-serif;
        }
        body {
            height: 100vh;
            width: 100%;
            background: linear-gradient(115deg, #56d8e4 10%, #09698f 90%);
        }



        .container {
            position: absolute;
            top: 50%;
            left: 50.8%;
            transform: translate(-50%, -50%);
        }

        .container {
            background: #fff;
            width: 500px;
            padding: 30px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
            border-radius: 20px;
        }

        .container .text {
            font-size: 35px;
            font-weight: 600;
            text-align: center;
        }



        .container form {
            margin-top: -40px;
        }





        .container form .data {
            height: 45px;
            width: 100%;
            margin: 40px 0;
        }
        form .data label {
            padding-left: 20px;
            font-size: 18px;
        }
        form .data input {
            border-radius: 20px;
            height: 100%;
            width: 100%;
            padding-left: 10px;
            font-size: 17px;
            border: 1px solid silver;
            border-width: 2px;
            border-color: rgba(0, 0, 0, 0.38);
        }
        form .btn {
            border-radius: 20px;
            margin: 30px 0;
            height: 45px;
            width: 100%;
            position: relative;
            overflow: hidden;
        }
        form .btn .inner {
            height: 100%;
            width: 300%;
            position: absolute;
            left: -100%;
            z-index: -1;
            background: -webkit-linear-gradient(
                    right,
                    #56d8e4,
                    #0166ea,
                    #56d8e4,
                    #9f01ea
            );
            transition: all 0.4s;
        }
        form .btn:hover .inner {
            left: 0;
        }
        form .btn button {
            height: 100%;
            width: 100%;
            background: none;
            border: none;
            color: #fff;
            font-size: 18px;
            font-weight: 500;
            text-transform: uppercase;
            letter-spacing: 1px;
            cursor: pointer;
        }
        h2{
            font-weight: 600;
            text-align: center;
            background-color: slateblue;
            color: #fff;
            padding: 10px 0px;

            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
            border-radius: 80px;
            text-transform: uppercase;
            font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
            margin: 9px 20px;
        }

    </style>

</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("id")==null){
//        response.sendRedirect("teacherLogin.html");
        response.sendRedirect("studentLogin.html");
    }
%>


<h2> welcome ${name}.. </></h2>



<div class="container">
    <div class="text">Sorry to say but result is not publish yet... pls login after sometimes....</div>

    <form action="slogout">
        <div class="data"></div>

        <div class="btn">
            <div class="inner"></div>
            <button type="submit">logout</button>
        </div>
    </form>
</div>

<%--<h1><code>welcome ${name}... Sorry to say but result is not publish yet... pls login after sometimes....</code></h1>--%>

</body>
</html>
