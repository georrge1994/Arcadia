package support;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
import java.util.Vector;

public class XmlCreator {
    private  final  String  FILE_data;
    Vector<User> users;
    String date1, date2;

    public XmlCreator(String file_name, Vector<User> users, String date1, String date2){
        //информации по датам пока нет
        this.date1= date1;
        this.date2 = date2;
        this.users = users;
        FILE_data = file_name + ".xml";
        try {
            writeDataXML_type1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void writeDataXML_type1() throws TransformerFactoryConfigurationError,
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

            Element e_root = doc.createElement("report");
            e_root.setAttribute("lang", "en");
            Element e_users = doc.createElement("users");
            Element e_summary = doc.createElement("summary");
            e_summary.setTextContent(String.format("Number of registered users from %s to %s: %d people",
                    this.date1, this.date2, users.size()));
            e_root.appendChild(e_users);
            e_root.appendChild(e_summary);
            doc.appendChild(e_root);

            if(users.size() == 0)
                return;

            //перечисление всех пользователей за период
            for (int i=0; i < users.size(); i++){
                Element e_user = doc.createElement("user");
                Element e_user_number = doc.createElement("userNumber");
                Element e_user_name = doc.createElement("userName");
                Element e_user_date = doc.createElement("userRegistrationDte");

                e_user_number.setTextContent(users.get(i).getKey());
                e_user_name.setTextContent(users.get(i).getName());
                e_user_date.setTextContent(users.get(i).getRegistrationDate());

                e_user.appendChild(e_user_number);
                e_user.appendChild(e_user_name);
                e_user.appendChild(e_user_date);
                e_users.appendChild(e_user);
            }
        } catch (ParserConfigurationException e) {
        } finally {
            // Сохраняем Document в XML-файл
            if (doc != null)
                writeDocument(doc, "D:/" + FILE_data);
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

