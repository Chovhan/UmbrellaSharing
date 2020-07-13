package Model.DataBase;

import Model.Objects.SharePoint;
import Model.Objects.SharePointInformationDataTransfer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class ChangeSharePointAvailabilityTransaction {

    private static final Logger logger = Logger.getLogger(ChangeUmbrellaPlaceInformation.class);

    public void changeAvailability(SharePoint sharePoint){
        Savepoint savepoint = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("add umbrella sharing savepoint");

            updateSharePointAvailability(sharePoint.getAvailability(), sharePoint.getSequenceNumber());

            connection.commit();
            connection.close();
            logger.info("share point availability was added");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(savepoint);
                    connection.releaseSavepoint(savepoint);
                } catch (SQLException ex) {
                    logger.error("Some problems with changing share point availability " + ex.getMessage());
                }
            }
            logger.error("Some problems with changing share point availability " + e.getMessage());
        }
    }

    private void updateSharePointAvailability(int availability, int number) throws SQLException {
        PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement("" +
                "Update share_point set share_point_availability = (?) where share_point_id = (?);");
        preparedStatement.setInt(1, availability);
        preparedStatement.setInt(2, number);
        preparedStatement.executeUpdate();
    }

}
