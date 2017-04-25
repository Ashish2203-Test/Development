package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2/12/17.
 */

@Component
public class MessagePrinter{

    final private MessageService messageService;

    @Autowired
    public MessagePrinter(MessageService messageService){
        this.messageService=messageService;
    }

    public void printMessage(){
        System.out.println(messageService.getMessage());
    }

}
