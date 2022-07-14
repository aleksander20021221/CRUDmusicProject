<%--
  Author: Pavel Ravvich.
  Date: 15.10.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editing</title>
</head>
<body bgcolor="#E6F8DA">

<h1>Редактирование</h1><br />

<h2>Предыдущие данные</h2>

<div>Наименование: <c:out value="${requestScope.music.title}"/> </div>
<div>Исполнитель: <c:out value="${requestScope.music.artist}"/> </div>
<div>Альбом: <c:out value="${requestScope.music.album}"/> </div>
<div>Год: <c:out value="${requestScope.music.year}"/> </div>

<br />
<hr />

<form method="post" action="<c:url value='/update'/>">

    <h2>Новые данные</h2><br />

    <label><input type="text" name="title"></label>Наименование<br>
    <label><input type="text" name="artist"></label>Исполнитель<br>
    <label><input type="text" name="album"></label>Альбом<br>
    <label><input type="text" name="year"></label>Год<br>

    <label>
        <input type="number" hidden name="id" value="${requestScope.music.id}"/>
    </label>

    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
