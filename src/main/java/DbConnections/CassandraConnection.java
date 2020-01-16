package DbConnections;

//import com.datastax.driver.core.Cluster;
//import com.datastax.driver.core.Session;

import java.util.function.Supplier;

public class CassandraConnection  implements  DatabaseConnections {

    private DbConnectionHelper dbConnectionHelper;
    public CassandraConnection(DbConnectionHelper dbConnectionHelper)
    {
        this.dbConnectionHelper=dbConnectionHelper;
    }



    @Override
    public void  connect() {

//        Cluster cluster = Cluster.builder()
//                .addContactPoints(dbConnectionHelper.getServerIp())
//                .build();
//
//        Session session = cluster.connect(dbConnectionHelper.getKeyspace());


    }
}
