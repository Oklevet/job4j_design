package ru.job4j.odd.srp.reports;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenProgGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineProg(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() + ";"
                + ".html"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenHRGenerated() {
        MemStoreHR store = new MemStoreHR();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportEngineHR(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker2.getName() + ";"
                + worker2.getSalary() + ";"
                + System.lineSeparator()
                + worker1.getName() + ";"
                + worker1.getSalary() + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenBookKeepGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineBookkeep(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() / 76 + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenOldGeneratedXML() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        ZoneOffset zoneOffset = ZoneOffset.of("+05:00");
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportInXml xml = new ReportInXml(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<employee name=\"Ivan\" hired=\"" + now.toInstant().atOffset(zoneOffset)
                + "\" fired=\"" + now.toInstant().atOffset(zoneOffset) + "\" salary=\"100.0\"/>\n";
        assertThat(xml.generate(employee -> true), is(expect));
    }

    @Test
    public void whenOldGeneratedJSON() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        String nowExpect = "{\"year\":" + now.getWeekYear() + ",\"month\":" + now.getTime().getMonth()
                + ",\"dayOfMonth\":" + now.getTime().getDate() + "," + "\"hourOfDay\":"
                + now.getTime().getHours() + ",\"minute\":" + now.getTime().getMinutes()
                + ",\"second\":"  + now.getTime().getSeconds() + "}";
        ReportToJSON json = new ReportToJSON(store);
        String expect = "{\"store\":{\"employees\":[{\"name\":\"Ivan\",\"hired\":"
                + nowExpect + ",\"fired\":" + nowExpect
                + ",\"salary\":100.0}]}}";
        assertThat(json.generate(employee -> true), is(expect));
    }
}