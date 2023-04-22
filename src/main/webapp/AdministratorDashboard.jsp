<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String username = session.getAttribute("username").toString();
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>administrator dashboard</title>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
        <link rel="stylesheet" href="styleSheet/Dashboard.css">
        <link rel="stylesheet" href="styleSheet/InputFields.css">
        <link rel="stylesheet" href="styleSheet/Table.css">
        <script defer src="javaScript/DarkAndLightMode.js"></script>
        <script defer src="javaScript/menu/DashboardMenuHandle.js"></script>
        <script defer src="javaScript/menu/DashboardButtonFunction.js"></script>
        <script defer src="javaScript/SideBarMenu.js"></script>
        <script defer src="javaScript/PopUp.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.3.1/jspdf.umd.min.js"></script>
    </head>
    <body>
        <nav>
            <div class="logo-name">
                <div class="logo-image">
                    <img src="images/logo.png" alt="">
                </div>
                <span class="logo_name">L.M University</span>
            </div>
            <div class="menu-items">
                <ul class="nav-links">
                    <li>
                        <a href="administrator-course">
                            <i class="uil uil-book-open"></i>
                            <span class="link-name">Courses</span>
                        </a>
                    </li>
                    <li>
                        <a href="administrator-user-table">
                            <i class="uil uil-users-alt"></i>
                            <span class="link-name">Users</span>
                        </a>
                    </li>
                    <li>
                        <a href="administrator-add-users">
                            <i class="uil uil-user-plus"></i>
                            <span class="link-name">Add Users</span>
                        </a>
                    </li>
                    <li>
                        <a href="administrator-enrollment-report">
                            <i class="uil uil-file-medical-alt"></i>
                            <span class="link-name">Course Enrolment Report</span>
                        </a>
                    </li>
                    <li>
                        <a href="administrator-assignment-submissions">
                            <i class="uil uil-import"></i>
                            <span class="link-name">Assignment Submission</span>
                        </a>
                    </li>
                    <li>
                        <a href="administrator-student-grades">
                            <i class="uil uil-edit-alt"></i>
                            <span class="link-name">Grades</span>
                        </a>
                    </li>
                </ul>
                <ul class="logout-mode">
                    <li>
                        <a href="log-out">
                            <i class="uil uil-sign-out-alt"></i>
                            <span class="link-name">LogOut</span>
                        </a>
                    </li>
                    <li class="mode">
                        <a>
                            <i class="uil uil-moon"></i>
                            <span class="link-name">Dark Mood</span>
                        </a>
                        <div class="mode-toggle">
                            <span class="switch"></span>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <section class="dashboard">
            <div class="top">
                <i class="uil uil-bars sidebar-toggle"></i>
                <div class="search-box">
                    <i class="uil uil-search"></i>
                    <label for="searchInputId"></label><input type="text" name="search" id="searchInputId" placeholder="Search...">
                </div>
                <div class="profile">
                    <i class="uil uil-user"></i>
                    <h3 class="userUsername"><%= username %></h3>
                </div>
            </div>
            <div class="dashboard-content">
                <div class="panel-popup">
                    <h4>Update Course</h4>
                    <div class="add-form-container">
                        <form action="administrator-add-new-course" method="post">
                            <div class="input-container">
                                <input type="text" name="name" id="nameId">
                                <label for="nameId">Name</label>
                            </div>
                            <div class="input-container">
                                <input type="text" name="description" id="descriptionId" autocomplete="off">
                                <label for="descriptionId">Description</label>
                            </div>
                            <div class="input-container">
                                <input type="text" name="type" id="typeId" autocomplete="off" placeholder=" ">
                                <label for="typeId">Type</label>
                            </div>
                            <div class="button-container">
                                <input type="submit" value="register">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>