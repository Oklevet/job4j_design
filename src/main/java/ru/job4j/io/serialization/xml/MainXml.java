package ru.job4j.io.serialization.xml;

import ru.job4j.io.Contact;

import javax.xml.bind.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class MainXml {
    public static void main(String[] args) throws IOException, JAXBException {
        PersonXmlToPojo person = new PersonXmlToPojo(false, 30, new Contact("11-111"), "Worker", "Married");
        JAXBContext context = JAXBContext.newInstance(PersonXmlToPojo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            PersonXmlToPojo result = (PersonXmlToPojo) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}
