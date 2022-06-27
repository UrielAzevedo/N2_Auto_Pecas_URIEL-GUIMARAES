package com.pecas.n2_auto_pecas_urielguimaraes.DAO;
import java.sql.*;

public abstract class PostgresqlDAO {
    protected static String ENDERECO = "localhost";
    protected static String BD = "AutoPecas";
    protected static String PORTA = "5432";
    protected static String USUSARIO = "postgres";
    protected static String SENHA = "postgres";

    protected Connection getConexao() throws SQLException {

        String url = "jdbc:postgresql://" + ENDERECO + ":" + PORTA + "/" + BD;
        Connection connection = DriverManager.getConnection(url, USUSARIO, SENHA);

        return connection;
    }

    protected PreparedStatement getPreparedStatement (String sql, Boolean insercao) throws Exception {
        PreparedStatement preparedStatement = null;

        if(insercao){
            return getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } else {
            return getConexao().prepareStatement(sql);
        }
    }
}
