<%@ page import="com.moalosi.model.User" %>
<%@ page import="com.moalosi.model.District" %>
<%@ page import="com.moalosi.service.UserService" %>
<%@ page import="com.moalosi.service.DistrictService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int userId = Integer.parseInt(request.getParameter("id"));
    User user = new UserService().getUserById(userId);
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
        <form action="update-user-servlet" method="post">
            <h3>Update User</h3>
            <input type="hidden" name="userId" value="<%= user.id()%>">
            <input type="hidden" name="authorityId" value="<%= user.authorityId()%>">
            <div class="input-container">
                <label for="nameId">Name</label>
                <input type="text" name="name" id="nameId" autocomplete="off" placeholder=" " value="<%= user.name()%>">
            </div>
            <div class="input-container">
                <label for="surnameId">Surname</label>
                <input type="text" name="surname" id="surnameId" autocomplete="off" placeholder=" " value="<%= user.surname()%>">
            </div>
            <div class="input-container">
                <label for="dateOfBirthId">Date Of Birth</label>
                <input type="date" name="dateOfBirth" id="dateOfBirthId" placeholder=" " value="<%= user.dateOfBirth()%>">
            </div>
            <div class="selection-container">
                <label for="districtsId">District</label>
                <select class="custom-select" name="districtCode" id="districtsId" >
                    <%
                        for (District district : new DistrictService().getDistrictsList()) { %>
                        <option value="<%= district.code() %>"> <%= district.name() %> </option>
                    <% }%>
                </select>
            </div>
            <div class="radio-container">
                <label>Gender</label><br>
                <input type="radio" name="gender" value="Male" id="maleId" checked>
                <label for="maleId">Male</label>
                <input type="radio" name="gender" value="Female" id="femaleId">
                <label for="femaleId">Female</label>
                <input type="radio" name="gender" value="Others" id="othersId">
                <label for="othersId">Others</label>
            </div>
            <div class="button-container">
                <input type="submit" value="update">
            </div>
        </form>
    </body>
</html>