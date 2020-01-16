import com.messages.internal.CustomerMessage;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        ConsumerExample  consumerExample =new ConsumerExample();

        consumerExample.acceptConsumer(x-> x.getId());


    }


    public void  acceptConsumer(Consumer<CustomerMessage> consumer)
    {

        CustomerMessage customerMessage =new CustomerMessage();
        customerMessage.setAge(20);
        customerMessage.setId("1234");
        customerMessage.setName("hello");
        consumer.accept(customerMessage);


    }
}
