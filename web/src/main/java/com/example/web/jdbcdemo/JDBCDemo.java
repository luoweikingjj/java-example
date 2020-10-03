package com.example.web.jdbcdemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        // test();
        // practice();
        // resultSetDemo();
        // preparedStatementDemo();
        // transactionDemo();
        c3p0Demo();
    }

    /**
     * 测试
     */
    private static void test() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.10.10:3306/java-example", "homestead", "secret");

            String sql = "update account set balance = 500 where id = 1";
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 操作练习
     */
    private static void practice() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.10.10:3306/java-example", "homestead", "secret");

            String sql = "insert into account value (null, 10)";
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            if (count > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 结果集
     */
    private static void resultSetDemo() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.10.10:3306/java-example", "homestead", "secret");

            String sql = "select * from account";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double balance = resultSet.getDouble("balance");
                System.out.println(id + "|" + balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 预处理
     */
    private static void preparedStatementDemo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.10.10:3306/java-example", "homestead", "secret");

            String sql = "update account set balance = 100 where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "1");
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 事务
     */
    private static void transactionDemo() {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);

            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";

            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);

            preparedStatement1.setDouble(1, 5);
            preparedStatement1.setInt(2, 1);

            preparedStatement2.setDouble(1, 5);
            preparedStatement2.setInt(2, 2);

            preparedStatement1.executeUpdate();

            // 制造异常
            int i = 3 / 0;

            preparedStatement2.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            // 事务回滚
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement1, connection);
            JDBCUtils.close(preparedStatement2, null);
        }
    }

    /**
     * 数据库连接池-c3p0
     */
    private static void c3p0Demo() {
        try {
            // ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
            ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("otherc3p0");
            for (int i = 1; i <= 8; i++) { // 配置的线程池最多8个
                Connection connection = comboPooledDataSource.getConnection();
                System.out.println(i + ":" + connection);
                if (i == 5) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
