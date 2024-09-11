package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class PDFHandler {

  public static void createPdfWithGivenSize(int size, String path) throws IOException {

      String userSystemName = System.getProperty("os.name");

      if (userSystemName.contains("Linux")) {
          long sizeInBytes = size * 1024 * 1024L;

        String[] command = {"bash", "-c", "fallocate -l " + sizeInBytes + " " + path};

        Process process = Runtime.getRuntime().exec(command);

        try {
            int exitCode = process.waitFor();

            if(exitCode == 0) {
                System.out.println("PDF file created successfully at " + path + " with size " + size + " Mo");
            }else {
                System.out.println("Error creating PDF file, exit code: " + exitCode);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      } else {
          PDDocument doc = new PDDocument();
          PDPage page = new PDPage();

          // size is divided by 2.5 because the image used is 2.5 Mb
          System.out.print("Creating PDF...");
          for (int i = 0; i < (size / 2.5); i++) {

              doc.addPage(page);

              PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/pdf/25.jpg", doc);

              PDPageContentStream contents = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, false);

              contents.drawImage(pdImage, 70, 250);
              contents.close();

              System.out.print(".");
          }

          doc.save(path);

          doc.close();

          System.out.println(" Done!");
      }
  }

}
