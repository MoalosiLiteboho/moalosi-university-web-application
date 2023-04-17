package com.moalosi.controllers;

import com.moalosi.id.IdGenerator;
import com.moalosi.model.Material;
import com.moalosi.service.CourseService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet(name = "addingCourseController", value = "/instructor-add-new-course-material")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 1_000, maxRequestSize = 1024 * 1024 * 1_000)
public class AddCourseMaterialController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String folderName = "resources";
            String uploadPath =  request.getServletContext().getRealPath("") + File.separator +  folderName;

            File directory = new File(uploadPath);
            if(!directory.exists())
                directory.mkdirs();

            Part filePart = request.getPart("file");
            String tittle = request.getParameter("name");
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            String fileName = filePart.getSubmittedFileName();
            String path = folderName + File.separator + fileName;

            InputStream is = filePart.getInputStream();
            Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);

            new CourseService().uploadCourseMaterial(new Material(
                    new IdGenerator().get(),
                    courseId,
                    tittle,
                    path));

            response.sendRedirect("InstructorDashboard.jsp");
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
