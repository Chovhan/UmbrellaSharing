package Model.DataBase;

import Model.Objects.NewSharePointDataTransfer;
import org.apache.log4j.Logger;

import java.sql.*;

public class AddSharePointTransaction {

    private static final Logger logger = Logger.getLogger(AddSharePointTransaction.class);

    public void addSharePoint(NewSharePointDataTransfer newSharePointDataTransfer)  {
        Savepoint savepoint = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("add umbrella sharing savepoint");

            int addressId = getAddressInDb(newSharePointDataTransfer.getCountry(), newSharePointDataTransfer.getCity(), newSharePointDataTransfer.getStreet(), newSharePointDataTransfer.getHouseNumber(), connection);
            int sharePointSequenceNumber = getSharePointSequenceNumber(connection);

            System.out.println(addressId);

            if (!checkRowInDataBase(addressId)){
                insetAddressToDb(connection, newSharePointDataTransfer.getCountry(), newSharePointDataTransfer.getCity(), newSharePointDataTransfer.getStreet(), newSharePointDataTransfer.getHouseNumber());
                addressId = getAddressInDb(newSharePointDataTransfer.getCountry(), newSharePointDataTransfer.getCity(), newSharePointDataTransfer.getStreet(), newSharePointDataTransfer.getHouseNumber(), connection);
                System.out.println(addressId);
            }
            insertSharePointToDb(connection, sharePointSequenceNumber, newSharePointDataTransfer.getSharePointAvailability(), addressId);

            connection.commit();
            connection.close();
            logger.info("share point was added");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(savepoint);
                    connection.releaseSavepoint(savepoint);
                } catch (SQLException ex) {
                    logger.error("Some problems with adding share point " + ex.getMessage());
                }
            }
            logger.error("Some problems with adding share point " + e.getMessage());
        }
    }

    private boolean checkRowInDataBase(int col){
        boolean flag = false;
        if (col != 0){
            flag = true;
        }
        return flag;
    }

    private int getSharePointSequenceNumber(Connection connection) throws SQLException {
        int sequenceNumber = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select max(share_point_sequence_number)+1 from share_point;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            sequenceNumber += resultSet.getInt(1);
        }
        return sequenceNumber;
    }

    private int getAddressInDb(String addressCountry, String addressCity, String addressStreet, int addressHouseNumber, Connection connection) throws SQLException {
        int address_col = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select address_id " +
                "from addresses " +
                "where address_country = (?) " +
                "and address_city = (?) " +
                "and address_street = (?) " +
                "and address_house_number = (?);");
        preparedStatement.setString(1, addressCountry);
        preparedStatement.setString(2, addressCity);
        preparedStatement.setString(3, addressStreet);
        preparedStatement.setInt(4, addressHouseNumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            address_col += resultSet.getInt("address_id");
        }
        return address_col;
    }

    private void insertSharePointToDb(Connection connection, int sharePointSequenceNumber, int sharePointAvailability, int sharePointAddressId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "insert into share_point(share_point_sequence_number, share_point_availability, share_point_address_id) values (?, ?, ?);");
        preparedStatement.setInt(1, sharePointSequenceNumber);
        preparedStatement.setInt(2, sharePointAvailability);
        preparedStatement.setInt(3, sharePointAddressId);
        preparedStatement.executeUpdate();
    }

    private void insetAddressToDb(Connection connection, String addressCountry, String addressCity, String addressStreet, int addressHouseNumber) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "insert into addresses(address_country, address_city, address_street, address_house_number) " +
                "values (?, ?, ?, ?);");
        preparedStatement.setString(1, addressCountry);
        preparedStatement.setString(2, addressCity);
        preparedStatement.setString(3, addressStreet);
        preparedStatement.setInt(4, addressHouseNumber);
        preparedStatement.executeUpdate();
    }
}
