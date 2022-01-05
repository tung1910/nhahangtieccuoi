<%-- 
    Document   : giohang
    Created on : 2 thg 10, 2021, 11:00:31
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br><br><br>

<h1 class="text-center text-danger">Giỏ Hàng</h1>

<c:if test="${giohangs == null}">
    <h4 class="text-danger text-center">Không có sản phẩm nào trong giỏ</h4>
</c:if>

<c:if test="${giohangs != null}">
    <table class="table">
        <tr>
            <th>Mã sảnh cưới</th>
            <th>Tên sảnh cưới</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th></th>
        </tr>
        <c:forEach items="${giohangs}" var="r">
            <tr id="sanhcuoi${r.maSC}">
                <td>${r.maSC}</td>
                <td>${r.tenSC}</td>
                <td>${r.donGia} VND</td>
                <td>${r.soLuong}</td>
                <td>
                    <input type="button" value="Xóa" onclick="deleteGioHang(${r.maSC})" class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div>
        <h5>Tổng tiền thanh toán: <span id="tienGioHang">${thongKeGioHang.tongTien}</span> VND</h5>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a>Vui lòng đăng nhập</a>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <input type="button" onclick="thanhToan()" value="Thanh toán" class="btn btn-danger"/>
    </c:if>
    <br><br>
</c:if>