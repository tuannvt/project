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
        <jsp:include page="../include/css-page.jsp"/>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
        <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../resources/css/styleSellerHome.css">

    </head>

  <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>

    <body>
       <header>
        <jsp:include page="../include/header.jsp"/>
       </header>
       <main>
       		<div class="container">
       			<div class="col1">
              <img src="../resources/img/icon/e5cdbc210d1ab01400816e6021440768.jpg">
              <h3>Tài sản đang chuẩn bị đấu giá</h3>
              <img src="../resources/img/icon/e5cdbc210d1ab01400816e6021440768.jpg">
       			</div>
       			<div class="col2">
       			   <div class="item-menu">
       			      <div class="item-menu-1">product_id</div>
       			      <div class="item-menu-2">product_img</div>
       			      <div class="item-menu-2">product_name</div>
       			      <div class="item-menu-2">auction</div>
       			      <div class="item-menu-2"><a onclick="location.href='add'" >add</a></div>
       			      <div class="item-menu-2">update</div>
       			      <div class="item-menu-2">delete</div>
       			   </div>
       			   <div class="flex-container">
       			      <c:forEach items="${products}" var="products">
                    <div class="item">
                      <div class="item-1">${products.product_id}</div>
                      <div class="item-2"><img src="${products.product_img}" alt="" ></div>
                      <div class="item-2">${products.product_name}</div>
                      <div class="item-2"><a class="btn btn-outline-danger"
                            onclick="location.href='auction/${products.product_id}'" role="button">auction</a></div>
                      <div class="item-2"><a class="btn btn-outline-danger"
                            onclick="location.href='add'" role="button">add</a></div>
                      <div class="item-2"><a class="btn btn-outline-danger"
                            onclick="location.href='update/${products.product_id}'" role="button">update</a></div>
                      <div class="item-2"><a class="btn btn-outline-danger"
                            onclick="location.href='delete/${products.product_id}'" role="button">delete</a></div>
                    </div>
                  </c:forEach>
       			  </div>
       			</div>
          </div>
       </main>

    </body>

</html>
