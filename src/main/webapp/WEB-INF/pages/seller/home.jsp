<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
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
              <img src="resources/img/icon/e5cdbc210d1ab01400816e6021440768.jpg">
              <h3>Tài sản đang đấu giá</h3>
              <img src="resources/img/icon/e5cdbc210d1ab01400816e6021440768.jpg">
       			</div>
       			<div class="col2">
       			  <div class="flex-container">
       			    <c:forEach items="${products}" var="products">
                    <div class="item">
                       <table>
                        <tr>
                          <th>product_id</th>
                          <th>product_img</th>
                          <th>product_name</th>
                          <th>description</th>
                          <th>endTime</th>
                          <th>reservePrice</th>
                        </tr>
                        <tr>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                        </tr>
                       </table>
                    </div>
                </c:forEach>
       			  </div>
       			</div>
          </div>
       </main>

    </body>

</html>
