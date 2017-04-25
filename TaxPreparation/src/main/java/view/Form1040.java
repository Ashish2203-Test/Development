package view;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTree;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

public class Form1040 {

    public static PDField chbx_Single;
    public static PDField chbx_MarriedFilingJointly;



    public static void main(String[] args) throws Exception{

        FileInputStream fis=new FileInputStream(new File("/Users/admin/Desktop/TaxPreparation/files/f1040.pdf"));

        PDDocument document=PDDocument.load(fis);

        PDDocumentCatalog catalog=document.getDocumentCatalog();

        PDAcroForm form=catalog.getAcroForm();

        PDFieldTree tree=form.getFieldTree();

        Iterator<PDField> iterator=tree.iterator();

        int i=0;

        while(iterator.hasNext()){
            i++;
            System.out.print(i+"\t");
            PDField field=iterator.next();
            System.out.println(field.getFieldType());
            System.out.println(field.getFullyQualifiedName());
            System.out.println(field.getParent());
            System.out.println("-----------------------------------------");
        }

        chbx_Single=form.getField("topmostSubform[0].Page1[0].Lines1-3[0].c1_03[0]");

        ((PDCheckBox)chbx_Single).check();


        chbx_MarriedFilingJointly=form.getField("topmostSubform[0].Page1[0].Lines1-3[0].c1_03[1]");
        ((PDCheckBox)chbx_MarriedFilingJointly).check();

        document.save(new File("/Users/admin/Desktop/TaxPreparation/files/f1040_edited.pdf"));
        document.close();

    }




}
