package ru.job4j.io.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "contact")
public class ContactXml {

    @XmlAttribute
    private String phone;

    public ContactXml() {

    }

    public ContactXml(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}