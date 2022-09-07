package com.PdfWritter2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;

@Component
public class ConvertHtmlToPdf implements CommandLineRunner {
    @Autowired
    HtmlToPdfService htmlToPdfService;
    Resource resource = new ClassPathResource("templates/index.html");

    public Document parseHtml() throws IOException {
        Document document = Jsoup.parse(resource.getFile(), "UTF-8");
        document.outputSettings()
                .syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }

    public void createPdfFromHtml() {

        try (OutputStream outputStream
                     = new FileOutputStream
                ("C:\\Users\\Andrei N\\IntelliJ\\Academy\\PdfWritter\\src\\main\\resources\\generatedPdf\\htmlToPdf.pdf")) {
            String baseUrl = FileSystems.getDefault()
                    .getPath("src/main/resources/")
                    .toUri().toURL().toString();
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);

//            renderer.setDocumentFromString(parseHtml().html(), baseUrl);
            renderer.setDocumentFromString(htmlToPdfService.createHtml(), baseUrl);
            renderer.layout();
            renderer.createPDF(outputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run(String... args) throws Exception {
        createPdfFromHtml();
    }
}
