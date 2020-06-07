<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<script>
    function sendCar(userId, item, size, cost) {
        let xhr = new XMLHttpRequest();
        let body = {
            "item": item,
            "size": size,
            "cost": cost
        };
        xhr.open('POST', '/carts?user=' + userId);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onload = function () {
            let response = JSON.parse(xhr.response);
            let carsListHtml = document.getElementById('cart-list');
            let newCarsList = '<thead class="thead-dark">\n' +
                '        <tr>\n' +
                '            <th>ID</th>\n' +
                '            <th>ITEM</th>\n' +
                '            <th>COST</th>\n' +
                '        </tr>\n' +
                '        </thead>';
            for (let i = 0; i < response.length; i++) {
                let cart = response[i];
                newCarsList += '<tr>';
                newCarsList += '<td>' + cart["id"] + '</td>'
                newCarsList += '<td>' + cart["item"] + '</td>';
                newCarsList += '<td>' + cart["cost"] + '</td>';
                newCarsList += '</tr>';
            }
            carsListHtml.innerHTML = newCarsList;
        };
        xhr.send(JSON.stringify(body));
    }
</script>
<div>
    <table id='carts-list' class="table">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>ITEM</th>
            <th>COST</th>
        </tr>
        </thead>
        <%--когда страница только открылась, у нее есть атрибут машины и страница
        заполняется машинами на сервере и отдается пользователю
        HTML + JSP + JSTL --%>
        <c:forEach items="${cart}" var="cart">
            <tr>
                <td>${cart.id}</td>
                <td>${cart.item}</td>
                <td>${cart.cost}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<c:if test="${user.role == 'ADMIN'}">
    <div>
        <input id="item" name="item" placeholder="Item">
        <input id="cost" name="cost" placeholder="Cost">
        <button onclick="sendCar(${userId}, document.getElementById('item').value,
                document.getElementById('cost').value)">Add
        </button>
    </div>
</c:if>
</body>
</html>
