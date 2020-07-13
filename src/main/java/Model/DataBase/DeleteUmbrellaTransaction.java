package Model.DataBase;

import Model.Objects.UmbrellaInformation;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class DeleteUmbrellaTransaction {

    private static final Logger logger = Logger.getLogger(DeleteUmbrellaTransaction.class);

    public void deleteUmbrella(int number){
        Savepoint savepoint = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("delete umbrella savepoint");

            deleteUmbrellaFromDb(connection, number);

            connection.commit();
            connection.close();
            logger.info("umbrella instance was deleted");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(savepoint);
                    connection.releaseSavepoint(savepoint);
                } catch (SQLException ex) {
                    logger.error("Some problems with deleting umbrella instance " + ex.getMessage());
                }
            }
            logger.error("Some problems with deleting umbrella instance " + e.getMessage());
        }
    }

    private void deleteUmbrellaFromDb(Connection connection, int umbrellaId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "delete from umbrella_instance where umbrella_instance_sequance_number = (?);");
        preparedStatement.setInt(1, umbrellaId);
        preparedStatement.executeUpdate();
    }
}
