import com.google.inject.Guice;
import com.guicemodule.GuiceModule;
import com.verticles.CustomerEventLoop;
import com.verticles.CustomerWorker;
import com.verticles.EventBusVerticle;
import com.verticles.MainVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class Application {

    Vertx  vertx =Vertx.vertx();
    public static void main(String[] args) {

     Application app =new Application();

     app.start();


    }

    public    void  start() {
        Future<Boolean> future = Future.future();
         DeploymentOptions workeropt = new DeploymentOptions().setWorkerPoolSize(2).setWorker(true);
//         vertx.deployVerticle(new CustomerEventLoop(), res -> {
//                if (res.failed())
//                    res.cause().printStackTrace();
//            });

         vertx.deployVerticle(new MainVerticle(), res -> {
             if(res.succeeded())
             {
                 vertx.deployVerticle(new CustomerWorker(), workeropt);
                 vertx.deployVerticle(new EventBusVerticle());

                 System.out.println(" Main Verticle deployment successful");
             }
             if (res.failed())
                    res.cause().printStackTrace();
                 });
           // vertx.deployVerticle(new CustomerWorker(), workeropt);
            System.out.println(" deployment successful");



            // req.response().putHeader("aplication-type","json").end("Hello Akshith");









    }


}
