package com.moalosi.controllers;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.moalosi.service.CourseService;
import com.moalosi.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@WebServlet(name = "generateStudentGradesReportController", value = "/generate-student-grade-report")
public class GenerateStudentGradesReportController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=student_grade_report.pdf");
        CourseService courseService = new CourseService();
        UserService userService = new UserService();

        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        document.add(getTableTittle.apply("Student Grade Report"));

        Table table = new Table(new float[7]);
        table.setWidthPercent(100);
        table.addHeaderCell("#").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Student").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Course").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Assignment").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Marks").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Grade").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Submitted").setTextAlignment(TextAlignment.CENTER);

        userService.getStudentsGradesList()
                .forEach(grades -> {
                    table.addCell(getCellData.apply(String.valueOf(grades.id()), getFont.get()));
                    table.addCell(getCellData.apply(userService.getUserNamesById(grades.studentId()), getFont.get()));
                    table.addCell(getCellData.apply(courseService.getCourseNameById(grades.courseId()), getFont.get()));
                    table.addCell(getCellData.apply(courseService.getAssignmentNameById(grades.assignmentId()), getFont.get()));
                    table.addCell(getCellData.apply(String.valueOf(grades.marks()), getFont.get()));
                    table.addCell(getCellData.apply(grades.Grade(), getFont.get()));
                    table.addCell(getCellData.apply(String.valueOf(grades.submitted()), getFont.get()));
                });
        document.add(table);
        document.close();
    }

    private final BiFunction<String, PdfFont, Cell> getCellData = (cellName, font) ->  new Cell()
            .add(new Paragraph(String.valueOf(cellName)))
            .setPadding(5)
            .setFont(font)
            .setFontSize(8);

    private final Function<String, Paragraph> getTableTittle = tableName -> new Paragraph(tableName)
            .setTextAlignment(TextAlignment.CENTER)
            .setBold();

    private final Supplier<PdfFont> getFont = () -> {
        try {
            return PdfFontFactory.createFont("Helvetica", "Cp1252", true);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    };
}
