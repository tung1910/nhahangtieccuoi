<%-- 
    Document   : index
    Created on : 6 thg 9, 2021, 09:38:36
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link href="<c:url value="/css/style.css"/>" rel="stylesheet"/> 
<link href="<c:url value="/css/w3.css"/>" rel="stylesheet"/> 

<br><br><br><br>

<header class="w3-display-container w3-content w3-wide" style="max-width:1600px;min-width:500px" id="home">
    <div id="demo" class="carousel slide" data-ride="carousel">
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
        </ul>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="w3-image" src="<c:url value="/img/layout1.jpg" />" width="1600" height="800"> 
            </div>
            <div class="carousel-item">
                <img class="w3-image" src="<c:url value="/img/layout2.jpg" />" width="1600" height="800">  
            </div>
        </div>
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div> 
    <hr>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div>
            <a href="<c:url value="/admin/sanhcuois"/>" class="btn btn-danger">Quản lý sảnh cưới</a>
            <a href="<c:url value="/admin/thongke-loaisanh"/>" class="btn btn-danger">Thống kê báo cáo</a>
        </div>
    </sec:authorize>
</header>
<hr>
<!-- Page content -->
<form action="" id="sanpham">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" style="height: 107%" type="text" name="kw" placeholder="Nhập từ khóa để tìm kiếm"/>
        </div>
        <div>
            <input type="submit" value="Tìm" class="btn btn-danger"/>
        </div>
    </div>
</form>
<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(counter/3)}" var="i">
            <li class="page-item">
                <a href="<c:url value="/" />?page=${i}" class="w3-bar-item w3-button w3-hover-black" data-slide="prev">«</a>  
                <a class="w3-bar-item w3-button w3-hover-black page-link" href="<c:url value="/" />?page=${i}">${i}</a>           
                <a href="<c:url value="/" />?page=${i}" class="w3-bar-item w3-button w3-hover-black" data-slide="next">»</a>
            </li>
        </c:forEach>
    </ul>
</div>

<div class="row">
    <c:forEach var="s" items="${sanhcuois}">
        <div class="col-md-4 col-xs-12">
            <div class="card content" style="width:100%; height: 100%">
                <a href="<c:url value="/sanhcuois/${s.maSC}"/>" style="height: 250px">
                    <c:choose>
                        <c:when test="${s.hinhSC != null && s.hinhSC.startsWith('https') == true}">                    
                            <img class="img-fluid" width="460" height="345" src="<c:url value="${s.hinhSC}" />" alt="${s.tenSC}" />
                        </c:when>

                        <c:when test="${s.hinhSC == null || s.hinhSC.startsWith('https') == false}">
                            <img class="img-fluid" width="460" height="345" src="<c:url value="/img/sanhthuong.jpg" />" alt="${s.tenSC}" />
                        </c:when>
                    </c:choose>
                </a>
                <div class="card-body">
                    <a class="card-title text-body">${s.tenSC}</a>
                    <br><br>
                    <p class="card-text text-body">${s.donGia} VND</p>
                    <div class="text-center" >
                        <a href="<c:url value="/sanhcuois/${s.maSC}" />" class="btn btn-primary">Đặt Tiệc</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>    
</div>
