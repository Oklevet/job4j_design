package ru.job4j.collection.examination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EmailTest {

     @Test
     public void orderValid() throws WrongFormatEmailsException {
          String path = "src/data/emails.properties";
          String pathEx = "src/data/emailsEtalon.properties";
          Email email = new Email(path);
          List<Record> expected = new ArrayList<>(new GetProperty(pathEx).loadEtalon());
          Email.union(email.emails);
          int count = 0;
          for (int i = 0; i < email.emails.size(); i++) {
               if (email.emails.get(i).getSet().size() != 0) {
                    assertEquals(expected.get(count).getSet(), email.emails.get(i).getSet());
                    count++;
               }
          }
     }

     @Test
     public void notOrderValid() throws WrongFormatEmailsException {
          String path = "src/data/emails_hard.properties";
          String pathEx = "src/data/emails_hardEtalon.properties";
          Email email = new Email(path);
          List<Record> expected = new ArrayList<>(new GetProperty(pathEx).loadEtalon());
          Email.union(email.emails);
          int count = 0;
          for (int i = 0; i < email.emails.size(); i++) {
               if (email.emails.get(i).getSet().size() != 0) {
                    assertEquals(expected.get(count).getSet(), email.emails.get(i).getSet());
                    count++;
               }
          }
     }

     @Test(expected = WrongFormatEmailsException.class)
     public void invalidFormat() throws WrongFormatEmailsException {
          String path = "src/data/app.properties";
          String pathEx = "src/data/emails_hardEtalon.properties";
          Email email = new Email(path);
     }

     @Test(expected = WrongFormatEmailsException.class)
     public void invalidEmptyList() throws WrongFormatEmailsException {
          String path = "src/data/app.properties";
          String pathEx = "src/data/emails_hardEtalon.properties";
          Email email = new Email(path);
     }

     @Test
     public void orderValidTwo() throws WrongFormatEmailsException {
          String path = "src/data/emailTwo.properties";
          String pathEx = "src/data/emailTwoEtalon.properties";
          Email email = new Email(path);
          List<Record> expected = new ArrayList<>(new GetProperty(pathEx).loadEtalon());
          Email.union(email.emails);
          int count = 0;
          for (int i = 0; i < email.emails.size(); i++) {
               if (email.emails.get(i).getSet().size() != 0) {
                    assertEquals(expected.get(count).getSet(), email.emails.get(i).getSet());
                    count++;
               }
          }
     }
}