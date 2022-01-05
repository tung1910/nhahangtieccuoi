/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addDanhGia(maSC) {
    fetch("/NhaHangTiecCuoi/api/add-binhluan", {
        method: 'post',
        body: JSON.stringify({
            "binhLuan": document.getElementById("maBL").value,
            "maSC": maSC
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)

        return res.json();
    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("khuvucBL");

        area.innerHTML = `
            <div class="row">
                <div class="col-md-2" style="padding: 10px;">
                    <img class="rounded-circle img-fluid" src="${data.maTK.hinhDD}"/>
                </div>
                <div class="col-md-10 my-date">
                    <p>${data.binhLuan}</p>
                    <i>${moment(data.ngayDang).fromNow()}</i>
                </div>
            </div>
        ` + area.innerHTML
    })
}

function addToGioHang(maSC, tenSC, donGia) {
    event.preventDefault()

    fetch("/NhaHangTiecCuoi/api/giohang", {
        method: 'post',
        body: JSON.stringify({
            "maSC": maSC,
            "tenSC": tenSC,
            "donGia": donGia,
            "soLuong": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data
    })
}

function updateGioHang(obj, maSC) {
    fetch("/NhaHangTiecCuoi/api/giohang", {
        method: 'put',
        body: JSON.stringify({
            "maSC": maSC,
            "tenSC": "",
            "donGia": 0,
            "soLuong": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data.counter
        let tongTien = document.getElementById("tienGioHang")
        tongTien.innerText = data.tongTien
    })
}

function deleteGioHang(maSC) {
    if (confirm("Bạn chắc chắn xóa sản phẩm này không?") == true) {
        fetch(`/NhaHangTiecCuoi/api/giohang/${maSC}`, {
            method: "delete"
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            let counter = document.getElementById("cartCounter")
            counter.innerText = data.counter
            let tongTien = document.getElementById("tienGioHang")
            tongTien.innerText = data.tongTien
//            location.reload()
            let row = document.getElementById(`sanhcuoi{maSC}`)
            row.style.display = "none"
        })
    }
}

function thanhToan(){
    if(confirm("Bạn có đồng ý thanh toán?") == true){
        fetch("/NhaHangTiecCuoi/api/thanhtoan", {
            method: "post"
        }).then(function (res) {
            return res.json()
        }).then(function (code) {
            console.info(code);
            location.reload();
        })
    }
}

function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}

// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}