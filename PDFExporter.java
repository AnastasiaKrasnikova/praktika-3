import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;

public class PDFExporter {
    public static void exportVotingResults(Voting voting, String filePath) throws IOException {
        PdfWriter writer = new PdfWriter(new File(filePath));
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        document.
add(new Paragraph("Результаты голосования: " + voting.getTitle()));
        
        voting.getCandidates().forEach(candidate -> {
            document.add(new Paragraph(candidate.getFullName() + ": " + 
                voting.getVotesFor(candidate) + " голосов"));
        });
        
        document.close();
    }
}
