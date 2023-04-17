<%@ page import="com.moalosi.model.Course" %>
<%@ page import="com.moalosi.service.CourseService" %>
<%@ page import="com.moalosi.service.UserService" %>
<%@ page import="com.moalosi.model.InstructorNamesAndId" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int courseId = Integer.parseInt(request.getParameter("id"));
    Course course = new CourseService().getCourseById(courseId);
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
        <form action="administrator-update-course-by-id" method="post">
            <h3>Update Course</h3>
            <input type="hidden" name="courseId" value="<%= course.id()%>">
            <input type="hidden" name="creationDate" value="<%= course.createdDate()%>">
            <div class="input-container">
                <label for="nameId">Name</label>
                <input type="text" name="name" id="nameId" autocomplete="off" placeholder=" " value="<%= course.name()%>">
            </div>
            <div class="input-container">
                <label for="surnameId">Description</label>
                <input type="text" name="description" id="surnameId" autocomplete="off" placeholder=" " value="<%= course.description()%>">
            </div>
            <div class="input-container">
                <label for="dateOfBirthId">Type</label>
                <input type="text" name="type" id="dateOfBirthId" placeholder=" " value="<%= course.type()%>">
            </div>
            <div class="selection-container">
                <label for="districtsId">Instructor</label>
                <select class="custom-select" name="instructorId" id="districtsId" >
                    <%
                        for (InstructorNamesAndId instructor : new UserService().getInstructorsNamesAndIdList()) { %>
                        <option value="<%= instructor.id() %>"> <%= instructor.name() + " " + instructor.surname()%> </option>
                    <% }%>
                </select>
            </div>
            <div class="button-container">
                <input type="submit" value="update">
            </div>
        </form>
    </body>
</html>