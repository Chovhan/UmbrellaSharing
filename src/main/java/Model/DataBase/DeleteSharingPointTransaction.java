package Model.DataBase;

import Model.Objects.SharePointInformationDataTransfer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class DeleteSharingPointTransaction {

    private static final Logger logger = Logger.getLogger(DeleteUmbrellaTransaction.class);

    public void deleteSharePoint(int sharePointNumber) {
        Savepoint savepoint = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("delete umbrella sharing savepoint");

            deleteSharePointFromDb(connection, sharePointNumber);

            connection.commit();
            connection.close();
            logger.info("share point was deleted");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(savepoint);
                    connection.releaseSavepoint(savepoint);
                } catch (SQLException ex) {
                    logger.error("Some problems with deleting share point " + ex.getMessage());
                }
            }
            logger.error("Some problems with deleting share point " + e.getMessage());
        }
    }

    private void deleteSharePointFromDb(Connection connection, int sharePointId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "delete from share_point where share_point_sequence_number = (?);");
        preparedStatement.setInt(1, sharePointId);
        preparedStatement.executeUpdate();
    }
}
