package com.moalosi.service;

import com.moalosi.dao.DaoImplementation;
import com.moalosi.model.AssigmentSubmissions;
import com.moalosi.model.Assignment;
import com.moalosi.model.AssignmentSubmission;
import com.moalosi.model.Course;
import com.moalosi.model.EnrollmentCourse;
import com.moalosi.model.Material;
import com.moalosi.model.StudentGrades;

import java.time.LocalDate;
import java.util.List;

public class CourseService {
    private final DaoImplementation dao;

    public CourseService() {
        dao = new DaoImplementation();
    }

    public boolean checkIfCourseExistById(int courseId) {
        return dao.findAllCourses()
                .stream()
                .anyMatch(course -> course.id() == courseId);
    }

    public void registerCourse(Course course) {
        dao.registerCourse(course);
    }

    public void updateCourse(Course course) {
        dao.updateCourse(course);
    }

    public void deleteCourseById(int courseId) {
        dao.deleteCourseById(courseId);
    }

    public List<Course> getCourseList() {
        return dao.findAllCourses();
    }

    public Course getCourseById(int courseId) {
        return getCourseList()
                .stream()
                .filter(course -> course.id() == courseId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course of " + courseId + " not found."));
    }

    public List<Integer> findAllCoursesIdByInstructorId(int instructorId) {
        return getCourseList()
                .stream()
                .filter(course -> course.instructorId() == instructorId)
                .map(Course::id)
                .toList();
    }

    public String getCourseNameById(int courseId) {
        return getCourseList()
                .stream()
                .filter(course -> courseId == course.id())
                .findFirst()
                .map(Course::name)
                .orElseThrow(() -> new RuntimeException("No course by course id of: " + courseId));
    }

    public List<EnrollmentCourse> getEnrollmentList() {
        return dao.findAllEnrolledStudent();
    }

    public List<Assignment> getAssigmentList() {
        return dao.findAllAssigment();
    }

    public String getAssignmentNameById(int assignmentId) {
        return getAssigmentList()
                .stream()
                .filter(assignment -> assignment.id() == assignmentId)
                .findFirst()
                .map(Assignment::name)
                .orElseThrow(() -> new RuntimeException("Assigment name of " + assignmentId + " id is not found."));
    }

    public List<AssigmentSubmissions> getAssigmentSubmissionsList() {
        return dao.findAllSubmissions();
    }

    public String getAssigmentDurationById(int assignmentId) {
        return getAssigmentList()
                .stream()
                .filter(assignment -> assignment.id() == assignmentId)
                .findFirst()
                .map(assignment -> assignment.creationDate() + " - " + assignment.deadLine())
                .orElseThrow(() -> new RuntimeException("Assignment duration of " + assignmentId + " id is not found."));
    }

    public LocalDate getAssignmentDeadlineById(int assignmentId) {
        return getAssigmentList()
                .stream()
                .filter(assignment -> assignment.id() == assignmentId)
                .findFirst()
                .map(Assignment::deadLine)
                .orElseThrow(() -> new RuntimeException("Assignment of " + assignmentId + " not found."));
    }

    public void updateDeadlineById(int assignmentId, LocalDate newDeadline) {
        dao.updateAssigmentDeadline(assignmentId, newDeadline);
    }

    public List<Integer> getCourseIdsListByStudentId(int studentId) {
        return getEnrollmentList()
                .stream()
                .filter(course -> course.studentId() == studentId)
                .map(EnrollmentCourse::courseId)
                .toList();
    }

    public List<Material> getCourseMaterialList() {
        return dao.findAllMaterial();
    }

    public boolean studentSubmitted(int studentId, int assignmentId) {
        return new UserService().getStudentsGradesList()
                .stream()
                .filter(studentGrades -> studentGrades.assignmentId() == assignmentId && studentGrades.studentId() == studentId)
                .findFirst()
                .map(StudentGrades::submitted)
                .orElseThrow(() -> new RuntimeException("No record matched the ids"));
    }

    public void submitAssignment(AssignmentSubmission assignment) {
        dao.submitAssigment(assignment);
    }

    public void uploadCourseMaterial(Material material) {
        dao.saveCourseMaterial(material);
    }

    public int getCourseIdByAssignmentId(int assignmentId) {
        return getAssigmentList()
                .stream()
                .filter(assignment -> assignment.id() == assignmentId)
                .findFirst()
                .map(Assignment::courseId)
                .orElseThrow(() -> new RuntimeException("No course id that has assignment id of " + assignmentId));
    }
}
