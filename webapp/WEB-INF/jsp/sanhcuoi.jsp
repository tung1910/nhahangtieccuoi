<%--
    Document   : product
    Created on : 30 thg 8, 2021, 16:34:45
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<hr><hr><hr>

<h1 class="text-center text-danger">QUẢN LÝ SẢNH CƯỚI</h1>

<c:url value="/admin/sanhcuois" var="action" />

<form:form method="post" action="${action}" modelAttribute="sanhcuoi" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    
    <div class="form-group">
        <label for="tenSC">Tên sảnh cưới</label>
        <form:input type="text" id="tenSC" path="tenSC" cssClass="form-control" />
        <form:errors path="tenSC" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="moTa">Mô tả</label>
        <form:textarea id="moTa" path="moTa" cssClass="form-control" ></form:textarea>
    </div>
    <div class="form-group">
        <label for="dienTich">Diện tích</label>
        <form:textarea id="dienTich" path="dienTich" cssClass="form-control" ></form:textarea>
    </div>
    <div class="form-group">
        <label for="soBan">Số bàn tiệc</label>
        <form:textarea id="soBan" path="soBan" cssClass="form-control" ></form:textarea>
    </div>
    <div class="form-group">
        <label for="hoTro">Hỗ trợ</label>
        <form:textarea id="hoTro" path="hoTro" cssClass="form-control" ></form:textarea>
    </div>
    <div class="form-group">
        <label for="ngayToChuc">Ngày Tổ Chức</label>
        <form:input type="text" id="ngayToChuc" path="ngayToChuc" cssClass="form-control" />
        <form:errors path="ngayToChuc" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="donGia">Giá</label>
        <form:input type="text" id="donGia" path="donGia" cssClass="form-control" />
        <form:errors path="donGia" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="ca">Ca</label>
        <form:select id="ca" path="ca" cssClass="form-control">
            <c:forEach var="a" items="${cas}" >
                <option value="${a.maC}">${a.tenC}</option>
            </c:forEach>
        </form:select>
        <form:errors path="ca" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="loaisanh">Loại Sảnh</label>
        <form:select id="loaisanh" path="loaisanh" cssClass="form-control">
            <c:forEach var="lss" items="${loaisanhs}" >
                <option value="${lss.maLS}">${lss.tenLS}</option>
            </c:forEach>
        </form:select>
        <form:errors path="loaisanh" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="file">Ảnh sảnh cưới</label>
        <form:input type="file" id="file" path="file" cssClass="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm sảnh cưới" class="btn btn-danger" />
    </div>
</form:form>