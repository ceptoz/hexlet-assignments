<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>User_showing_page</title>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <c:set value='${user}' var='user'/>
        <p> ${user.get("id")}</p>
        <p> ${user.get("firstName")} ${user.get("lastName")}</p>
        <p> ${user.get("email")}</p>
        <a href='/users/delete?id=${user.get("id")}'>Удалить пользователя</p>
        <br>
        <a href="/users">Вернуться ко всем пользователям</a>
    </body>
</html>
<!-- END -->
