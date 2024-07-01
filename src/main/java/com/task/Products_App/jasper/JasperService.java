package com.task.Products_App.jasper;


import com.task.Products_App.entity.Product;
import com.task.Products_App.service.ProductService;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

@Service
public class JasperService {

    @Value("${app.jasper.filePath}")
    private String jasperFilePath;

    @Value("${spring.datasource.url}")
    private String connectionUrl;

    @Value("${spring.datasource.username}")
    private String connectionUsername;

    @Value("${spring.datasource.password}")
    private String connectionPassword;

    @Autowired
    private ProductService productService;



    public JasperPrint generateProductsReport() throws JRException, SQLException {

        Connection connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword);
        return JasperFillManager.fillReport(jasperFilePath, new HashMap<>(), connection);
    }
}
