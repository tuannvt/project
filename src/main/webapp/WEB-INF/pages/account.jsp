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
        <link rel="stylesheet" href="resources/css/styleHeader.css">
        <link rel="stylesheet" href="resources/css/styleAccount.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
                       var message = "${message}";
                       if (message) {
                           alert(message);
                       }
        </script>
    </head>
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
                  <h5>${ac.id}</h5>
               </div>
               <div class="col2">
                  <h5>Email:</h5>
                  <h5><div class="col2-1">${ac.email}</div></h5>
               </div>
               <div class="col2">
                  <h5>Balance:</h5>
                  <h5><div class="col2-1">${credit.balance}$</div></h5>
               </div>
               <div class="col2">
                  <button onclick="location.href='user/auction/${products.product_id}'" >Nạp tiền</button>
               </div>
            </div>
            <div class="credit">
              <div class="credit-1">
                 <div><h3>Thanh Toán</h3></div>
                 <c:forEach items="${bidList}" var="bidList">
                   <div class="credit-item">
                      <div class="col2">
                         <h5><div class="col2-1">Bid ID:</div></h5>
                         <h5><div class="col2-2">${bidList.bid_id}</div></h5>
                      </div>
                      <div class="col2">
                          <h5><div class="col2-1">Time Stamp:</div></h5>
                          <h5><div class="col2-2">${bidList.timeStamp}</div></h5>
                      </div>
                      <div class="col2">
                          <h5><div class="col2-1">Amount:</div></h5>
                          <h5><div class="col2-2">${bidList.amount}</div></h5>
                      </div>
                      <button onclick="location.href='thanhToan/${bidList.bid_id}'" >Thanh Toán</button>
                   </div>
                 </c:forEach>
              </div>
              <div class="credit-2">
                 <div><h3>Đả Thanh Toán</h3></div>
                 <c:forEach items="${bidEntityList}" var="bidEntityList">
                   <div class="credit-item">
                      <div class="col2">
                          <h5><div class="col2-1">Bid ID:</div></h5>
                          <h5><div class="col2-2">${bidEntityList.bid_id}</div></h5>
                      </div>
                      <div class="col2">
                          <h5><div class="col2-1">Time Stamp:</div></h5>
                          <h5><div class="col2-2">${bidEntityList.timeStamp}</div></h5>
                      </div>
                      <div class="col2">
                          <h5><div class="col2-1">Amount:</div></h5>
                          <h5><div class="col2-2">${bidEntityList.amount}</div></h5>
                      </div>
                   </div>
                 </c:forEach>
              </div>
            </div>
       		</div>
       </main>

    </body>

</html>
