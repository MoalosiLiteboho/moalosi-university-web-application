package com.moalosi.controllers;

import com.moalosi.dao.DaoImplementation;
import com.moalosi.id.IdGenerator;
import com.moalosi.model.Feedback;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "StudentAddNewFeedback", value = "/student-add-new-feedback")
public class StudentAddFeedbackController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rating = request.getParameter("rating");
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String feedback = request.getParameter("feedback");

        new DaoImplementation().saveFeedback(new Feedback(
                new IdGenerator().get(),
                courseId,
                rating,
                feedback
        ));

        response.sendRedirect("StudentDashboard.jsp");
    }
}
