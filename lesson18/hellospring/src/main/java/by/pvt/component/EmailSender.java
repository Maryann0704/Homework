package by.pvt.component;

import by.pvt.pojo.Message;

public interface EmailSender {

    public static final String EMAIL_CHANNEL = "EMAIL";
    void send(Message message);
}
