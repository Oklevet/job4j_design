package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

     public static void main(String[] args) {
         byte quanity = 32;
         short num = 2435;
         int age = 33;
         long sum = 412414;
         float flof = 321.4f;
         double dlod = 41414.532d;
         char charec = 'q';
         boolean flag = true;
         LOG.debug("User info quanity : {}, num : {}, age : {}, sum : {},"
                 + " flof : {}, dlod : {}, charec : {}, flag : {},", quanity, num,
                 age, sum, flof, dlod, charec, flag);
    }
}
