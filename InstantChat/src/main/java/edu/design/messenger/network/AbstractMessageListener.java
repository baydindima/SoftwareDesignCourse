package edu.design.messenger.network;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

/**
 * Class for listening message through socket.
 */
@Slf4j
@AllArgsConstructor
public class AbstractMessageListener {

    @NotNull
    private final Consumer<Message.TextMessage> messageCallback;

    protected void processMessage(@NotNull final InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String nick = dataInputStream.readUTF();
        String text = dataInputStream.readUTF();
        Message.TextMessage textMessage = Message.TextMessage.newBuilder().setText(text).setNick(nick).build();
        messageCallback.accept(textMessage);
    }


}
