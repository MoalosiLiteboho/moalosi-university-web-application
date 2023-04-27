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
        <title>student dashboard</title>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
        <link rel="stylesheet" href="styleSheet/Dashboard.css">
        <link rel="stylesheet" href="styleSheet/Table.css">
        <link rel="stylesheet" href="styleSheet/InputFields.css">
        <script defer src="javaScript/DarkAndLightMode.js"></script>
        <script defer src="javaScript/menu/DashboardMenuHandle.js"></script>
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
                        <a href="student-courses">
                            <i class="uil uil-book-open"></i>
                            <span class="link-name">My Courses</span>
                        </a>
                    </li>
                    <li>
                        <a href="student-enrollment-new-course">
                            <i class="uil uil-plus-circle"></i>
                            <span class="link-name">Enroll In A Course</span>
                        </a>
                    </li>
                    <li>
                        <a href="student-course-material">
                            <i class="uil uil-book-reader"></i>
                            <span class="link-name">Course Material</span>
                        </a>
                    </li>
                    <li>
                        <a href="student-submit-assignment">
                            <i class="uil uil-arrow-up"></i>
                            <span class="link-name">Submit Assignment</span>
                        </a>
                    </li>
                    <li>
                        <a href="student-my-grades">
                            <i class="uil uil-edit-alt"></i>
                            <span class="link-name">My Grades</span>
                        </a>
                    </li>
                    <li>
                        <a href="student-announcement">
                            <i class="uil uil-comment-plus"></i>
                            <span class="link-name">Announcement</span>
                        </a>
                    </li>
                    <li>
                        <a href="student-add-student-feedback">
                            <i class="uil uil-comment-alt-plus"></i>
                            <span class="link-name">Add Student Feedback</span>
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
                <div class="profile">
                    <i class="uil uil-user"></i>
                    <h3 class="userUsername"><%= username %></h3>
                </div>
            </div>
            <div class="dashboard-content">
                <div class="add-form-container">
                    <form action="" method="post">
                        <div class="input-container">
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>