<%--
  Created by IntelliJ IDEA.
  User: Bitard
  Date: 03.10.2021
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Gemunu+Libre&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet">
</head>
<body class="body-error">
<div class="error">
    <div class="error__left-side">
        <h1 class="error__title">Oh! Something went wrong </h1>
        <p class="error__text">${error}</p>
    </div>
    <div class="error__right-side">
        <img src="./sources/img/error.gif" alt="error image">
    </div>
</div>

</body>
</html>
