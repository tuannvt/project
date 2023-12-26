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
        <title>Home Page</title>
        <jsp:include page="../include/css-page.jsp"/>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
        <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../../resources/css/styleSellerHome.css">
        <link rel="stylesheet" href="../../resources/css/styleHeader.css">

    </head>

  <script type="text/javascript" src="${pageContext.request.getContextPath()}/resources/js/my_time_js.js"></script>

    <body>
       <header>
        <jsp:include page="../include/header.jsp"/>
       </header>
       <main>
       		<div class="container" style="margin-top:10px">
       		    <div class="col1-1">
                <div class="line-left"><img src="../../resources/img/icon/line-left.png"></div>
                <h3><c:out value="${msg}"/></a></h3>
                <div class="line-right"><img src="../../resources/img/icon/line-right.png"></div>
              </div>
              <div class="col2-2">
                <mvc:form  action="${action}" method ="post" modelAttribute="product">
                                <fieldset class="scheduler-border">
                                  <c:if test="${type.equals('update')}">
                                    <div class="form-group">
                                      <label class="control-label">Product ID</label>
                                      <mvc:input path="product_id" type="text" class="form-control" placeholder="Product ID" disabled="true"/>
                                      <mvc:hidden path="product_id"/>
                                    </div>
                                  </c:if>
                                  <div class="form-group">
                                    <label class="control-label">Product Name(*)</label>
                                    <mvc:input path="product_name" type="text" class="form-control" placeholder="Product Name" required="true"/>
                                  </div>
                                  <div class="form-group">
                                    <label class="control-label">Product Img(*)</label>
                                    <mvc:input path="product_img" type="text" class="form-control" placeholder="Product Img" required="true"/>
                                  </div>
                                  <div class="form-group">
                                    <label class="control-label">Description</label>
                                    <mvc:input path="description" type="text" class="form-control" placeholder="Description" required="true"/>
                                  </div>
                                  <br>
                                    <button type"submit" class="btn btn-info">Save</button>
                                </fieldset>
                </mvc:form>
              </div>
          </div>
       </main>

    </body>

</html>
