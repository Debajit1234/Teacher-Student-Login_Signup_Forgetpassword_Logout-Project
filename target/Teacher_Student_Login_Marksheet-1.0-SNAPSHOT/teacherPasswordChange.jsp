<%--
  Created by IntelliJ IDEA.
  User: BEBAJIT
  Date: 07-Aug-21
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password Change</title>

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

        header {
            margin-top: 20px;
            padding: 10px 20px;
            margin-inline: 70px;
            /* border: 2px solid black; */
        }
        .tr {
            text-align: center;
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

        .container {
            position: absolute;
            top: 50%;
            left: 50.8%;
            transform: translate(-50%, -50%);
        }

        .container {
            background: #fff;
            width: 410px;
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
            margin-top: -20px;
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
        form .data input:focus {
            border-color: #56d8e4 #9f01ea #56d8e4 #9f01ea;
            border-width: 2px;
            border-style: dotted;
        }
        form .forgot-pass {
            margin-top: -8px;
        }
        form .forgot-pass a {
            padding-left: 20px;
            color: #3498db;
            text-decoration: none;
        }
        form .forgot-pass a:hover {
            text-decoration: underline;
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
        form .signup-link {
            text-align: center;
        }
        form .signup-link a {
            color: #3498db;
            text-decoration: none;
        }
        form .signup-link a:hover {
            text-decoration: underline;
        }
    </style>


</head>
<body>


<header>
    <div class="tr">
        <tr>
            <td class="td"><a href="#">1 st link</a></td>
            <td><a href="#">2 nd link</a></td>
            <td><a href="#">3 rd link </a></td>
        </tr>
    </div>
</header>

<div class="center">
    <div class="container">
        <div class="text">Login Form</div>

        <form action="tcngpass">
            <div class="data">
                <label>Name</label>

                <input type="text" name="teachercpname" value="${name}"  required="required"/>
            </div>
            <div class="data">
                <label>Password</label>

                <input type="password" name="teachercppassword" placeholder="  Enter the password" required="required"/>

            </div>

            <div class="data">
                <label>Password</label>

                <input type="password" name="teachercppasswordcom2" placeholder="  Re Enter the password" required="required"/>

            </div>

            <div class="btn">
                <div class="inner"></div>
                <button type="submit">sign up</button>
            </div>
        </form>
    </div>
</div>


<%--<%--%>
<%--    String name=(String)request.getAttribute("name");--%>
<%--    System.out.println(name);--%>
<%--%>--%>

<%--<form action="tcngpass">--%>
<%--    <fieldset>--%>
<%--        <legend>change password</legend>--%>
<%--            <table>--%>
<%--                <tr><td>Enter The Name</td><td><input type="text" name="teachercpname" value="${name}"  required="required"/></td></tr>--%>
<%--                <tr><td>Enter The PASSWORD</td><td><input type="password" name="teachercppassword" placeholder="  Enter the password" required="required"/></td></tr>--%>
<%--                <tr><td>Re Enter The PASSWORD</td><td><input type="password" name="teachercppasswordcom2" placeholder="  Re Enter the password" required="required"/></td></tr>--%>
<%--            </table>--%>
<%--            <input type="submit" value="submit" id="inpu"/>--%>
<%--            <input type="reset" value="CLEAR" id="input" />--%>
<%--        </legend>--%>
<%--    </fieldset>--%>
<%--</form>--%>

</body>
</html>
