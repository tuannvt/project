<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login Page</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">
         <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
         <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>

       <form action="<c:url value="j_spring_security_check"/>" method="post">
           <div class="mb-3">
             <label for="exampleFormControlInput1" class="form-label">Email</label>
             <mvc:input  path="email" type="email" class="form-control" placeholder="email@gmail.com" />
           </div>
           <div class="mb-3 row">
             <label  class="col-sm-2 col-form-label">Password</label>
             <div class="col-sm-10">
               <mvc:input path="password" type="password" class="form-control">
             </div>
           </div>
           <div class="mb-3 row">
             <label  class="col-sm-2 col-form-label">Full Name</label>
             <div class="col-sm-10">
               <mvc:input path="fullName" type="text" class="form-control">
             </div>
           </div>
           <div class="mb-3 row">
             <label  class="col-sm-2 col-form-label">Phone</label>
             <div class="col-sm-10">
               <mvc:input path="phone" type="text" class="form-control">
             </div>
           </div>
           <div class="mb-3 row">
             <label  class="col-sm-2 col-form-label">Phone</label>
             <div class="col-sm-10">
               <mvc:input path="phone" type="text" class="form-control">
             </div>
           </div>
           <div class="mb-3 row">
             <label  class="col-sm-2 col-form-label">Address</label>
             <div class="col-sm-10">
               <mvc:input path="address" type="text" class="form-control">
             </div>
           </div>
           <div class="form-group">
             <div class="item-row-col0"><label class="control-label">Gender: </label></div>
             <div class="item-row-col1"><label class="control-label">Male</label></div>
             <div class="item-row-col2"><mvc:radiobutton path="gender" value="Male"  /></div>
             <div class="item-row-col3"><label class="control-label">Female</label></div>
             <div class="item-row-col4"><mvc:radiobutton path="gender" value="Female" /></div>
           </div>
           <div class="form-group">
             <button type"submit" class="btn btn-info">Đấu Giá</button>
           </div>
        </form>
       
    </body>
</html>
