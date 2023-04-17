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

import java.time.LocalDate;
import java.util.List;

public interface Dao {
    void registerUser(User user);
    List<UserDetails> findAllUsers();
    void updateUser(User user);
    void deleteUserById(int userId);
    List<District> findAllDistrict();
    List<Authority> findAllAuthorities();
    void registerCourse(Course course);
    List<Course> findAllCourses();
    void deleteCourseById(int courseId);
    void updateCourse(Course course);
    List<Assignment> findAllAssigment();
    List<Material> findAllMaterial();
    void saveCourseMaterial(Material material);
    void saveCourseAssignment(Assignment assignment);
    List<EnrollmentCourse> findAllEnrolledStudent();
    void enrollStudent(EnrollmentCourse course);
    void unEnrollStudent(int courseId);
    List<AssigmentSubmissions> findAllSubmissions();
    void addAnnouncement(Announcement announcement);
    List<Announcement> findAllAnnouncement();
    void deleteAnnouncement(int announcementId);
    List<StudentGrades> findAllStudentGrades();
    void gradeStudent(StudentGrade studentGrade);
    List<StudentFeedback> findAllStudentsFeedbacks();
    void saveFeedback(Feedback feedback);
    void updateAssigmentDeadline(int assignmentId, LocalDate newDeadline);
    void submitAssigment(AssignmentSubmission assignment);
}
