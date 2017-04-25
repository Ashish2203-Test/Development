package pdf;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import org.apache.pdfbox.cos.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.form.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.XMLFormatter;

/**
 * Created by admin on 9/21/16.
 */
public class Form1040 {

    public static void main(String[] args) throws Exception {

        File file=new File("/Users/admin/Desktop/TaxPreparation/files/f1040.pdf");
        File file1=new File("/Users/admin/Desktop/TaxPreparation/files/f1040sa.pdf");
        File result =new File("/Users/admin/Desktop/TaxPreparation/files/f1040sa_sh.pdf");

        File xml=new File("/Users/admin/Desktop/TaxPreparation/files/f1040sa_sh.txt");


        PDDocument document=PDDocument.load(file);

        PDDocument document1=PDDocument.load(file1);

        PDPage page=document1.getPage(0);

        document.addPage(page);



        document.setAllSecurityToBeRemoved(true);

        PDDocumentCatalog catalog=document.getDocumentCatalog();

        PDAcroForm form=catalog.getAcroForm();

        PDXFAResource res=form.getXFA();
        Document doc=res.getDocument();

        NodeList list=doc.getElementsByTagName("xfa:data");

        NodeList list1=list.item(0).getChildNodes().item(0).getChildNodes();



        System.out.println("size: "+list1.getLength());

        for(int i=0; i<list1.getLength(); i++){
            System.out.println(list1.item(i).getNodeName());
        }

        Node node=list1.item(69);
        node.setTextContent("1");
        node.setNodeValue("1");
        System.out.println("size: "+node.getChildNodes().getLength());
        System.out.println(node.getNodeValue());
        System.out.println(node.getTextContent());
        System.out.println(node.getNodeName());
        System.out.println(node.getNodeType());







        //form.flatten();

        PDXFAResource xfa=form.getXFA();

        System.out.println(form.hasXFA());
        PDFieldTree tree=form.getFieldTree();

        Iterator<PDField> iter=tree.iterator();

        //PDField field4=form.getField("topmostSubform[0].Page1[0].c1_1[1]");
        //((PDCheckBox)field4).check();


/*

        while(iter.hasNext()){
            PDField f=iter.next();
            System.out.println(f.getFullyQualifiedName());
        }

        PDField field=form.getField("topmostSubform[0].Page1[0].f1_3[0]");
        field.setValue("100");

        PDField field1=form.getField("topmostSubform[0].Page1[0].f1_7[0]");
        field1.setValue("100");

        PDField field2=form.getField("topmostSubform[0].Page1[0].f1_9[0]");
        field2.setValue("100");

        PDField field3=form.getField("topmostSubform[0].Page1[0].c1_1[0]");
        ((PDCheckBox)field3).check();
        //field3.setValue("1");

        PDField field4=form.getField("topmostSubform[0].Page1[0].c1_1[1]");
        ((PDCheckBox)field4).check();

        PdfReader reader=new PdfReader(file.toString());

        AcroFields form1=reader.getAcroFields();

        form1.removeXfa();






        /*Document doc= xfa.getDocument();




        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        DocumentBuilder builder=factory.newDocumentBuilder();

        Transformer transformer= TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult res=new StreamResult(new StringWriter());

        DOMSource source=new DOMSource(doc);

        transformer.transform(source, res);

        String xmlString=res.getWriter().toString();

        System.out.println(xmlString);

        */









        form.flatten();

        document.save(result);
        document.close();






    }
}
