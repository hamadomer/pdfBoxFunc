package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        PDFHandler.createPdfWithGivenSize(100, "src/main/resources/pdf");
        long end = System.nanoTime();

        System.out.println(TimeUnit.MILLISECONDS.convert((end - start), TimeUnit.NANOSECONDS));
    }
}