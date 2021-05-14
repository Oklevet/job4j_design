package ru.job4j.ODD;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.ODD.tdd.Account;
import ru.job4j.ODD.tdd.Cinema;
import ru.job4j.ODD.tdd.Ticket;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {
    Map<String, String> map = new HashMap<>();

    @Before
    String key1 = "key1001";
    String key2 = "key1002";
    String key3 = "key1003";
    map.put(key1, "qwe");
    map.put(key2, "asd");
    map.put(key3, "zxc");

    public String[] findKey(String str) {
        StringBuilder[] arr = new StringBuilder[2];
        int indx = str.indexOf('$');
        if(str.charAt(indx + 1) == '{') {
            int lastIndx = str.indexOf('}', indx + 1);
            if(lastIndx != -1) {
                StringBuilder builder = new StringBuilder();
                builder.append(str.substring(0, indx - 1));
                try {
                    arr[1] = builder.append(map.get(str.substring(indx + 2, lastIndx - 1)));
                    StringBuilder sbldr = new StringBuilder(String.valueOf(lastIndx));
                    arr[0] = sbldr;
                } catch (NullPointerException e) {
                    throw new NullPointerException();
                }
            }
        }
        return null;
    }

    @Test
    public void produceValid() {
        String enough = "variant 1";
        StringBuilder expected = new StringBuilder("qwe");
        StringBuilder sb = new StringBuilder();
        while(enough.length() > 0) {
            String[] temp = findKey(enough);
            if (temp.equals(null)) {
                sb.append(enough);
            } else {
                sb.append(temp[1]);
                enough.substring(Integer.parseInt(temp[0]));
            }
        }
        assertThat(expected, is(sb));
    }

    @Test
    public void produceValidMapBigger() {
        String enough = "variant 1";
        int howManyMapBiggerThanNeed = 3;
        int count = 0;
        StringBuilder expected = new StringBuilder("qwe");
        StringBuilder sb = new StringBuilder();
        while(enough.length() > 0) {
            String[] temp = findKey(enough);
            if (temp.equals(null)) {
                sb.append(enough);
            } else {
                sb.append(temp[1]);
                count++;
                enough.substring(Integer.parseInt(temp[0]));
            }
        }
        assertThat(howManyMapBiggerThanNeed, is(map.size() - count));
    }

    @Test(expected = NullPointerException.class)
    public void produceInvalidMapLesser() {
        String enough = "variant 1";
        StringBuilder expected = new StringBuilder("qwe");
        StringBuilder sb = new StringBuilder();
        while(enough.length() > 0) {
            String[] temp = findKey(enough);
            if (temp.equals(null)) {
                sb.append(enough);
            } else {
                sb.append(temp[1]);
                enough.substring(Integer.parseInt(temp[0]));
            }
        }
    }
}