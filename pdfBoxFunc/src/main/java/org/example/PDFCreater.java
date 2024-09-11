package org.example;

import java.io.IOException;

public class PDFCreater {

    public static void createPdfWithGivenSize(int size, String path) throws IOException {

        long sizeInBytes = size * 1024 * 1024L;

        String[] command = {"bash", "-c", "fallocate -l " + sizeInBytes + " " + path};

        Process process = Runtime.getRuntime().exec(command);

        try {
            int exitCode = process.waitFor();

            if(exitCode == 0) {
                System.out.println("PDF file created successfully at " + " with size " + size + " Mo");
            }else {
                System.out.println("Error creating PDF file, exit code: " + exitCode);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
