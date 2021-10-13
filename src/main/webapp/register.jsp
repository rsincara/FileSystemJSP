<%--
  Created by IntelliJ IDEA.
  User: Bitard
  Date: 03.10.2021
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>


<div class="login">
    <form method="post" action="/my-app/register">
        <div class="form-group">
            <label for="exampleInputEmail">Почта</label>
            <input type="email" class="form-control" id="exampleInputEmail" name="email" placeholder="Введите почту">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Логин</label>
            <input type="text" minlength="4" class="form-control" id="exampleInputEmail1" name="login" placeholder="Введите логин">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" minlength="3" class="form-control" id="exampleInputPassword1" name="password" placeholder="Введите пароль">
        </div>
        <button type="submit" class="btn btn-primary">Создать аккаунт</button>
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
