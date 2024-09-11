import org.apache.pdfbox.pdmodel.PDDocument;
import org.example.PDFHandler;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


public class PDFHandlerTest {

    @Test
    public void testPdfCreation() throws IOException {
        // Given
        int size = 10; // 10Mo
        String path = "src/main/resources/pdf";

        // When
        PDFHandler.createPdfWithGivenSize(size, path);

        // Then
        try(PDDocument savedDoc = PDDocument.load(new File(path + "/output.pdf"))) {
            assertEquals(size / 2.5, savedDoc.getNumberOfPages());
        }
    }

    @Test
    public void testCreatePdfWithInvalidPath() throws IOException {

        File file = new File("src/main/resources/pdf/output.pdf");

        file.length();

        // Given
        int size = 10;
        String path = "not_exist_path";

        // When , Then
        assertThrows(FileNotFoundException.class,() ->PDFHandler.createPdfWithGivenSize(size, path));
    }

    @Test
    public void testCreatePdfWithGivenSize() throws IOException {
        // Given
        int size = 10;
        String path = "src/main/resources/pdf";

        // When
        PDFHandler.createPdfWithGivenSize(size, path);
        File file = new File("src/main/resources/pdf/output.pdf");
        int actualSize = (int) file.length() / (1024 * 1024);

        // Then
        assertEquals(size, actualSize);
    }


}
