package com.moalosi.instructor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InstructorMenuAddCourse" , value = "/instructor-add-course")
public class InstructorMenuAddCourse extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h4>Add Course</h4>");
        out.println("<div class=\"add-form-container\">");
        out.println("<form action=\"instructor-add-new-course\" method=\"post\">");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"text\" name=\"name\" id=\"nameId\" placeholder=\" \">");
        out.println("<label for=\"nameId\">Name</label>");
        out.println("</div>");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"text\" name=\"description\" id=\"descriptionId\" autocomplete=\"off\" placeholder=\" \">");
        out.println("<label for=\"descriptionId\">Description</label>");
        out.println("</div>");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"text\" name=\"type\" id=\"typeId\" autocomplete=\"off\" placeholder=\" \">");
        out.println("<label for=\"typeId\">Type</label>");
        out.println("</div>");
        out.println("<div class=\"button-container\">");
        out.println("<input type=\"submit\" value=\"register\">");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
    }
}
