package pdf;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFAResource;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by admin on 9/21/16.
 */
public class Form1040_1 {
    public static void main(String[] args) throws Exception{

        File in=new File("/Users/admin/Desktop/TaxPreparation/files/f1040.pdf");
        File out=new File("/Users/admin/Desktop/TaxPreparation/files/f1040_out.pdf");

        PDDocument doc=PDDocument.load(in);
        doc.setAllSecurityToBeRemoved(true);

        PDDocumentCatalog cat=doc.getDocumentCatalog();

        PDAcroForm form=cat.getAcroForm();

        PDXFAResource xfa=form.getXFA();
        COSBase cos=xfa.getCOSObject();
        COSStream coss=(COSStream)cos;
        InputStream cosin=coss.createRawInputStream();

        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();

        Document document=builder.parse(cosin);




        COSStream cosout=new COSStream();
        OutputStream os=cosout.createRawOutputStream();

        TransformerFactory tfactory=TransformerFactory.newInstance();
        Transformer transformer=tfactory.newTransformer();

        DOMSource source=new DOMSource();
        StreamResult result=new StreamResult(os);
        transformer.transform(source, result);



        PDXFAResource xfaout=new PDXFAResource(cosout);
        form.setXFA(xfaout);








    }





}
