<%-- 
    Document   : chitietsanpham
    Created on : 27 thg 9, 2021, 11:29:27
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="<c:url value="/css/style.css"/>" rel="stylesheet"/> 
<br><br><br><br>

<h1 class="text-center text-danger">Chi Tiết Sảnh Cưới</h1>

<div class="row">
        <div class="col-md-6 content">
            <c:choose>
                <c:when test="${sanhcuoi.hinhSC != null && sanhcuoi.hinhSC.startsWith('https') == true}">
                    <img class="card-img-top img-fluid" src="<c:url value="${sanhcuoi.hinhSC}" />" alt="${sanhcuoi.tenSC}" />
                </c:when>
                <c:when test="${sanhcuoi.hinhSC == null || sanhcuoi.hinhSC.startsWith('https') == false}">
                    <img class="card-img-top img-fluid" src="<c:url value="/img/sanhthuong.jpg" />" alt="${sanhcuoi.tenSC}" />
                </c:when>
            </c:choose>
        </div>
        <div class="col-md-6">
            <h2>${sanhcuoi.tenSC}</h2>
            <h3 class="text-danger">${sanhcuoi.donGia} VND</h3>
            <p>
            <b>${sanhcuoi.moTa}</b>
            </p>
            <p>
            <a>Diện tích: ${sanhcuoi.dienTich}</a>
            </p>
            <p>
            <a>Hỗ trợ: ${sanhcuoi.hoTro}</a>
            </p>
            <p>
            <a>Số bàn tiệc: ${sanhcuoi.soBan}</a>
            </p>
            <p>
            <a>Ngày tổ chức: ${sanhcuoi.ngayToChuc}</a>
            </p>
            <p>
            <a>Buổi: ${sanhcuoi.ca.tenC}</a>
            </p>
            <%--<td><input class="w3-input w3-padding-16 w3-border" type="datetime-local" placeholder="Date and time" required name="date" value="2020-11-16T20:00"></td>--%>
            <hr>
            <br><br><br>
            <div>
                <input type="button" onclick="addToGioHang(${sanhcuoi.maSC}, '${sanhcuoi.tenSC}', ${sanhcuoi.donGia})" value="Thêm vào giỏ" class="btn btn-danger" />
            </div>
        </div>
</div>
<br><br>
<form>
    <div class="form-group">
        <textarea class="form-control" id="maBL" placeholder="Nhập đánh giá của bạn"></textarea>
        <br>
        <input type="submit" onclick="addBinhLuan(${sanhcuoi.maSC})" 
               value="Gửi bình luận" class="btn btn-danger" />
    </div>
</form>        

<div id="khuvucBL">
    <c:forEach var="bl" items="${sanhcuoi.bls}" >
        <div class="row">
            <div class="col-md-2">
                <img class="rounded-circle img-fluid" src="<c:url value="/img/d.jpg" />"/>
            </div>
            <div class="col-md-10 my-date">
                <p class="text-white">${bl.binhLuan}</p>
                <i>${bl.ngayDang}</i>
            </div>
        </div>
    </c:forEach>
</div>
<br><br>

<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
</script>