<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>update User</title>
        <link rel="stylesheet" href="styleSheet/form.css">
    </head>
    <body>
        <form action="instructor-grade-student-by-id" method="post">
            <h3>Grade Student</h3>
            <input type="hidden" name="id" value="<%= id %>">
            <div class="input-container">
                <label for="nameId">Mark</label>
                <input type="number" name="mark" id="nameId" autocomplete="off" placeholder=" ">
            </div>
            <div class="button-container">
                <input type="submit" value="grade">
            </div>
        </form>
    </body>
</html>