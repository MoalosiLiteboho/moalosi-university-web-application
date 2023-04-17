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
        <title>instructor dashboard</title>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
        <link rel="stylesheet" href="styleSheet/Dashboard.css">
        <link rel="stylesheet" href="styleSheet/Table.css">
        <link rel="stylesheet" href="styleSheet/InputFields.css">
        <script defer src="javaScript/DarkAndLightMode.js"></script>
        <script defer src="javaScript/menu/DashboardMenuHandle.js"></script>
        <script defer src="javaScript/menu/DashboardButtonFunction.js"></script>
        <script defer src="javaScript/SideBarMenu.js"></script>
        <script defer src="javaScript/PopUp.js"></script>
        <script defer src="javaScript/UploadFile.js"></script>
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
                        <a href="instructor-add-course">
                            <i class="uil uil-plus"></i>
                            <span class="link-name">Add Course</span>
                        </a>
                    </li>
                    <li>
                        <a href="instructor-courses">
                            <i class="uil uil-book-open"></i>
                            <span class="link-name">Courses</span>
                        </a>
                    </li>
                    <li>
                        <a href="instructor-add-course-material">
                            <i class="uil uil-file-plus"></i>
                            <span class="link-name">Add Course Material</span>
                        </a>
                    </li>
                    <li>
                        <a href="instructor-add-course-assignment">
                            <i class="uil uil-edit-alt"></i>
                            <span class="link-name">Add Course Assigment</span>
                        </a>
                    </li>
                    <li>
                        <a href="instructor-grade-students">
                            <i class="uil uil-book-alt"></i>
                            <span class="link-name">Grade Students</span>
                        </a>
                    </li>
                    <li>
                        <a href="instructor-student-feedback">
                            <i class="uil uil-feedback"></i>
                            <span class="link-name">Students Feedback</span>
                        </a>
                    </li>
                    <li>
                        <a href="instructor-assignment-deadlines">
                            <i class="uil uil-clock"></i>
                            <span class="link-name">Assignment Deadlines</span>
                        </a>
                    </li>
                    <li>
                        <a href="instructor-announcement">
                            <i class="uil uil-comment-plus"></i>
                            <span class="link-name">Announcement</span>
                        </a>
                    </li>
                    <li>
                        <a href="add-announcement">
                            <i class="uil uil-comment-add"></i>
                            <span class="link-name">Add Announcement</span>
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
                    <h3 class="userUsername"> <%= username %> </h3>
                </div>
            </div>
            <div class="dashboard-content">
                <div id="pop-up-panel">
                    <div class="add-form-container">
                        <h4>Assigment Deadline</h4><br>
                        <div class="input-container">
                            <input type="date" name="deadline" id="deadlineId">
                            <label for="deadlineId">DeadLine</label>
                        </div>
                        <div class="button-container">
                            <input type="submit" value="Update">
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>