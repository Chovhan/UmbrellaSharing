package Model.DataBase;

import Model.Objects.ChangeUmbrellaDataTransfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChangeUmbrellaPlaceInformation {

    public ArrayList<ChangeUmbrellaDataTransfer> getInformation(){
        ArrayList<ChangeUmbrellaDataTransfer> arrayList = new ArrayList<ChangeUmbrellaDataTransfer>();
        try {
            Connection connection = ConnectionPool.getConnection();
            ResultSet resultSet = getUmbrellaInformationSet(connection);
            while (resultSet.next()){
                arrayList.add(createObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private ChangeUmbrellaDataTransfer createObject(ResultSet resultSet) throws SQLException {
        return new ChangeUmbrellaDataTransfer(
                resultSet.getString("address_country"),
                resultSet.getString("address_city"),
                resultSet.getString("address_street"),
                resultSet.getInt("address_house_number"),
                resultSet.getInt("umbrella_instance_sequance_number"),
                resultSet.getInt("umbrella_availability"),
                resultSet.getInt("share_point_sequence_number"),
                resultSet.getInt("share_point_availability")
                );
    }

    private ResultSet getUmbrellaInformationSet(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select umbrella_instance_sequance_number, umbrella_availability, share_point_sequence_number, share_point_availability, address_country, address_city, address_street, address_house_number " +
                "from umbrella_instance " +
                "inner join share_point " +
                "on umbrella_instance.umbrella_share_point_id = share_point.share_point_id " +
                "inner join addresses " +
                "on share_point.share_point_address_id = addresses.address_id;");
        return preparedStatement.executeQuery();
    }



}
