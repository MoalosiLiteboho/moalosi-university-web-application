package com.moalosi.administrator;

import com.moalosi.service.AuthorityService;
import com.moalosi.service.DistrictService;
import com.moalosi.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/administrator-user-table")
public class AdministratorMenuUsersTable extends HttpServlet {
    private final UserService userService = new UserService();
    private final DistrictService districtService = new DistrictService();
    private final AuthorityService authorityService = new AuthorityService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h4>User Table</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Name</th>");
        out.println("<th>Surname</th>");
        out.println("<th>Gender</th>");
        out.println("<th>Date of Birth</th>");
        out.println("<th>District</th>");
        out.println("<th>Authority</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tbody>");

        userService.getUsersList()
                .forEach(user -> {
                    out.println("<tr>");
                    out.println("<td>" + user.id() + "</td>");
                    out.println("<td>" + user.name() + "</td>");
                    out.println("<td>" + user.surname() + "</td>");
                    out.println("<td>" + user.gender() + "</td>");
                    out.println("<td>" + user.dateOfBirth() + "</td>");
                    out.println("<td>" + districtService.getDistrictByCode(user.districtCode()) + "</td>");
                    out.println("<td>" + authorityService.getAuthorityByAuthorityId(user.authorityId()) + "</td>");
                    out.println("<td>");
                    out.println("<a href=\"delete-user-by-user-id?id=" + user.id() + "\"><i class=\"uil uil-trash-alt delete\"></i></a>");
                    out.println("<a href=\"UpdateUser.jsp?id=" + user.id() + "\"><i class=\"uil uil-pen update\"></i></a>");
                    out.println("</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
