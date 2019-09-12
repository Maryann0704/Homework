package by.pvt.service;

import by.pvt.cmd.SendMessageCmd;
import by.pvt.component.EmailSender;
import by.pvt.pojo.Message;
import by.pvt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MessageService {

    public final static String FROM_EMAIL = "info@it-academy.by";

    @Autowired
    @Qualifier("myEmailSender")
    EmailSender emailSender;

    @Autowired
    UserRepository userRepository;

    public boolean executeCommand(SendMessageCmd cmd) {
        Message message = new Message();
        message.setFrom(FROM_EMAIL);
        message.setBody(cmd.messageType.getBody());
        message.setId(new Random().nextLong());
        message.setSubject(cmd.messageType.getSubject());
        message.setTo(userRepository.getEmailByUserName(cmd.receiverName));

        emailSender.send(message);
        return true;
    }
}
