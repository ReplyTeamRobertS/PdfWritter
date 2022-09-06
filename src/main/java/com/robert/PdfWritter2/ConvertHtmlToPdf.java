package com.robert.PdfWritter2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.extend.FontResolver;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;


import java.io.*;
import java.nio.file.FileSystems;

@Component
public class ConvertHtmlToPdf implements CommandLineRunner {

   // File inputHTML = new File("C:\\Work\\Projects\\PdfWritter2\\src\\main\\resources\\index.html");
    Resource resource = new ClassPathResource("index.html");

    public Document parseHtml() throws IOException {
        Document document = Jsoup.parse(resource.getFile() , "UTF-8");
        document.outputSettings().
                syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }

    public void createPdfFromHtml(){

        try (OutputStream outputStream = new FileOutputStream("C:\\Work\\Projects\\PDF_Test\\doc10.pdf")) {
            String baseUrl = FileSystems.getDefault()
                    .getPath("src/main/resources/")
                    .toUri().toURL().toString();
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);

            FontResolver resolver = renderer.getFontResolver();


            renderer.setDocumentFromString(parseHtml().html(), baseUrl);
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
