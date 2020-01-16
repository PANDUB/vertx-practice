package vertx.future;

import io.vertx.core.Future;

import java.util.ArrayList;
import java.util.List;

public class VertxFuture {

    public static <T> void main(String[] args) {

        Future<List<Integer>> future =gettask1();

      //  future.compose(gettask2()).setHandler( )


    }

    private static Future<List<Integer>> gettask1()
    {

        Future<List<Integer>>  future=Future.future();
        List<Integer>  lst = new ArrayList<>();
        for(int i= 0; i< 1000 ; i++)
        {

            lst.add(i);
        }

        future.complete(lst);
        return future;
    }
    private static Future<List<Integer>> gettask2()
    {

        Future<List<Integer>>  future=Future.future();
        List<Integer>  lst = new ArrayList<>();
        for(int i= 1000; i< 2000 ; i++)
        {

            lst.add(i);
        }

        future.complete(lst);
        return future;
    }
}
