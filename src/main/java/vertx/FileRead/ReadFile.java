package vertx.FileRead;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import reactor.core.publisher.Mono;

import java.util.List;

public class ReadFile {

    public static void main(String[] args) {

        Future<String>  future=readFile();

        future.setHandler(ar -> {
           if(ar.succeeded())
         {

             System.out.println("succesful     "+ar.result());
        }
           else {
               System.out.println("failed      "+ar.cause());
           }
        });

    }


    public static Future<String> readFile()
    {

        Future<String> future =Future.future();

        Vertx.vertx().fileSystem()
                .readFile("src/main/resources/example03/read.txt" ,
                        ar-> {
                            if (ar.succeeded()) {
                              //  System.out.println("read content" + ar.result());
                               future.complete(ar.result().toString());
                            } else {
                              //  System.out.println("read failed");
                                future.fail(ar.cause());
                            }

                        });

          return future;



    }
}
