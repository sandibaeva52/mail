package com.example.mail;

public class DataModel {
private static final Mails[] mailList={
        new Mails("Assem Sandibayeva", "Some text","12:03"),
         new Mails("Aigerim Kaimakova", "Some text","13:30"),
        new Mails("Aktoty Saubayeva", "Some text","14:20"),
        new Mails("Aktoty Saubayeva", "Some text","15:20"),
        new Mails("Aktoty Saubayeva", "Some text","18:20"),
        new Mails("Aktoty Saubayeva", "Some text","20:20"),
        new Mails("Aktoty Saubayeva", "Some text","8:20"),
        new Mails("Aktoty Saubayeva", "Some text","8:47"),
        new Mails("Assem Sandibayeva", "Some text","12:53"),

};

public static Mails[] getMailList(){
    return mailList;
}


}
