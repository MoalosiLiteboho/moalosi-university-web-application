package com.moalosi.service;

import com.moalosi.model.Course;
import com.moalosi.dao.DaoImplementation;
import com.moalosi.dtoMapper.InstructorNamesAndIdMapper;
import com.moalosi.dtoMapper.UserDtoMapper;
import com.moalosi.dtoMapper.UserIdAndAuthorityDtoMapper;
import com.moalosi.model.*;
import com.moalosi.password.PasswordEncryptor;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final DaoImplementation dao;
    private final UserDtoMapper userDtoMapper;
    private final InstructorNamesAndIdMapper instructorNamesAndIdMapper;
    private final UserIdAndAuthorityDtoMapper userIdAndAuthorityDtoMapper;


    public UserService() {
        dao = new DaoImplementation();
        userDtoMapper = new UserDtoMapper();
        instructorNamesAndIdMapper = new InstructorNamesAndIdMapper();
        userIdAndAuthorityDtoMapper = new UserIdAndAuthorityDtoMapper();
    }

    public void userRegistration(User user) {
        dao.registerUser(user);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

    public void deleteUser(int userId) {
        dao.deleteUserById(userId);
    }

    public boolean checkIfUserExits(int userId) {
        return getUsersList()
                .stream()
                .anyMatch(userDetails -> userDetails.id() == userId);
    }

    public List<UserDetails> getUserDetailsList() {
        return dao.findAllUsers();
    }

    public List<User> getUsersList() {
        return getUserDetailsList()
                .stream()
                .map(userDtoMapper)
                .collect(Collectors.toList());
    }

    public User getUserById(int userId) {
        return getUsersList()
                .stream()
                .filter(user -> user.id() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with " + userId + " id is not found."));
    }

    public List<InstructorNamesAndId> getInstructorsNamesAndIdList() {
        return getUsersList()
                .stream()
                .filter(user -> user.authorityId() == 2)
                .map(instructorNamesAndIdMapper)
                .collect(Collectors.toList());
    }

    public String getUserNamesById(int userId) {
        return getUsersList()
                .stream()
                .filter(user -> user.id() == userId)
                .findFirst()
                .map(user -> user.name() + " " + user.surname())
                .orElseThrow(() -> new RuntimeException("No User of id -> " + userId));
    }

    public List<StudentGrades> getStudentsGradesList() {
        return dao.findAllStudentGrades();
    }

    public UserIdAndAuthorityDto getUserIdAndAuthorityByCredentials(SignInCredentials credentials) {
        String password = new PasswordEncryptor().apply(credentials.password());

        return getUserDetailsList()
                .stream()
                .filter(user -> user.username().equals(credentials.username()) && user.password().equals(password) && user.enabled())
                .findFirst()
                .map(userIdAndAuthorityDtoMapper)
                .orElseThrow(() -> new RuntimeException("User of " + credentials + " credentials not found."));
    }

    public String grateOfAMark(int mark) {
        if(mark >= 75)
            return "Distinction";
        else if(mark >= 60)
            return "Merit";
        else if(mark >= 50)
            return "Pass";
        else
            return "Fail";
    }

    public void gradeStudentById(StudentGrade studentGrade) {
        dao.gradeStudent(studentGrade);
    }

    public List<StudentFeedback> getStudentFeedbackList() {
        return dao.findAllStudentsFeedbacks();
    }

    public String getInstructorNamesByCourseId(int courseId) {
        return getUserNamesById( new CourseService().getCourseList()
                .stream()
                .filter(course -> courseId == (course.id()))
                .mapToInt(Course::instructorId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("course with id of " + courseId + " not found.")));
    }
}
