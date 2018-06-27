package org.javacodegeeks.springintegration.channels.directchannel.sub;

import org.javacodegeeks.springintegration.channels.directchannel.model.Book;
import org.springframework.messaging.Message;
import org.springframework.integration.MessageRejectedException;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

@Component
public class PremiumReader implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        Object payload = message.getPayload();

        if (payload instanceof Book) {
            receiveAndAcknowledge((Book) payload);
        } else {
            throw new MessageRejectedException(message, "Unknown data type has been received.");
        }
    }

    void receiveAndAcknowledge(Book book) {
        System.out.println("Hi Librarian, this is Reader #" + System.identityHashCode(this) + 
                           ". " + "Received book - " + book.toString() + "\n");
    }
}
