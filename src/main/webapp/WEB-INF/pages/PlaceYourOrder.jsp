<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>Place Your Order</h1>
        <form:form action="placeYourOrder" method="post" modelAttribute="orderPizza">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>PizzaName:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>PizzaType:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Toppings:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>