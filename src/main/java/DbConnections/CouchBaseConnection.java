package DbConnections;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

import java.util.function.Supplier;

public class CouchBaseConnection  implements  DatabaseConnections {

    private DbConnectionHelper dbConnectionHelper;
    CouchBaseConnection(DbConnectionHelper dbConnectionHelper)
    {
        this.dbConnectionHelper =dbConnectionHelper;

    }


    @Override
    public void  connect() {

        Cluster cluster = CouchbaseCluster.create();

       cluster.openBucket();


    }
}
