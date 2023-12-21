<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
        <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../../resources/css/styleHeader.css">
        <link rel="stylesheet" href="resources/css/styleAccount.css">

    </head>

  <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>

    <body>
       <header>
        <jsp:include page="include/header.jsp"/>
       </header>
       <main>
       		<div class="container">
       		  <div class="acc">
               <div class="col1"><img src="resources/img/icon/thanh vien.jpg" alt="" ></div>
               <div class="col2">
                  <h5>ID:</h5>
                  <h5>${credit.account.id}</h5>
               </div>
               <div class="col2">
                  <h5>Email:</h5>
                  <h5><div class="col2-1">${credit.account.email}</div></h5>
               </div>
               <div class="col2">
                  <h5>Balance:</h5>
                  <h5><div class="col2-1">${credit.balance}$</div></h5>
               </div>
            </div>
            <div class="credit">
               <div>
               </div>
            </div>
       		</div>
       </main>

    </body>

</html>
