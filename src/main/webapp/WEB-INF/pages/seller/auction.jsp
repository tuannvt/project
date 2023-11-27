<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
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
        <link rel="stylesheet" href="../../resources/css/styleSellerAuction.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    </head>

  <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>
    <body>
       <header>
        <jsp:include page="../include/header.jsp"/>
       </header>
       <main>
       		<div class="container1" style="margin-top:10px">
       		    <div class="col1">
                <img src="../../resources/img/icon/e5cdbc210d1ab01400816e6021440768.jpg">
                <h3><c:out value="${msg}"/></a></h3>
                <img src="../../resources/img/icon/e5cdbc210d1ab01400816e6021440768.jpg">
              </div>
              <div class="col2">
                <div class="item"><h4>${product.product_name}</h4></div>
                <div class="item"><img src="${product.product_img}" alt="" ></div>
              </div>
              <div class="col3">
                 <mvc:form  action="auction1" method ="post" modelAttribute="auction">
                  <input name= "id1" type="hidden" class="form-control" value = "${product.product_id}" />
                   <div class="form-group">
                     <div class="item-col1"><label class="control-label">Start Price</label></div>
                     <div class="item-col2"><mvc:input  id = "startPrice1" path="startPrice" type="text" class="form-control" placeholder="startPrice" /></div>
                   </div>
                   <div class="form-group">
                      <div class="item-col1"><label class="control-label">End Time</label></div>
                      <div class="item-col2"><mvc:input path="endTime" type="datetime-local" class="form-control" placeholder="endTime" /></div>
                   </div>
                   <div class="form-group">
                      <div class="item-row-col1"><label class="control-label">ACTIVE</label></div>
                      <div class="item-row-col2"><mvc:radiobutton path="status" value="ACTIVE"  /></div>
                      <div class="item-row-col3"><label class="control-label">UNACTIVE</label></div>
                      <div class="item-row-col4"><mvc:radiobutton path="status" value="UNACTIVE" /></div>
                  </div>
                   <div class="form-group">
                   <button type"submit" class="btn btn-info">Đấu Giá</button>
                   </div>
                 </mvc:form>
              </div>
          </div>
       </main>

    </body>

</html>
