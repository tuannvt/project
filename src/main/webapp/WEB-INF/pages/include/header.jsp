
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>

<%@taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
      rel="stylesheet">
<link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
<script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
<!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->

<!-- Header Section Begin -->
<header style="position:fixed;width:100%;z-index: 100000;" class="header">
    <div class="header__top" >
        <div class="container" >
            <div class="row" >
                    <div class="logo">
                        <img src="resources/img/about/logo-dau-gia-lac-viet.png" alt="logo" width=200px>
                    </div>
                    <div class="main-menu">
                        <div class="menu-select">
                          <select class="form-select" aria-label="Disabled select example" style="border: none;">
                              <option selected><a href="">Tài sản đấu giá</a></option>
                              <option value="1"><a href="">Nghệ thuật</a></option>
                              <option value="2"><a href="">Xe cộ</a></option>
                              <option value="3"><a href="">Hàng xa xỉ</a></option>
                          </select>
                        </div>
                        <div class="menu-select">
                          <select class="form-select" aria-label="Disabled select example" style="border: none;">
                               <option selected><a href=""> Cuộc đấu giá</a></option>
                               <option value="1"><a href="">Sắp đấu giá</a></option>
                               <option value="2"><a href="">Đang đấu giá</a></option>
                               <option value="3"><a href="">Đã kết thúc</a></option>
                          </select>
                        </div>
                        <div class="menu-select-1">
                          <a>Tin tức</a>
                        </div>
                        <div class="menu-select-1">
                          <a>Giới thiệu</a>
                        </div>
                        <div class="menu-select-1">
                          <a>Liên hệ</a>
                        </div>
                    </div>
                    <div class="login">
                            <div class="header__top__links" >
                                <sec:authorize access="isAuthenticated()">
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                        <a style="color: black;" href="<c:url value="/admin/home" />">Admin Home</a>
                                    </sec:authorize>
                                    <a style="color: black;" href="<c:url value="/logout" />">Logout</a>
                                </sec:authorize>

                                <!-- If No login then will show Login Page -->
                                <sec:authorize access="!isAuthenticated()">
                                    <a style="color: black;" href="<c:url value="/login" />">Login</a>
                                </sec:authorize>
                            </div>
                    </div>
            </div>
        </div>
    </div>


</header>
<!-- Header Section End -->