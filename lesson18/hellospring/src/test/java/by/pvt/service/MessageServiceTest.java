package by.pvt.service;

import by.pvt.cmd.SendMessageCmd;
import by.pvt.component.Channel;
import by.pvt.main.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @Test(expected = NullPointerException.class)
    public void executeCommand() {
        System.out.println(messageService);

        messageService.executeCommand(null);
    }

    @Test(expected = NullPointerException.class)
    public void executeCommand2() {
        System.out.println(messageService);

        messageService.executeCommand(new SendMessageCmd(
                null, null, null
        ));
    }

    @Test
    public void executeCommand3() {
        SendMessageCmd cmd = new SendMessageCmd(
                "Ivan Ivanov",
                MessageType.INVITATION_MESSAGE,
                Channel.EMAIL
        );
        messageService.executeCommand(cmd);
    }
}