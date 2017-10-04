package org.cba.ca2.client.gui;

import org.cba.ca2.client.MessageHandler;

import javax.swing.*;

/**
 * Created by adam on 03/10/2017.
 */
public class GuiMessageHandler implements MessageHandler {
    private final ChatBoxInput chatBoxInput;
    private final JComboBox<String> clientsSelectBox;

    public GuiMessageHandler(ChatBoxInput chatBoxInput, JComboBox clientsSelectBox) {
        this.chatBoxInput = chatBoxInput;
        this.clientsSelectBox = clientsSelectBox;
    }

    @Override
    public void handleIncomingMessage(String sender, String message) {
        System.out.println(message);
        chatBoxInput.printLineToChatBox(sender,message);
    }

    @Override
    public void handleEndConnection() {
        chatBoxInput.printLineToChatBox("server","done");
    }

    @Override
    public void handleClientListChange(String[] clientList) {
        clientsSelectBox.removeAllItems();
        for (String s : clientList) {
            clientsSelectBox.addItem(s);
        }
        clientsSelectBox.addItem("*");
        System.out.println(clientList);
    }
}
