package ru.job4j.io;

import java.io.*;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String phone;

    public Contact(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) {
        Contact contact = new Contact("05300158392");
        try (FileOutputStream fos = new FileOutputStream("./src/data/tempServer.out")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contact);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream("./src/data/tempServer.out")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println("result = " + ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}