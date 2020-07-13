package Model.DataBase;

import Model.Objects.SharePointInformationDataTransfer;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SharePointInformation {

    private static final Logger logger = Logger.getLogger(SharePointAvailability.class);

    public ArrayList<SharePointInformationDataTransfer> getSharePointInformation(){
        ArrayList<SharePointInformationDataTransfer> sharePointInformationList = new ArrayList<SharePointInformationDataTransfer>();
        try {
            ResultSet resultSet = getInformationAboutSharePointSet();
            while (resultSet.next()){
                sharePointInformationList.add(createObject(resultSet));
            }
            logger.info("information about share point was got");
        } catch (SQLException e) {
            logger.error("We have some problems with getting information about share point " + e.getMessage());
        }
        return sharePointInformationList;
    }


    private SharePointInformationDataTransfer createObject(ResultSet resultSet) throws SQLException {
        return new SharePointInformationDataTransfer(resultSet.getString("address_country"),
                resultSet.getString("address_city"),
                resultSet.getString("address_street"),
                resultSet.getInt("address_house_number"),
                resultSet.getInt("share_point_id"),
                resultSet.getInt("share_point_availability"),
                resultSet.getInt("share_point_sequence_number"),
                resultSet.getInt("umbrella_col"));
    }

    private ResultSet getInformationAboutSharePointSet() throws SQLException {
        PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement("" +
                "select share_point_id, share_point_availability, share_point_sequence_number, address_country, address_city, address_street, address_house_number, count(share_point_id) as umbrella_col " +
                "from share_point " +
                "inner join addresses " +
                "on share_point.share_point_address_id = addresses.address_id " +
                "" +
                "group by share_point_id;");
        return preparedStatement.executeQuery();
    }
}
