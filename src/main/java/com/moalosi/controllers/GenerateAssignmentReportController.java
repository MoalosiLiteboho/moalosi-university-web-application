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

@WebServlet(name = "generateReportController", value = "/generate-assignment-report")
public class GenerateAssignmentReportController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=submission_report.pdf");
        CourseService courseService = new CourseService();
        UserService userService = new UserService();

        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(response.getOutputStream()));
        Document document = new Document(pdfDocument);

        document.add(getTableTittle.apply("Submission Report"));

        Table table = new Table(new float[6]);
        table.setWidthPercent(100);
        table.addHeaderCell("#").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Course").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Assignment").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Duration").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Student").setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell("Submitting Date").setTextAlignment(TextAlignment.CENTER);

        courseService.getAssigmentSubmissionsList()
                .forEach(submission -> {
                    table.addCell(getCellData.apply(String.valueOf(submission.id()), getFont.get()));
                    table.addCell(getCellData.apply(courseService.getCourseNameById(submission.courseId()), getFont.get()));
                    table.addCell(getCellData.apply(courseService.getAssignmentNameById(submission.assignmentId()), getFont.get()));
                    table.addCell(getCellData.apply(courseService.getAssigmentDurationById(submission.assignmentId()), getFont.get()));
                    table.addCell(getCellData.apply(userService.getUserNamesById(submission.studentId()), getFont.get()));
                    table.addCell(getCellData.apply(String.valueOf(submission.submissionDate()), getFont.get()));
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
