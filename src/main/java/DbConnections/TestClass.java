package DbConnections;

public class TestClass {


    public static void main(String[] args) {


        DbConnectionHelper  dbConnectionHelper =new DbConnectionHelper.Builder("localhost","200").setNodes("20")
                .build();

        DatabaseConnections  databaseConnections= new DbConnectionFactory().getConnection("Cassandra",dbConnectionHelper);

        databaseConnections.connect();



    }
}
