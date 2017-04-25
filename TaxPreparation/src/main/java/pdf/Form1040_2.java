package pdf;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;

/**
 * Created by admin on 9/22/16.
 */
public class Form1040_2 {

    public static void main(String[] args) throws Exception{

        PdfReader reader=new PdfReader("/Users/admin/Desktop/TaxPreparation/files/f1040sa.pdf");
        AcroFields form=reader.getAcroFields();
        form.setField("topmostSubform[0].Page1[0].c1_1[0]", "1");






    }
}
