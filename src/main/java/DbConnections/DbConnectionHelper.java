package DbConnections;

public class DbConnectionHelper {

    private String serverIp;
    private String keyspace;
    private String  nodes;

    public String getKeyspace() {
        return keyspace;
    }

    public String getNodes() {
        return nodes;
    }
    public String getServerIp() {
        return serverIp;
    }



    public DbConnectionHelper(Builder builder){

        this.keyspace=builder.keyspace;
        this.nodes=builder.nodes;;
        this.serverIp=builder.serverIp;;

    }

    public static class Builder {

        private String serverIp;

        private String keyspace;

        private String  nodes;

         public  Builder(String serverIp,String keyspace)
         {
             this.serverIp = serverIp;
             this.keyspace=keyspace;

         }

        public Builder  setNodes(String nodes) {
            this.nodes=nodes;
           return this;
        }

        public DbConnectionHelper  build(){


            return new DbConnectionHelper(this);
        }
    }

}
