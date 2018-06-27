package org.javacodegeeks.springintegration.channels.directchannel;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import org.javacodegeeks.springintegration.channels.directchannel.model.Book;
import org.javacodegeeks.springintegration.channels.directchannel.incoming.BookPublisher;
import org.javacodegeeks.springintegration.channels.directchannel.pub.Librarian;
import org.javacodegeeks.springintegration.channels.directchannel.sub.PremiumReader;

@SpringBootApplication
@ComponentScan(basePackages = "org.javacodegeeks.springintegration.channels.directchannel")
public class DirectchannelApplication {

    @Autowired
    private BookPublisher bookPublisher;
    
    @Autowired
    private Librarian librarian;
    
    @Autowired
    private DirectChannel library;
     
//    P2P Channel
    @Bean
    public MessageChannel bookChannel() {
        return new DirectChannel();
    }
//  
//    P-SB Channel
//    
//    @Bean
//    public MessageChannel pubSubFileChannel() {
//        return new PublishSubscribeChannel();
//    }
//     
//    @Bean
//    @InboundChannelAdapter(value = "pubSubFileChannel", poller = @Poller(fixedDelay = "1000"))
//    public MessageSource<File> fileReadingMessageSource() {
//        FileReadingMessageSource sourceReader = new FileReadingMessageSource();
//        sourceReader.setDirectory(new File(INPUT_DIR));
//        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
//        return sourceReader;

    
	public static void main(String[] args) {
		SpringApplication.run(DirectchannelApplication.class, args);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            library.subscribe(new PremiumReader());
            library.subscribe(new PremiumReader());
            library.subscribe(new PremiumReader());
            
		    List<Book> books = bookPublisher.getBooks();  

            for (Book book : books) {
                librarian.sendPremiumReaders(book);
            }
	    };
    }
}

/*
 * @Bean
	@BridgeFrom(value = "pubSubFileChannel")
	public MessageChannel fileChannel1() {
	    return new DirectChannel();
	}
	 
	@Bean
	@BridgeFrom(value = "pubSubFileChannel")
	public MessageChannel fileChannel2() {
	    return new DirectChannel();
	}
	 
	@Bean
	@BridgeFrom(value = "pubSubFileChannel")
	public MessageChannel fileChannel3() {
	    return new DirectChannel();
	}
 */
