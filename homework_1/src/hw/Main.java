package hw;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String path = "trainsList.txt";
        NodeList nodeList = getNodeList(path);
        Trains trains = getTrainsList(nodeList);
        trains.getTrains().stream()
                .filter(a -> checkDateDiapason(a.getDeparture(), "15:00"))
                .filter(a -> !checkDateDiapason(a.getDeparture(), "19:00"))
                .forEach(System.out::println);
    }

    //Проверка для Predicate
    public static boolean checkDateDiapason(String t1, String t2) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("HH:mm");
        Date date1 = new Date();
        Date date2 = new Date();
        try {
            date1 = format.parse(t1);
            date2 = format.parse(t2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1.compareTo(date2) > 0;
    }

    //Получить список поездов
    public static Trains getTrainsList(NodeList nodeList) {
        Trains trains = new Trains();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            NodeList objList = nodeList.item(i).getChildNodes();
            Train train = new Train();
            train.setId(nodeList.item(i).getAttributes().getNamedItem("id").getTextContent());
            for (int j = 0; j < objList.getLength(); j++) {
                if (objList.item(j).getNodeName().equals("from")) {
                    train.setFrom(objList.item(j).getTextContent());
                }
                if (objList.item(j).getNodeName().equals("to")) {
                    train.setTo(objList.item(j).getTextContent());
                }
                if (objList.item(j).getNodeName().equals("date")) {
                    train.setDate(objList.item(j).getTextContent());
                }
                if (objList.item(j).getNodeName().equals("departure")) {
                    train.setDeparture(objList.item(j).getTextContent());
                }
            }
            trains.addTrain(train);
        }
        return trains;
    }

    //Получить список Node'ов и xml файла
    public static NodeList getNodeList(String path) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = dbf.newDocumentBuilder().parse(path);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return document.getDocumentElement().getChildNodes();
    }
}
