import com.messages.internal.CustomerMessage;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierExample {


    public static void main(String[] args) {


      Supplier<CustomerMessage> customerMessage=() ->
              getCustomerMessage();


      printResult( customerMessage.get(),x->System.out.println(x.getAge()));



    }

    private static CustomerMessage getCustomerMessage() {
        CustomerMessage  customerMessage =new CustomerMessage();
        customerMessage.setAge(20);
        customerMessage.setId("1234");
        customerMessage.setName("hello");
        return customerMessage;
    }

    public static void  printResult(CustomerMessage  customerMessage, Consumer<CustomerMessage> consumer)


    {

        consumer.accept(customerMessage);


    }
}
