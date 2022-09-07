package com.PdfWritter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class HtmlToPdfService implements CommandLineRunner {

    @Autowired
    private final TemplateEngine templateEngine;

    public HtmlToPdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String createHtml() {
        Context context = new Context();
        Employee employee1 = new Employee();
        employee1.setCompany("Reply");
        employee1.setContact("andrei@yahoo.com");
        employee1.setCountry("Romania");

        Employee employee2 = new Employee();
        employee2.setCompany("Reply");
        employee2.setContact("robert@yahoo.com");
        employee2.setCountry("Romania");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        context.setVariable("employeeList", employeeList);

        Customer customer = new Customer();
        customer.setName("John");
        context.setVariable("customerName", customer.getName());

        final String htmlContent = this.templateEngine.process("index.html", context);
        return htmlContent;
    }

    @Override
    public void run(String... args) throws Exception {
        createHtml();
    }
}
