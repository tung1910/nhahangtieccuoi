<%-- 
    Document   : header
    Created on : 28 thg 8, 2021, 20:35:19
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="<c:url value="/css/w3.css" />" rel="stylesheet"/> 
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
    .w3-bar-block .w3-bar-item {padding:20px}
</style>
<div>
    <div class="w3-top w3-auto">
        <div class="w3-bar w3-white w3-wide w3-padding-3 w3-card" style="max-width:2500px;margin:auto">
            <div class="w3-right w3-hide-small">
                <a href="<c:url value="/giohang" />" class="w3-button w3-auto" >
                    <i class="fas fa-cart-arrow-down"></i>
                    <div class="w3-badge w3-right w3-small w3-red" id="cartCounter">${cartCounter}</div>
                </a>
            </div>
            <div class="w3-right w3-padding">
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <div class="w3-bar-item">
                        <a class="fa fa-user" href="<c:url value="/dangnhap"/> ">Đăng nhập</a>
                    </div>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <div class="w3-bar-item">
                        <a href="<c:url value="/"/> ">
                            <c:if test="${nguoiDungHienTai.hinhDD != null}">
                                <img style="width:10px;" src="${nguoiDungHienTai.hinhDD}" class="rounded-circle"/>
                            </c:if>
                            <c:if test="${nguoiDungHienTai.hinhDD == null}">
                                <i class="fa fa-user" aria-hidden="true"></i>
                            </c:if>
                            ${pageContext.request.userPrincipal.name}
                        </a>
                    </div>
                    <div class="w3-bar-item">
                        <a class="w3-right text-danger" href="<c:url value="/logout"/> "> Đăng xuất</a>
                    </div>
                </c:if>
            </div>
            <div class="w3-left w3-padding">
                <a href="<c:url value="/"/>" class="w3-bar-item w3-button"><i class="fa fa-home w3-margin-right"></i><b>NMT</b> Restaurant</a>
            </div>
            <div class="w3-left w3-padding">
                <p><button onclick="document.getElementById('menu').style.display = 'block'" class="w3-button">Thực đơn</button></p>
            </div>
            <div class="w3-left w3-padding">
                <a href="javascript:void(0)" class="w3-right w3-button w3-white" onclick="w3_open()">Sảnh cưới</a>
            </div>
            <nav class="w3-sidebar w3-bar-block w3-white w3-animate-right w3-top w3-text-light-grey w3-large" style="z-index:3;width:250px;font-weight:bold;display:none;right:0;" id="mySidebar">
                <a href="javascript:void()" onclick="w3_close()" class="w3-bar-item w3-button w3-center w3-padding-32">CLOSE</a> 
                <c:forEach var="ls" items="${loaisanhs}">
                    <c:url value="/" var="lhP">
                        <c:param name="MaLS" value="${ls.maLS}"></c:param>
                    </c:url>
                    <a class="w3-bar-item text-body" href="${lhP}">${ls.tenLS}</a> 
                </c:forEach>
            </nav>
        </div>
        <div id="menu" class="w3-modal">
            <div class="w3-modal-content w3-animate-zoom">
                <div class="w3-container w3-black w3-display-container">
                    <span onclick="document.getElementById('menu').style.display = 'none'" class="w3-button w3-display-topright w3-large">x</span>
                    <h1>Món khai vị</h1>
                </div>
                <div class="w3-container w3-center">>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/e.jpg" />" alt="Cá hồi tẩm bột chiên giòn dùng với gỏi xoài Thái"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/d.jpg" />" alt="Tôm cuộn khoai môn chiên giòn sốt tartar"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/c.jpg" />" alt="Salad củ hũ dừa và tôm càng sốt cay"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/b.jpg" />" alt="Cánh gà nướng sốt BBQ dùng vời salad - Ba rọi cuộn nấm sốt phô mai"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/a.jpg" />" alt="Củ sen bách hoa sốt chua ngọt"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/1-101.jpg" />" alt="Mực xuyên tiêu sốt tamarind"/>
                </div>
                <div class="w3-container w3-black">
                    <h1>Món chính</h1>
                </div>
                <div class="w3-container w3-center">
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/q.jpg" />" alt="Tôm sú sốt lá hương nhu và thịt heo bằm"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/3.jpg" />" alt="Bò xào sốt tương tỏi ớt dùng với bánh mỳ"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/e_1.jpg" />" alt="Bồ câu quay mắm nhĩ dùng với bánh bao chiên"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/t.jpg" />" alt="Ba rọi heo quay củ hồi - Tiến vua chua ngọt"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/o.jpg" />" alt="Cơm Nhật cà ri và tôm sốt teppan"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/z.jpg" />" alt="Lẩu bò Mỹ cuộn nấm dùng với mì somen"/>
                </div>
                <div class="w3-container w3-black">
                    <h1>Món tráng miệng</h1>
                </div>
                <div class="w3-container w3-center">
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/b_1.jpg" />" alt="Bánh mousse dâu"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/11.jpg" />" alt="Bánh táo tatin"/>
                    <img class="img-fluid" onclick="onClick(this)" width="400" height="300" src="<c:url value="/img/k.jpg" />" alt="Bánh mousse chanh dây"/>
                </div>
            </div>
        </div>
        <div id="modal01" class="w3-modal w3-black" style="padding-top:0" onclick="this.style.display = 'none'">
            <span class="w3-button w3-black w3-xlarge w3-display-topright">×</span>
            <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
                <img id="img01" class="w3-image">
                <p id="caption"></p>
            </div>
        </div>
    </div>
</div>
