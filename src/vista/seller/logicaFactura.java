/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.seller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author 
 */
public class logicaFactura {
    
    private Font normalFont = new Font(Font.FontFamily.COURIER);
    private Document doc = new Document(PageSize.A4);
    
    private int vTT = 0;
    private int vTTD =0;
    
    PdfPTable table = new PdfPTable(4);
    
    public void generar(String fec, String cod, String cli, String nit, String desc, String dir,
            String tel, String f, String salida){
    
        vTTD = vTT - (Integer.parseInt(desc) * vTT)/100 ;
        
        try {
            
            PdfWriter.getInstance(doc, new FileOutputStream(salida));
            doc.open();
           
            Image imagen = Image.getInstance("src\\img\\logo.png");
            imagen.scaleAbsolute(300, 150);
            imagen.setAlignment(Element.ALIGN_CENTER);
           
            doc.add(imagen);
            
            doc.add(getBody(fec));
            doc.add(getBody(cod));
            doc.add(getBody(cli));
            doc.add(getBody(nit));
            doc.add(getBody("Descuento: " + desc+"%"));
            doc.add(getBody(dir));
            doc.add(getBody(tel));
            
            doc.add(getBody(" "));
            doc.add(getBody(" "));
            doc.add(getBody(" "));
            
            PdfPCell cF = new PdfPCell(new Paragraph("Total $:   "));
            PdfPCell cFD = new PdfPCell(new Paragraph("Total con descuento $:   "));
            cF.setColspan(3);
            cFD.setColspan(3);
            cF.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cFD.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            table.addCell(cF);
            table.addCell(""+vTT);
            
            table.addCell(cFD);
            table.addCell(""+vTTD);
            
            doc.add(table);
            
            doc.add(getBody(" "));
            doc.add(getBody(" "));
            
            doc.add(getFooter(f));
            
            doc.close();
            
        } catch (Exception e) {
            e.getMessage();
        }
        
        
    };
    
    public void agregarDatoTabla(int c, String p, int vU, int vT){
        table.addCell(""+c);
        table.addCell(p);
        table.addCell(""+vU);
        table.addCell(""+vT);
    
        vTT = vTT + vT;
    }
    
    public void quitarDatoTabla(int i, int vT){
        vTT = vTT - vT;
        
        table.deleteRow(i+1);
    }
    
    public void iniciarTabla(){
        table.addCell("Cantidad");
        table.addCell("Producto");
        table.addCell("Valor Unit.");
        table.addCell("Valor total");
    }
    
 /*   private Paragraph getHeader(String text){
        
        Paragraph p = new Paragraph();

        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(text);
        c.setFont(normalFont);
        p.add(c);
        
        return p;
        
    };*/
    private Paragraph getBody(String text){
        
        Paragraph p = new Paragraph();

        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(text);
        c.setFont(normalFont);
        p.add(c);
        
        return p;
        
    };
    private Paragraph getFooter(String text){
        
        Paragraph p = new Paragraph();

        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_BOTTOM);
        c.append(text);
        c.setFont(normalFont);
        p.add(c);
        
        return p;
        
    };
    
    
    
    public void closeNow(){
    
        doc.close();
    }
 
    
    
    
}
