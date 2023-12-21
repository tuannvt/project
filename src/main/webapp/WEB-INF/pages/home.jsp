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
        <jsp:include page="include/css-page.jsp"/>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
        <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="resources/css/styleHome.css">

    </head>

  <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>

    <body>
       <header>
        <jsp:include page="include/header.jsp"/>
       </header>
       <main>
       		<div class="container">
       			<div class="col1">
       			  <div class="line-left"><img src="resources/img/icon/line-left.png"></div>
              <h2>Tài sản đang đấu giá</h2>
              <div class="line-right"><img src="resources/img/icon/line-right.png"></div>
       			</div>
       			<div class="col2">
       			    <div class="auction-time">
                  <div id="countdown"></div>
                  <div class="time">
                    <h5>
                      <span id="d"></span>
                      <span id="h"></span>
                      <span id="p"></span>
                      <span id="s"></span>
                    </h5>
                  </div>
                  <input type="hidden" id="targetDate" name="targetDate" value="${targetDate}">
                </div>
       			    <div class="auction-product">
                  <c:forEach items="${productEntityList}" var="products">
                    <div class="item">
                       <img src="${products.product_img}" alt="">
                       <h5>${products.product_name}</h5>
                       <a class="btn btn-outline-danger" onclick="location.href='user/auction/${products.product_id}'" role="button" >Đấu Giá</a>
                    </div>
                  </c:forEach>
       			    </div>
       			</div>
          </div>
       </main>

    </body>

</html>
