package com.company;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateXml {
    protected Element theRoot;
    private Document doc;
    private final XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());;

    public void createDoc(String rootElName){
        Document doc = new Document();
        theRoot = new Element(rootElName);
        doc.setRootElement(theRoot);
    }

    public void addEl(String elName,Element parrentEl){
        Element elVar = new Element(elName);
        parrentEl.addContent(elVar);
    }

    public void addAtribute(Element element,String atrName,
                            String atrValue){
        element.setAttribute(atrName,atrValue);
    }

    public void addContent(Element element,String text ){
        element.addContent(new Text(text));
    }

    public void saveDoc(String fileName){
        try {
            xmlOutputter.output(doc, new FileOutputStream(
                    new File("./src/" + fileName + ".xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
