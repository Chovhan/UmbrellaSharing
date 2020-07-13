package Model.DataBase;

import Model.Objects.NewUmbrellaDataTransfer;
import org.apache.log4j.Logger;

import java.sql.*;

public class AddUmbrellaTransaction {

    private static final Logger logger = Logger.getLogger(AddUmbrellaTransaction.class);

    public void addUmbrella(NewUmbrellaDataTransfer newUmbrellaDataTransfer) {
        Savepoint savepoint = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("add umbrella sharing savepoint");

            System.out.println(getUmbrellaSequenceNumber(connection));
            System.out.println(getManufacturingId(connection, newUmbrellaDataTransfer.getManufacturerName(), newUmbrellaDataTransfer.getModelName()));
            insertNewUmbrella(connection, getManufacturingId(connection, newUmbrellaDataTransfer.getManufacturerName(), newUmbrellaDataTransfer.getModelName()), newUmbrellaDataTransfer.getSharePointId(), newUmbrellaDataTransfer.getUmbrellaAvailability(), getUmbrellaSequenceNumber(connection));

            connection.commit();
            connection.close();
            logger.info("umbrella was added");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(savepoint);
                    connection.releaseSavepoint(savepoint);
                } catch (SQLException ex) {
                    logger.error("Some problems with adding umbrella instance " + ex.getMessage());
                }
            }
            logger.error("Some problems with adding umbrella instance " + e.getMessage());
        }
    }

    private int getUmbrellaSequenceNumber(Connection connection) throws SQLException {
        int umbrellaSequenceNumber = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select max(umbrella_instance_sequance_number)+1 from umbrella_instance;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            umbrellaSequenceNumber += resultSet.getInt(1);
        }
        return umbrellaSequenceNumber;
    }

    private int getManufacturingId(Connection connection, String manufacturer, String umbrellaModel) throws SQLException {
        int manufacturingId = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select manufacturing_id from manufacturing " +
                "inner join manufacturer " +
                "on manufacturing.manufacturer_id = manufacturer.manufacturer_id " +
                "inner join umbrella_model " +
                "on manufacturing.umbrella_model_id = umbrella_model.umbrella_model_id " +
                "where umbrella_model_name = (?) and manufacturer_name = (?);");
        preparedStatement.setString(1, umbrellaModel);
        preparedStatement.setString(2, manufacturer);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            manufacturingId += resultSet.getInt(1);
        }
        return manufacturingId;
    }

    private void insertNewUmbrella(Connection connection, int manufacturingId, int sharePointId, int umbrellaAvailability, int umbrellaSequenceNumber) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "Insert into umbrella_instance(umbrella_instance_sequance_number, umbrella_availability, umbrella_share_point_id, umbrella_manufacturing_id) " +
                "values (?, ?, ?, ?)");
        preparedStatement.setInt(1, umbrellaSequenceNumber);
        preparedStatement.setInt(2, umbrellaAvailability);
        preparedStatement.setInt(3, sharePointId);
        preparedStatement.setInt(4, manufacturingId);
        preparedStatement.executeUpdate();
    }

}
