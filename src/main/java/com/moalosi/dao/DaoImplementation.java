package com.moalosi.dao;

import com.moalosi.model.Announcement;
import com.moalosi.model.AssigmentSubmissions;
import com.moalosi.model.Assignment;
import com.moalosi.model.AssignmentSubmission;
import com.moalosi.model.Authority;
import com.moalosi.model.Course;
import com.moalosi.model.District;
import com.moalosi.model.EnrollmentCourse;
import com.moalosi.model.Feedback;
import com.moalosi.model.Material;
import com.moalosi.model.StudentFeedback;
import com.moalosi.model.StudentGrade;
import com.moalosi.model.StudentGrades;
import com.moalosi.model.User;
import com.moalosi.model.UserDetails;
import com.moalosi.password.PasswordEncryptor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DaoImplementation implements Dao{
    public void registerUser(User user) {
        Connection connection = getConnection.get();
        String username = user.name() + "." + user.surname();
        String password = new PasswordEncryptor().apply(user.name() + "@12345");

        try {
            PreparedStatement statement = connection.prepareStatement("insert into UniversityManagementSystem.UserTable(Id, Name, Surname, Gender, DateOfBirth, DistrictCode) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, user.id());
            statement.setString(2, user.name());
            statement.setString(3, user.surname());
            statement.setString(4, user.gender());
            statement.setDate(5, Date.valueOf(user.dateOfBirth()));
            statement.setInt(6, user.districtCode());

            statement.executeUpdate();

            statement = connection.prepareStatement("insert into UniversityManagementSystem.UserAccountTable(UserId, AuthorityId, Username, Password, Enabled) values (?, ?, ?, ?, ?)");
            statement.setInt(1, user.id());
            statement.setInt(2, user.authorityId());
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setBoolean(5, true);

            statement.executeUpdate();
        } catch(SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<UserDetails> findAllUsers() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from " +
                    "(select Id, Name, Surname, Gender, DateOfBirth, DistrictCode, AuthorityId, Username, Password, Enabled from UniversityManagementSystem.UserTable inner join UniversityManagementSystem.UserAccountTable on UserTable.Id = UserAccountTable.UserId)" +
                    " as TemporaryTable");
            ResultSet result = statement.executeQuery();

            while (result.next())
                userDetailsList.add(new UserDetails(
                        result.getInt("Id"),
                        result.getString("Name"),
                        result.getString("Surname"),
                        result.getString("Gender"),
                        LocalDate.parse(result.getString("DateOfBirth")),
                        result.getInt("DistrictCode"),
                        result.getInt("AuthorityId"),
                        result.getString("Username"),
                        result.getString("Password"),
                        result.getBoolean("Enabled")
                ));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }

        return userDetailsList;
    }

    public void updateUser(User user) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("update UniversityManagementSystem.UserTable set Name = ?, Surname = ?, Gender = ?, DateOfBirth = ?, DistrictCode = ? where Id = ?");
            statement.setString(1, user.name());
            statement.setString(2, user.surname());
            statement.setString(3, user.gender());
            statement.setDate(4, Date.valueOf(user.dateOfBirth()));
            statement.setInt(5, user.districtCode());
            statement.setInt(1, user.id());

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public void deleteUserById(int userId) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("delete from UniversityManagementSystem.UserAccountTable where UserId = ?");
            statement.setInt(1, userId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.CourseTable where InstructorId = ?");
            statement.setInt(1, userId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.EnrollmentTable where StudentId = ?");
            statement.setInt(1, userId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.StudentGrades where StudentId = ?");
            statement.setInt(1, userId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.SubmissionTable where StudentId = ?");
            statement.setInt(1, userId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.UserTable where Id = ?");
            statement.setInt(1, userId);
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<District> findAllDistrict() {
        List<District> districtList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.DistrictTable");
            ResultSet result = statement.executeQuery();

            while (result.next())
                districtList.add(new District(
                        result.getInt("Code"),
                        result.getString("Name")));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }

        return districtList;
    }

    public List<Authority> findAllAuthorities() {
        List<Authority> authorityList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.AuthorityTable");
            ResultSet result = statement.executeQuery();

            while (result.next())
                authorityList.add(new Authority(
                                result.getInt("Id"),
                                result.getString("Role")));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }

        return authorityList;
    }

    public void registerCourse(Course course) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("insert into UniversityManagementSystem.CourseTable(Id, InstructorId, Name, Description, Type, CreationDate) values ( ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, course.id());
            statement.setInt(2, course.instructorId());
            statement.setString(3, course.name());
            statement.setString(4, course.description());
            statement.setString(5, course.type());
            statement.setDate(6, Date.valueOf(course.createdDate()));

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<Course> findAllCourses() {
        List<Course> courseList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.CourseTable");
            ResultSet result = statement.executeQuery();

            while (result.next())
                courseList.add(new Course(
                        result.getInt("Id"),
                        result.getInt("InstructorId"),
                        result.getString("Name"),
                        result.getString("Description"),
                        result.getString("Type"),
                        LocalDate.parse(result.getString("CreationDate"))
                ));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }

        return courseList;
    }

    public void deleteCourseById(int courseId) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("delete from UniversityManagementSystem.SubmissionTable where CourseId = ?");
            statement.setInt(1, courseId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.StudentGrades where CourseId = ?");
            statement.setInt(1, courseId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.StudentFeedBack where CourseId = ?");
            statement.setInt(1, courseId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.EnrollmentTable where CourseId = ?");
            statement.setInt(1, courseId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.CourseMaterial where CourseId = ?");
            statement.setInt(1, courseId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.AssigmentTable where CourseId = ?");
            statement.setInt(1, courseId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.Announcement where CourseId = ?");
            statement.setInt(1, courseId);
            statement.executeUpdate();

            statement = connection.prepareStatement("delete from UniversityManagementSystem.CourseTable where Id = ?");
            statement.setInt(1, courseId);
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public void updateCourse(Course course) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("update UniversityManagementSystem.CourseTable set InstructorId = ?, Name = ?, Description = ?, Type = ? where Id = ?");
            statement.setInt(1, course.instructorId());
            statement.setString(2, course.name());
            statement.setString(3, course.description());
            statement.setString(4, course.type());
            statement.setInt(5, course.id());

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<Assignment> findAllAssigment() {
        List<Assignment> assignmentList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.AssigmentTable");
            ResultSet result = statement.executeQuery();

            while (result.next())
                assignmentList.add(new Assignment(
                        result.getInt("Id"),
                        result.getInt("CourseId"),
                        result.getString("Name"),
                        LocalDate.parse(result.getString("CreationDate")),
                        LocalDate.parse(result.getString("DeadLine")),
                        result.getString("AssigmentPath")
                ));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }

        return assignmentList;
    }

    public List<Material> findAllMaterial() {
        List<Material> materialList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.CourseMaterial");
            ResultSet result = statement.executeQuery();

            while (result.next())
                materialList.add(new Material(
                        result.getInt("Id"),
                        result.getInt("CourseId"),
                        result.getString("Name"),
                        result.getString("MaterialPath")
                ));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }

        return materialList;
    }

    public void saveCourseMaterial(Material material) {
        Connection connection = getConnection.get();

        try{
            PreparedStatement statement = connection.prepareStatement("insert into UniversityManagementSystem.CourseMaterial(Id ,CourseId, Name, MaterialPath) values (?, ?, ?, ?)");
            statement.setInt(1, material.id());
            statement.setInt(2, material.courseId());
            statement.setString(3, material.name());
            statement.setString(4, material.filePath());

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public void saveCourseAssignment(Assignment assignment) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("insert into UniversityManagementSystem.AssigmentTable(Id, CourseId, Name, CreationDate, DeadLine, AssigmentPath) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, assignment.id());
            statement.setInt(2, assignment.courseId());
            statement.setString(3, assignment.name());
            statement.setDate(4, Date.valueOf(assignment.creationDate()));
            statement.setDate(5, Date.valueOf(assignment.deadLine()));
            statement.setString(6, assignment.assigmentPath());

            statement.executeUpdate();

            statement = connection.prepareStatement("select StudentId from UniversityManagementSystem.EnrollmentTable where CourseId = ?");
            statement.setInt(1, assignment.courseId());

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                statement = getConnection.get().prepareStatement("insert into UniversityManagementSystem.StudentGrades(CourseId, AssignmentId, StudentId, Submitted) values (?, ?, ?, ?)");
                statement.setInt(1, assignment.courseId());
                statement.setInt(2, assignment.id());
                statement.setInt(3, result.getInt("StudentId"));
                statement.setBoolean(4, false);

                statement.executeUpdate();
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<EnrollmentCourse> findAllEnrolledStudent() {
        List<EnrollmentCourse> enrollmentCourseList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.EnrollmentTable");
            ResultSet result = statement.executeQuery();

            while (result.next())
                enrollmentCourseList.add(new EnrollmentCourse(
                        result.getInt("Id"),
                        result.getInt("StudentId"),
                        result.getInt("CourseId"),
                        LocalDate.parse(result.getString("Enrollment"))
                ));

        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }

        return enrollmentCourseList;
    }

    public void enrollStudent(EnrollmentCourse course) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("insert into UniversityManagementSystem.EnrollmentTable(StudentId, CourseId, Enrollment) values ( ?, ?, ?)");
            statement.setInt(1, course.studentId());
            statement.setInt(2, course.courseId());
            statement.setDate(3, Date.valueOf(course.enrollmentDate()));

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public void unEnrollStudent(int courseId) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("delete from UniversityManagementSystem.EnrollmentTable where Id = ?");
            statement.setInt(1, courseId);

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<AssigmentSubmissions> findAllSubmissions() {
        List<AssigmentSubmissions> assigmentSubmissionsList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.SubmissionTable");
            ResultSet result = statement.executeQuery();

            while (result.next())
                assigmentSubmissionsList.add(new AssigmentSubmissions(
                        result.getInt("Id"),
                        result.getInt("StudentId"),
                        result.getInt("CourseId"),
                        result.getInt("AssignmentId"),
                        result.getString("SubmittedPath"),
                        LocalDate.parse(result.getString("SubmissionDate"))
                ));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
        return assigmentSubmissionsList;
    }

    public void addAnnouncement(Announcement announcement) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("insert into UniversityManagementSystem.Announcement(Id, InstructorId, Tittle, CourseId, Announcement, CreatedDate) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, announcement.id());
            statement.setInt(2, announcement.instructorId());
            statement.setString(3, announcement.tittle());
            statement.setInt(4, announcement.courseId());
            statement.setString(5, announcement.announcement());
            statement.setDate(6, Date.valueOf(announcement.createdDate()));

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<Announcement> findAllAnnouncement() {
        List<Announcement> announcementList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.Announcement");
            ResultSet result = statement.executeQuery();

            while (result.next())
                announcementList.add(new Announcement(
                        result.getInt("Id"),
                        result.getInt("InstructorId"),
                        result.getInt("CourseId"),
                        result.getString("Tittle"),
                        result.getString("Announcement"),
                        LocalDate.parse(result.getString("CreatedDate"))
                ));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
        return announcementList;
    }

    public void deleteAnnouncement(int announcementId) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("delete from UniversityManagementSystem.Announcement where Id = ?");
            statement.setInt(1, announcementId);

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<StudentGrades> findAllStudentGrades() {
        List<StudentGrades> studentGradesList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.StudentGrades");
            ResultSet result = statement.executeQuery();

            while (result.next())
                studentGradesList.add(new StudentGrades(
                        result.getInt("Id"),
                        result.getInt("CourseId"),
                        result.getInt("AssignmentId"),
                        result.getInt("StudentId"),
                        result.getBoolean("Submitted"),
                        result.getInt("Marks"),
                        result.getString("Grade")
                ));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
        return studentGradesList;
    }

    public void gradeStudent(StudentGrade studentGrade) {
        Connection connection = getConnection.get();
        try {
            PreparedStatement statement = connection.prepareStatement("update UniversityManagementSystem.StudentGrades set Marks = ?, Grade =? where Id = ?");
            statement.setInt(1, studentGrade.mark());
            statement.setString(2, studentGrade.grade());
            statement.setInt(3, studentGrade.id());

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public List<StudentFeedback> findAllStudentsFeedbacks() {
        List<StudentFeedback> feedbackList = new ArrayList<>();
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from UniversityManagementSystem.StudentFeedBack");
            ResultSet result = statement.executeQuery();

            while (result.next())
                feedbackList.add(new StudentFeedback(
                        result.getInt("Id"),
                        result.getInt("CourseId"),
                        result.getString("Rating"),
                        result.getString("FeedBack")
                ));
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
        return feedbackList;
    }

    public void saveFeedback(Feedback feedback) {
        Connection connection =getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("insert into UniversityManagementSystem.StudentFeedBack(Id, CourseId, Rating, FeedBack) values (?, ?, ?, ?)");
            statement.setInt(1, feedback.id());
            statement.setInt(2, feedback.courseId());
            statement.setString(3, feedback.rating());
            statement.setString(4, feedback.feedback());

            statement.executeUpdate();
        }catch (SQLException exception){
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public void updateAssigmentDeadline(int assignmentId, LocalDate newDeadline) {
        Connection connection = getConnection.get();
        try {
            PreparedStatement statement = connection.prepareStatement("update UniversityManagementSystem.AssigmentTable set DeadLine = ? where Id = ?");
            statement.setDate(1, Date.valueOf(newDeadline));
            statement.setInt(2, assignmentId);

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    public void submitAssigment(AssignmentSubmission assignment) {
        Connection connection = getConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("insert into UniversityManagementSystem.SubmissionTable (Id, StudentId, CourseId, AssignmentId, SubmittedPath, SubmissionDate) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, assignment.id());
            statement.setInt(2, assignment.studentId());
            statement.setInt(3, assignment.courseId());
            statement.setInt(4, assignment.assignmentId());
            statement.setString(5, assignment.path());
            statement.setDate(6, Date.valueOf(assignment.submissionDate()));
            statement.executeUpdate();

            statement = connection.prepareStatement("update UniversityManagementSystem.StudentGrades set Submitted = true where StudentId = ? and AssignmentId = ?");
            statement.setInt(1, assignment.studentId());
            statement.setInt(2, assignment.assignmentId());
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeConnection.accept(connection);
        }
    }

    private final Supplier<Connection> getConnection = () -> {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityManagementSystem", "root", "");
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return connection;
    };

    private final Consumer<Connection> closeConnection = connection -> {
        if(connection != null)
            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
    };
}