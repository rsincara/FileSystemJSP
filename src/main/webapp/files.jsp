<%--
  Created by IntelliJ IDEA.
  User: Bitard
  Date: 19.09.2021
  Time: 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My File System</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<a href="/my-app/logout" class="logout">Выйти</a>
<p class="time">${generatedTime}</p>
<p class="path">${path}</p>
<hr/>
<a class="object" href="/my-app/files?path=${backPath}"><img src="https://img.icons8.com/color/48/000000/folder-invoices--v1.png"/>...</a>
<table>
    <th>Файл</th>    <th>Размер</th>    <th>Дата</th>
    <c:forEach var="directory" items="${directories}">
        <tr> <td> <div class="object-wrapper"> <a class="object" href="/my-app/files?path=${directory.getAbsolutePath()}"><img src="https://img.icons8.com/color/48/000000/folder-invoices--v1.png"/> ${directory.getFileName()}</a> </div></td> <td></td> <td>${directory.getCreationDate()}</td> </tr>
    </c:forEach>

    <c:forEach var="binaryFile" items="${binaryFiles}">
        <tr> <td> <a href="/my-app/download?path=${binaryFile.getAbsolutePath()}" class="object"> <img src="https://img.icons8.com/color/48/000000/file.png"/> ${binaryFile.getFileName()} </a> </td>  <td>${binaryFile.getSize()}B</td>  <td>${binaryFile.getCreationDate()}</td>  </tr>
    </c:forEach>
</table>




<hr/>
</body>
</html>
