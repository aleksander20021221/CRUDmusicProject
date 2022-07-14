<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Media library</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
        </style>
</head>


<body bgcolor="#E1E3F9">

<h1>Моя медиатека</h1><br />
<h2>Новая запись</h2><br />

<form method="post" action="<c:url value='/add_user'/>">

    <label><input type="text" name="title"></label>Наименование<br>
    <label><input type="text" name="artist"></label>Исполнитель<br>
    <label><input type="text" name="album"></label>Альбом<br>
    <label><input type="text" name="year"></label>Год<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

<h2>Вся музыка</h2>

<table>
    <tr>
        <th>Наименование</th>
        <th>Исполнитель</th>
        <th>Альбом</th>
        <th>Год</th>
        <th></th>
    </tr>

<c:forEach var="music" items="${requestScope.musicData}">
    <tr>

    <td><c:out value="${music.title}"/></td>
    <td><c:out value="${music.artist}"/></td>
    <td><c:out value="${music.album}"/></td>
    <td><c:out value="${music.year}"/></td>

    <td>
        <form method="get" action="<c:url value='/update'/>">
        <label>
            <input type="number" hidden name="id" value="${music.id}" />
        </label>
        <input type="submit" value="Изменить"/>
    </form>
        <form method="post" action="<c:url value='/delete'/>">
            <label>
                <input type="number" hidden name="id" value="${music.id}" />
            </label>
            <input type="submit" name="delete" value="Удалить"/>
        </form>
    </td>

    </tr>
</c:forEach>
</table>

</body>

</html>
