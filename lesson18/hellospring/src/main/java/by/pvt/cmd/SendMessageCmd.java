package by.pvt.cmd;

import by.pvt.service.MessageType;

public class SendMessageCmd {

    public final String receiverName;

    public final MessageType messageType;

    public final Enum channel;

    public SendMessageCmd(String receiverName, MessageType messageType, Enum channel) {
        this.receiverName = receiverName;
        this.messageType = messageType;
        this.channel = channel;
    }
}
