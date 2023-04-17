<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int assignmentId = Integer.parseInt(request.getParameter("aid"));
    int studentId = Integer.parseInt(request.getParameter("sid"));
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
        <form action="student-new-submit-assignment" method="post" enctype="multipart/form-data">
            <h3>Submit Assignment</h3>
            <input type="hidden" name="studentId" value="<%= studentId %>">
            <input type="hidden" name="assignmentId" value="<%= assignmentId %>">
            <div class="file-upload">
                <label for="dateOfBirthId">New Deadline</label>
                <input type="file" name="file" id="dateOfBirthId">
            </div>
            <div class="button-container">
                <input type="submit" value="submit">
            </div>
        </form>
    </body>
</html>
