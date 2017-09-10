package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Normalizer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Main {
    public static void main(String[] args) {
        writeXML();
        readXML();
    }

    private static void writeXML (){

        try {

            Document doc = new Document();
            Element theRoot = new Element("tvshows");
            doc.setRootElement(theRoot);


            //show1
            Element show = new Element("show");


            Element name = new Element("name");
            name.setAttribute("show_id", "show_001");
            name.addContent(new Text("Life on Mars "));

            Element network = new Element("network");
            network.setAttribute("country", "US");
            network.addContent(new Text("ABC"));

            show.addContent(name);
            show.addContent(network);

            theRoot.addContent(show);

            // -----------------
            ///show 2


            Element show2 = new Element("show");


            Element name2 = new Element("name");
            name2.setAttribute("show_id", "show_001");
            name2.addContent(new Text("Life on Mars "));

            Element network2 = new Element("network");
            network2.setAttribute("country", "US");
            network2.addContent(new Text("ABC"));

            show2.addContent(name2);
            show2.addContent(network2);

            theRoot.addContent(show2);

            ///-----Theater-----///

            Element theater = new Element("theater");

            Element theaterName = new Element("theaterName");
            theaterName.setAttribute("attr1","attr1_val");
            theaterName.addContent(new Text("SleepingBeauty"));


            Element theaterTime = new Element("theaterTime");
            theaterTime.setAttribute("attr2","attr2_val");
            theaterTime.addContent(new Text("16:00"));

            theater.addContent(theaterName);
            theater.addContent(theaterTime);

            theRoot.addContent(theater);

            //////----theater----/////////

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(doc, new FileOutputStream(
                    new File("./src/jdomMade.xml")));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    private static void readXML (){
        SAXBuilder builder = new SAXBuilder();
            Document readDoc = null;
            try {
                readDoc = builder.build(
                        new File("./src/jdomMade.xml"));
            } catch (JDOMException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Root: " + readDoc.getRootElement());

            System.out.println("Show : " + readDoc.getRootElement().
                    getChild("show").getChildText("name"));

            System.out.println("Show ID : " + readDoc.getRootElement().
                    getChild("show").getChild("name").
                        getAttributeValue("show_id") + "\n");

            Element root = readDoc.getRootElement();

            for (Element curEle : root.getChildren("show")){

                System.out.println("show name : " +
                        curEle.getChildText("name"));

                System.out.println("show ID: " +
                        curEle.getChild("name").
                                getAttributeValue("show_id"));

                System.out.print("On  " +
                        curEle.getChildText("network") + " in the ");

                System.out.println(curEle.getChild("network").
                        getAttributeValue("country") + "\n");
            }

            Element e = readDoc.getRootElement().getChild("theater");
            System.out.println("Theater name : " + e.getChildText("theaterName"));
            System.out.println("Theater time : " + e.getChildText("theaterTime"));
        }


}

