package com.completablefuture;

import java.util.function.Supplier;

public class MakesANetworkCall implements Supplier {
    @Override
    public Object get() {
        try {
            System.out.println("Ground control to Major Tom");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//            int i = 2/0;
        return new String("Major Tom reporting!");
    }
}
