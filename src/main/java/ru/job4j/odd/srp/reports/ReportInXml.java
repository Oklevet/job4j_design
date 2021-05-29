package ru.job4j.odd.srp.reports;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportInXml {
    private final Store store;

    public ReportInXml(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) throws JAXBException {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(employee, writer);
                text.append(writer.getBuffer().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text.toString();
    }
}
