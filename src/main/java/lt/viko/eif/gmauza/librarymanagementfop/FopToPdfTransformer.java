package lt.viko.eif.gmauza.librarymanagementfop;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

/**
 * This class provides a main method to convert an FOP (Formatting Objects Processor) file to a PDF file.
 */
public class FopToPdfTransformer {

    /**
     * The main method to execute the FopToPdf class which converts a file to PDF format
     *
     * @param args the command-line arguments passed to the program
     */
    public static void main(String[] args) {
        FopToPdfTransformer fopToPdf = new FopToPdfTransformer();
        try {
            fopToPdf.convertToPDF();
        } catch (FOPException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that will convert the given XML to PDF
     *
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
    public void convertToPDF() throws IOException, FOPException, TransformerException {
        // the XSL FO file
        File xsltFile = new File("1.1 Part/library_FO.xsl");
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File("1.1 Part/library_FO.xml"));

        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out;

        out = new java.io.FileOutputStream("library" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMHHmmss")) + ".pdf");

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }


}