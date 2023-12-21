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
        <link rel="stylesheet" href="../../resources/css/styleHeader.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    </head>
    <script>
    function myFunction(){
    document.getElementById("demo").innerHTML = "Bạn chưa đăng nhập.";
    }
    </script>
  <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>
    <body>
       <header>
        <jsp:include page="../include/header.jsp"/>
       </header>
       <main>
       		<div class="container-user" >
              <div class="user-col2">
                <div class="item"><img src="${product.product_img}" alt="" ></div>
              </div>
              <div class="user-col3">
                 <div class="item"><h2>${product.product_name}</h2></div>
                 <div class="item"><h5>${product.description}</h5></div>
                 <mvc:form  action="auction1" method ="post" modelAttribute="auction">
                  <input name= "id1" type="hidden" class="form-control" value = "${product.product_id}" />
                   <div class="user-startPrice">
                     <div class="user-startPrice-col1"><label class="control-label">Giá :</label></div>
                     <input name= "startPrice" type="number" class="form-control" value = "${auction.startPrice}" step="10"/>
                   </div>
                   <div class="user-submit">
                   <button type"submit" class="btn btn-info">Đấu Giá</button>
                   </div>
                 </mvc:form>
              </div>
          </div>
       </main>

    </body>

</html>
