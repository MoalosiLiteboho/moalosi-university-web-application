<%@ page import="com.moalosi.service.CourseService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int assignmentId = Integer.parseInt(request.getParameter("id"));
%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>update deadline</title>
        <link rel="stylesheet" href="styleSheet/form.css">
    </head>
    <body>
        <form action="instructor-update-assignment-deadline" method="post">
            <h3>Update Deadline</h3>
            <input type="hidden" name="assignmentId" value="<%= assignmentId %>">
            <div class="input-container">
                <label for="dateOfBirthId">New Deadline</label>
                <input type="date" name="deadline" id="dateOfBirthId" value="<%= new CourseService().getAssignmentDeadlineById(assignmentId) %>">
            </div>
            <div class="button-container">
                <input type="submit" value="update">
            </div>
        </form>
    </body>
</html>
