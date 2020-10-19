<%--
  Created by IntelliJ IDEA.
  User: zhangke
  Date: 9/10/20
  Time: 11:03 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Pokemon</title>
</head>
<body>
<div align="center">
    <h2>New Pokemon</h2>
    <form:form action="save" method="post" modelAttribute="pokemon">
    <table border="0" cellpadding="5">
        <tr>
            <td>Pokemon Name: </td>
            <td><form:input path="pokename" /></td>
        </tr>
        <tr>
            <td>Pokemon Type: </td>
            <td><form:input path="poketype" /></td>
        </tr>
        <tr>
            <td>Pokemon Speed: </td>
            <td><form:input path="pokespeed" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
    </form:form>
</div>
</body>
</html>
