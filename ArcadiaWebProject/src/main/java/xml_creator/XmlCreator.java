package xml_creator;

import firebase_communication.Collection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import support.Constants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//-----------------model-----------------
// 0 line - column's names
// <main>
//      <obj[1]>
//              <info/> - column name
//              <info/> - column name
//              <info/> - column name
//      </<obj[1]>
//             :
//             :
//             :
//             :
//      <obj[last]>
//              <info/> - column name
//              <info/> - column name
//              <info/> - column name
//      </<obj[last]>
// </main>
// <summary>
//      <summary_info/>
// </summary>
//--------------------------------------------

public class XmlCreator implements Constants{
    String  FILE_data;
    Collection collection;
    int index_report;
    String object;

    public XmlCreator(String file_name, Collection collection, String object){
        this.collection = collection;
        this.object = object;
        FILE_data = file_name + ".xml";

        try {
            writeDataXML();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void writeDataXML() throws TransformerFactoryConfigurationError,
            FileNotFoundException,
            TransformerException
    {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder        db  = null;
        Document               doc = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db  = dbf.newDocumentBuilder();
            doc = db.newDocument();

            Element e_root = doc.createElement("report"); //root element
            e_root.setAttribute("lang", "en");

            //-----filling--------------------------------------------------------------
            for(int i = 1; i < this.collection.outer.size(); i++){
                //creating object element
                Element e_object = doc.createElement(this.object);
                for(int j = 0; j < this.collection.outer.get(0).size(); j++){
                    String s = this.collection.outer.get(0).get(j);
                    s = s.replace(" ", "_");
                    Element e_info = doc.createElement(s);
                    e_info.setTextContent(this.collection.outer.get(i).get(j));
                    //add info in object
                    e_object.appendChild(e_info);
                }
                //add object in report
                e_root.appendChild(e_object);
            }
            //----------------------------------------------------------------------------
            doc.appendChild(e_root);

        } catch (ParserConfigurationException e) {
        } finally {
            // save Document in XML-file
            String savePath = System.getProperty("user.dir") + "\\" + FILE_data;
            if (doc != null)
                writeDocument(doc, System.getProperty("user.dir") + "\\" + FILE_data);
        }
    }

    //save DOM
    private void writeDocument(Document document, final String path)
            throws TransformerFactoryConfigurationError,
            FileNotFoundException,
            TransformerException
    {
        Transformer      trf = null;
        DOMSource        src = null;
        FileOutputStream fos = null;
        try {
            trf = TransformerFactory.newInstance().newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
            fos.close();
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}