//
//class Main{
//    private String name;
//    private int age;
//    public Main(String name,int age){
//        this.name=name;
//        this.age=age;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;import java.sql.Statement;
//public class Main {
//    Connection con;
//    Statement statement;
//    ResultSet rs;
//    public Connection getCon() {
//        return con;
//    }
//}
//public Statement getStatement() {
//    return statement;
//}
//public ResultSet getRs() {
//    return rs;
//}
//public Main(Connection con) {
//    this.con = con;
//    try {
//        statement = con.createStatement();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//public void createTable() throws SQLException {
//    String sql = "create table if not exists test(id int,name varchar(100))"statement.executeUpdate(sql);
//}
//public void insert() throws SQLException {
//    String sql1 = "insert into test values(1,'tom')";
//    String sql2 = "insert into test values(2,'张三')";
//    String sql3 = "insert into test values(3,'999')";
//    statement.addBatch(sql1);
//    statement.addBatch(sql2);
//    statement.addBatch(sql3);
//    int[] results = statement.executeBatch();
//}
//public void select() throws SQLException {
//    String sql = "select id,name from test";
//    rs = statement.executeQuery(sql);
//    while (rs.next()) {
//        String id = rs.getString("id");
//        String name = rs.getString("name");
//        System.out.println(id+"\t"+name);
//    }
//}
//public static void main(String[] args) {
//    Connection con = JDBCUtil.getConnection();
//    Main main = new Main(con);
//    try {
//        main.createTable();
//        main.insert();main.select();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }finally {
//        JDBCUtil.close(main.getRs(),main.getStatement(),main.getCon());
//    }
//}



