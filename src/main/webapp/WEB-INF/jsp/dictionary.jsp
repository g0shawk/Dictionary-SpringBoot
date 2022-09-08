<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Slavko Hojsak
  Date: 05/09/2022
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <title>Dictionary</title>
</h1>
<div align ="left">
    <table border="1" cellpadding="5">
        <caption><h2>List of Foreign Expressions</h2></caption>
        <tr>
            <th>ID</th>
            <th>Foreign Expression</th>
            <th>Translation & Pronunciation</th>
        </tr>
        <c:forEach var="word" items="${words}">
            <tr>
                <td><c:out value="${word.id}" /></td>
                <td><c:out value="${word.expression}" /></td>
                <td><c:out value="${word.translation}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

