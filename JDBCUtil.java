import java.sql.Connection;
import java.sql.*;

//import java.sql.*;
//
//class JDBCUtil {
//    public static final String url = "jdbc:mysql://localhost:3306/carinfo";
//    public static final String name = "com.mysql.jdbc.Driver";
//    public static final String user = "root";
//    public static final String password = "";
//    public static Connection conn = null;
//
//    public void DBHelper() {
//        try {
//            Class.forName(name);
//            conn = DriverManager.getConnection(url, user, password);
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM msg2 WHERE VINID LIKE '-%'");
//            while (rs.next()) {
//
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void close() {
//        try {
//            this.conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//
//
//    }
//}
//
class JDBCUtil {
    public static void main(String[] args) {
        JDBCUtil db = new JDBCUtil();

        //添加
        db.addMember("公立政","123456","123456");

        //增加字段
        db.add_field();
        //删除用户
        db.delete_user("公立政");
        //修改用户数据
        db.update("new刘超", 1);
    }
    public Connection getConnection() throws Exception {

        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/hello/practice";//连接数据库的URL地址

        String username = "root";//连接数据库的用户名

        String password = "";//连接数据库的密码

        String driver = "com.mysql.jdbc.Driver";

        //加载驱动，然后再实例化驱动对象

        Class.forName(driver).newInstance();

        //建立连接对象

        conn = DriverManager.getConnection(url, username, password);

        return conn;

    }

    public void addMember(String username, String password, String mail) {
        try {
            Connection con = this.getConnection();
            //定义SQL语句
            String sql = "insert into user(username,password,mail) values(?,?,?)";
            //获取预编译SQL执行对象，同时检测数据库中是否已经存在该SQL语句，如果存在，不存入SQL语句，如果不存在则存入ＳＱＬ语句
            PreparedStatement insert = con.prepareStatement(sql);

            //给每一个？占位符指定数据
            insert.setString(1, username);
            insert.setString(2, password);
            insert.setString(3, mail);

            int count = insert.executeUpdate();//执行并记录次数

            if (count > 0) {
                System.out.println("插入数据成功！影响的记录条数是" + count);
            } else {
                System.out.println("插入数据失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add_field() {
        try {
            Connection con = this.getConnection();
            //定义SQL语句
            String sql = "alter table user add sex boolean";
            //获取预编译SQL执行对象，同时检测数据库中是否已经存在该SQL语句，如果存在，不存入SQL语句，如果不存在则存入ＳＱＬ语句
            PreparedStatement pstmt = con.prepareStatement(sql);

            int count = pstmt.executeUpdate();//执行并记录次数

            //判断如何执行成功？pstmt.executeUpdate();只返回被影响行数 count=0;
             if(count>0){
                 System.out.println("添加字段成功！影响的记录条数是"+count);
             }else{
                 System.out.println("添加字段失败！"+count);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String username, int id) {
        try {

            Connection con = this.getConnection();
            //定义SQL语句
            String sql = "update user set username = ? where id = ?";
            //获取预编译SQL执行对象，同时检测数据库中是否已经存在该SQL语句，如果存在，不存入SQL语句，如果不存在则存入ＳＱＬ语句
            PreparedStatement pstmt = con.prepareStatement(sql);
            //给每一个？占位符指定数据
            pstmt.setString(1, username);
            pstmt.setInt(2, id);

            int count = pstmt.executeUpdate();//执行并记录次数

            if (count > 0) {
                System.out.println("修改数据成功！影响的记录条数是" + count);
            } else {
                System.out.println("修改数据失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete_user(String username) {
        try {
            Connection con = this.getConnection();
            //定义SQL语句
            String sql = "delete from user where username = ?";
            //获取预编译SQL执行对象，同时检测数据库中是否已经存在该SQL语句，如果存在，不存入SQL语句，如果不存在则存入ＳＱＬ语句
            PreparedStatement pstmt = con.prepareStatement(sql);

            //给每一个？占位符指定数据
            pstmt.setString(1, username);

            int count = pstmt.executeUpdate();//执行并记录次数

            if (count > 0) {
                System.out.println("删除数据成功！影响的记录条数是" + count);
            } else {
                System.out.println("删除数据失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}











//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//public class JDBCUtil {
//    static{
//        //加载JDBC驱动程序
//       try{
//           String diverName= "com.mysql.cj.jdbc.Driver";
//           //com.mysql.jdbc.Driver 是 mysql‐connector‐java 5中的，com.mysql.cj.jdbc.Driver 是 mysql‐connector‐java 6以上的
//           Class.forName(diverName);
//       }catch (Exception e){
//           e.printStackTrace();
//       }
//    }
//    public static Connection getConnection(){
//        //创建数据库连接
//          Connection con = null;
//          try {
//              con = DriverManager.getConnection("jdbc:mysql://localhost/redrock"+"?serverTimezone=GMT%2B8","root","");
//              //北京时间东八区，时区要设置好，不然会出现时差}
//                catch (Exception e)
//              {
//                  e.printStackTrace();
//              }
//              return con;
//          }
//          public static void close(ResultSet rs, Statement statement,Connection con){
//              //关闭数据库连接
//              try {
//                  if (rs != null)rs.close();
//              }catch (Exception ex){
//                  ex.printStackTrace();
//              }
//              try {
//                  if (statement != null)statement.close();
//              }catch (Exception ex){
//                  ex.printStackTrace();
//              }try{
//                  if (con != null)con.close();
//              }catch (Exception ex){
//                  ex.printStackTrace();
//              }
//       }
//    }
//    }