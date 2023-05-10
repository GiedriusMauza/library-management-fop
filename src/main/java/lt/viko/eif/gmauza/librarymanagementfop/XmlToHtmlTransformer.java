package lt.viko.eif.gmauza.librarymanagementfop;

import java.io.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * This class provides a static method to transform an XML file to an HTML file, using an XSLT file.
 */
public class XmlToHtmlTransformer {
    /**
     * Transforms the input XML file to an HTML file using an XSLT file.
     *
     * @param args The command-line arguments. This method expects no arguments.
     * @throws Exception If there is an error during the transformation process.
     */
    public static void main(String[] args) throws Exception {
        // Load the XML input document
        // input XML file
        File xmlFile = new File("1.1 Part/library_XSL.xml");

        // XSLT file used for transformation
        File xsltFile = new File("1.1 Part/library_XSL.xsl");

        // output HTML file in project root
        File htmlFile = new File("index.html");

        // create a transformer factory instance
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        // create a transformer instance for XSLT
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(xsltFile));

        // transform the XML document to HTML and write to the output file
        transformer.transform(new StreamSource(xmlFile), new StreamResult(htmlFile));
    }
}
