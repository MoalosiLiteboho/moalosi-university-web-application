package com.moalosi.administrator;

import com.moalosi.service.AuthorityService;
import com.moalosi.service.DistrictService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/administrator-add-users")
public class AdministratorMenuAddUsers extends HttpServlet {
    private final AuthorityService authorityService = new AuthorityService();
    private final DistrictService districtService = new DistrictService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h4>Add User</h4>");
        out.println("<div class=\"add-form-container\">");
        out.println("<form action=\"register-or-register-user\" method=\"post\">");
        out.println("<div class=\"selection-container\">");
        out.println("<select class=\"custom-select\" name=\"authorityId\" id=\"userTypeId\">");

        authorityService.getAuthorityList()
                .forEach(authority -> out.println("<option value=\"" + authority.id() +"\">" + authority.authority() + "</option>"));

        out.println("</select>");
        out.println("<label for=\"userTypeId\">UserType</label>");
        out.println("</div>");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"text\" name=\"name\" id=\"nameId\" autocomplete=\"off\" placeholder=\" \">");
        out.println("<label for=\"nameId\">Name</label>");
        out.println("</div>");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"text\" name=\"surname\" id=\"surnameId\" autocomplete=\"off\" placeholder=\" \">");
        out.println("<label for=\"surnameId\">Surname</label>");
        out.println("</div>");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"date\" name=\"dateOfBirth\" id=\"dateOfBirthId\" placeholder=\" \">");
        out.println("<label for=\"dateOfBirthId\">Date Of Birth</label>");
        out.println("</div>");
        out.println("<div class=\"selection-container\">");
        out.println("<select class=\"custom-select\" name=\"districtCode\" id=\"districtsId\">");

        districtService.getDistrictsList()
                .forEach(district -> out.println("<option value=\"" + district.code() + "\">" + district.name() + "</option>"));

        out.println("<option value=\"100\">Maseru</option>");
        out.println("</select>");
        out.println("<label for=\"districtsId\">District</label>");
        out.println("</div>");
        out.println("<div class=\"radio-container\">");
        out.println("<h3>Gender</h3>");
        out.println("<input type=\"radio\" name=\"gender\" value=\"Male\" id=\"maleId\" checked>");
        out.println("<label for=\"maleId\">Male</label>");
        out.println("<input type=\"radio\" name=\"gender\" value=\"Female\" id=\"femaleId\">");
        out.println("<label for=\"femaleId\">Female</label>");
        out.println("<input type=\"radio\" name=\"gender\" value=\"Others\" id=\"othersId\">");
        out.println("<label for=\"othersId\">Others</label>");
        out.println("</div>");
        out.println("<div class=\"button-container\">");
        out.println("<input type=\"submit\" value=\"register\">");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
    }
}
