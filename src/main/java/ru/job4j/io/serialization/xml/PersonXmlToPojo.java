package ru.job4j.io.serialization.xml;

import ru.job4j.io.Contact;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)

public class PersonXmlToPojo {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private Contact contact;

    private String[] statuses;

    public PersonXmlToPojo() { }

    public PersonXmlToPojo(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
   }

    public static void main(String[] args) throws JAXBException {
        final PersonXmlToPojo person = new PersonXmlToPojo(false, 30, new Contact("11-111"), "Worker", "Married");

        JAXBContext context = JAXBContext.newInstance(PersonXmlToPojo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}