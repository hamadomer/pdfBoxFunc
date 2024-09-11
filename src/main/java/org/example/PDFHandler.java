package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class PDFHandler {

  public static void createPdfWithGivenSize(int size, String path) throws IOException {

    PDDocument doc = new PDDocument();
    PDPage page = new PDPage();

    // size is divided by 2.5 because the image used is 2.5 Mb
    System.out.print("Creating PDF...");
    for(int i = 0; i < (size / 2.5); i++) {

        doc.addPage(page);

        PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/pdf/25.jpg", doc);

        PDPageContentStream contents = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, false);

        contents.drawImage(pdImage, 70, 250);
        contents.close();

        System.out.print(".");
    }

    doc.save(path + "/output.pdf");

    doc.close();

    System.out.println(" Done!");
}

}
