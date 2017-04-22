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

public class XmlCreator implements Constants {
    String  FILE_data;
    Collection collection;
    int index_report;
    String object;
    String summary;

    public XmlCreator(String file_name, Collection collection, int index_report){
        this.collection = collection;
        this.index_report = index_report;
        FILE_data = file_name + ".xml";

        makeReport();
    }

    public void makeReport(){

        switch(this.index_report){
            case(1):
                this.object = "student";
                int users_num = this.collection.outer.size() - 1;
                this.summary = "Number of registered students: " +
                        users_num + " people";
                break;
            case(2):
                this.object = "course";
                this.summary = "";
                break;
            case(3):
                this.object = "student";
                this.summary = "";
                break;
            case(4):
                this.object = "group";
                this.summary ="";
                break;
            case(5):
                this.object = "course";
                this.summary ="";
                break;
            case(6):
                break;
            case(7):
                break;
        }

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

            Element e_root = doc.createElement("report"); //основной объект
            e_root.setAttribute("lang", "en");

            //-----------------модель-----------------
            // 0 строка - названия столбцов
            // <main>
            //      <obj[1] - строка>
            //              <info/> - название столбца
            //              <info/> - название столбца
            //              <info/> - название столбца
            //      </<obj[1] - строка>
            //             :
            //             :
            //             :
            //             :
            //      <obj[last]> - строка>
            //              <info/> - название столбца
            //              <info/> - название столбца
            //              <info/> - название столбца
            //      </<obj[last]> - строка>
            // </main>
            // <summary>
            //      <summary_info/>
            // </summary>
            //--------------------------------------------

            // 2 основных тега
            Element e_main = doc.createElement("main");
            Element e_summary = doc.createElement("summary");

            //System.out.println("Collection cheсk ... \n ... collection size is " + this.collection.outer.size());


            //-----заполнение--------------------------------------------------------------
            for(int i = 1; i < this.collection.outer.size(); i++){
                //создание элемента
                Element e_object = doc.createElement(this.object);
                //по столбцам
                for(int j = 0; j < this.collection.outer.get(0).size(); j++){
                    String s = this.collection.outer.get(0).get(j);
                    s = s.replace(" ", "_");
                    Element e_info = doc.createElement(s); //теги из 0 строки
                    e_info.setTextContent(this.collection.outer.get(i).get(j)); //содержимое из ячейки j в строке i > 0
                    //добавление информации в объект
                    e_object.appendChild(e_info);
                }
                //добавление объекта в main
                e_main.appendChild(e_object);
            }

            e_summary.setTextContent(String.format(summary));

            //----------------------------------------------------------------------------

            e_root.appendChild(e_main);
            e_root.appendChild(e_summary);
            doc.appendChild(e_root);

        } catch (ParserConfigurationException e) {
        } finally {
            // Сохраняем Document в XML-файл
            if (doc != null)
                writeDocument(doc, Constants.ABSOLUTE_PATH + FILE_data);
        }
    }

    //Сохранение DOM в файл
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