package com.reactor;




import java.util.concurrent.CompletableFuture;

//import static org.antlr.tool.ErrorManager.assertTrue;

public class MonoOne {
    public static void main(String[] args) {
        CompletableFuture<String>  completableFuture
                =CompletableFuture.completedFuture("message");

       // assertTrue(completableFuture.isDone(),"message");
        //assertEquals("message", completableFuture.getNow(null));
        //System.out.println("completableFuture.isDone()"+completableFuture.isDone());



//        completableFuture.whenComplete((res,err) ->
//        {
//            if(err == null)
//            {
//                System.out.println("error"+ err);
//            }
//           else if(res == null)
//            {
//                System.out.println("error ******"+ res);
//            }
//        });
    }
}
