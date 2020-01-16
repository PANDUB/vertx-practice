package DbConnections;

public class DbConnectionFactory {


    public DatabaseConnections  getConnection(String type,DbConnectionHelper dbConnectionHelper){

        DatabaseConnections databaseConnections;

        switch (type){

            case "Couchbase" :
                databaseConnections= new CouchBaseConnection(dbConnectionHelper);
                break;
            case "Cassandra" :
                databaseConnections= new CassandraConnection(dbConnectionHelper);
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return databaseConnections;
    }
}
