package com.task.Products_App.jasper;


import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

@RestController
@RequestMapping("/products")
public class JasperController {

    @Autowired
    private JasperService jasperService;


    @GetMapping(path = "/report")
    public void generateReport(HttpServletResponse response) {
        try {
            JasperPrint print = jasperService.generateProductsReport();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");
            JasperExportManager.exportReportToPdfStream(print , response.getOutputStream());
        } catch (JRException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
