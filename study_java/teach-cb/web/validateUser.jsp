<%@ page import="java.sql.*" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String driver = "com.mysql.cj.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai";
    String dbUser = "root";
    String dbPwd = "root@123";
    try {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        Statement st = conn.createStatement();
        CallableStatement cs = conn.prepareCall("{call validateUser(?,?)}");
        String username = request.getParameter("username");
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line);
            out.println("<br />");
        }

        cs.setString(1, username);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.executeQuery();
        int affected = cs.getInt(2);
        out.println(affected);
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }


//    Class.forName(driver);
//    Connection conn = DriverManager.getConnection(dbuRL, user, null);
//    Statement st = conn.createStatement();
//    CallableStatement cs = conn.prepareCall("{call validateUser(?,?)}");
//    String username=request.getParameter("username");

//        BufferedReader reader=request.getReader();
//        String line;
//        while((line=reader.readLine())!=null){
//            out.println(line);
//            out.println("<br/>");
//        }

//    cs.setString(1, username);
//    cs.registerOutParameter(2, Types.INTEGER);
//    cs.executeQuery();
//    int affected = cs.getInt(2);
//    out.print(affected);
%>