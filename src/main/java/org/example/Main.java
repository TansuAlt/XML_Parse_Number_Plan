package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;//builder.parse

// java DOM parser:xml dosyasından verileri okuyacak yerleşik java kütüphanesi
//xml dosyasını aktarırken kullanılan üç ana sınıf:DocumentBuilderFactory,DocumentBuilder,Document
//xml dosyasını bir belge olarak iletmek için kullanacağımız şeyler.
public class Main{
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //yeni bir nesne oluşturduk
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // belge oluşturucu türü nesneyi döndürecek
        DocumentBuilder builder=factory.newDocumentBuilder();
        //DocumentBuilderFactory ve DocumentBuilder soyut sınıfları xml dosyasını okumak için
        //xml dosyasına doğrudan iletebiliriz,veya xml dosya konumunu belirleriz.
        //parse metotları ile dosya kaynağı belirtilir xml dosyası belleğe yüklenir.
        Document document = builder.parse(".\\src\\NumberPlan.xml");

        //DOM XML OKUMA
        // extract root node form xml doc
        //kök düğüm olan nesnenin öğe türünü döndürür
        //kök ögeyi yakalarız ve bu kök ögeyi kullanarak tüm alt düğümleri yakalamamız gerekir
        Element root =document.getDocumentElement();
        //root kökü yardımıyla alt düğümşeri çıkartmamız gerekir.
        //getch alt düğümleri döndürür
        NodeList nodeList = root.getChildNodes();
        //buraya kadar tüm alt düğümleri kök ögeden çıkarttık şimdi her bir alt ögeyi okumamız gerekir.
        //ve sonra her alt düğümden tüm etiketleri ve içerikleri çıkarmak gerekir.
        //nodeList ile düğümleri yakaladık ama kaç tane düğüm olduğunu getLength ile saydık.
        for(int i=0; i<nodeList.getLength();i++){
            //sıfıra değer veriyorum ilk düğümü aldık ve bu belirli düğümden her bir etiketi çıkarmam gerekiyor
            Node node =nodeList.item(i);
            //eğer belirli düğüm nokta düğüm türünü alıyorsa etiketini alıcağız verileri çıkartacğız
            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                //eğer düğüm belirli düğüme özellikleri aynıysa gibi bişi o zaman alcağımız elementtir diyoruz
                Element element =(Element) node;
                //koşulu sağlıyorsa etiketlerine bakarız artık sağlamıyorsa aradığımız düğüm değildir bakmayacağız
                String tagName=element.getTagName();
                //öncelikle etiketleri adlandırdık şimdi bu etiket adını kullanarak verileri çıkartacağız
                //etiket adını çıkardığımız ögeden metin içeriği ögesi çıkartacağız metin içeriği alınır.
                //tamamını yazdıddır
                // String textContent=element.getTextContent();
                //dize dize metin içeriğini aldık
                String CompanyName=element.getElementsByTagName("CompanyName").item(0).getTextContent();
                String Route=element.getElementsByTagName("Route").item(0).getTextContent();
                String NDC=element.getElementsByTagName("NDC").item(0).getTextContent();
                String Prefix=element.getElementsByTagName("Prefix").item(0).getTextContent();
                String Size=element.getElementsByTagName("Size").item(0).getTextContent();
                //yazdır
                System.out.println("Tag Name:"+ tagName);
                //System.out.println("Text content:"+textContent);
                System.out.println("CompanyName:"+CompanyName);
                System.out.println("Route:"+Route);
                System.out.println("NDC:"+NDC);
                System.out.println("Prefix:"+Prefix);
                System.out.println("Size:"+Size);
            }
        }
    }
}