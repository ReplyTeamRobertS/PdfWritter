package com.robert.PdfWritter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class HtmlService implements CommandLineRunner {

    @Autowired
    private TemplateEngine engine;

    public String getHtmlContent() {
        final Context ctx = new Context(Locale.getDefault());

        List<Person> persons = new ArrayList<>();

        Person person1 = new Person();
        person1.setCompany("Reply");
        person1.setContact("Thomas");
        person1.setCountry("France");
//        Person person2 = new Person("Reply", "Eddi", "Italy");
//        Person person3 = new Person("UniCredit", "John", "Romania");

        persons.add(person1);
//        persons.add(person2);
//        persons.add(person3);

        ctx.setVariable("persons", persons);

        ctx.setVariable("company", person1.getCompany());
        ctx.setVariable("contact", person1.getContact());
        ctx.setVariable("country", person1.getCountry());

//        ctx.setVariable("company", person2.getCompany());
//        ctx.setVariable("contact", person2.getContact());
//        ctx.setVariable("country", person2.getCountry());
//
//        ctx.setVariable("company", person3.getCompany());
//        ctx.setVariable("contact", person3.getContact());
//        ctx.setVariable("country", person3.getCountry());

        final String htmlContent = this.engine.process("index.html", ctx);

        return htmlContent;
    }

    @Override
    public void run(String... args) throws Exception {
        getHtmlContent();
    }
}
