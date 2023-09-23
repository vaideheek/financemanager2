<%--
  Created by IntelliJ IDEA.
  User: vaideheekore
  Date: 2023. 09. 21.
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
    <title>Title</title>
    <%@include file="../../component/all_css.jsp"%>
    <style type="text/css">
        .card-sh {
            box-shadow: 0 0 6px 0 rgba(0,0,0,0.3);
        }
    </style>

</head>
<body class="bg-light">
<%@include file="../../component/navbar.jsp"%>
<div class="container p-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card card-sh">
                <div class="card-header">
                    <p class="text-centre fs-3">Register new user</p>
                     <c:if test = "$(not empty msg)">
                         <p class="text-centre text-danger fs-3 ">$(msg)></p>
                         <c:remove var="msg"/>
                     </c:if>
                </div>
                <div class="card-body">
                    <form action="/userRegister" method="post">
                        <div class="mb-3">
                            <label>Enter Full Name</la bel>
                            <input type="text" name="fullname" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label>Email</label>
                            <input type="email" name="email" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label>Username</label>
                            <input type="text" name="username" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control">
                        </div>

                        <button class="btn btn-danger col-md-12">Register</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
