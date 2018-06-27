package org.javacodegeeks.springintegration.channels.directchannel.pub;

import org.javacodegeeks.springintegration.channels.directchannel.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Librarian {

    private DirectChannel channel;

    @Value("#{bookChannel}")
    public void setChannel(DirectChannel channel) {
        this.channel = channel;
    }

    public void sendPremiumReaders(Book book) {     
        System.out.println("Dear Premium Reader, Just Arrived - " + book.toString());
        channel.send(MessageBuilder.withPayload(book).build());
    }
}
