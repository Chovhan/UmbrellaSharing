package Model.DataBase;

import Model.Objects.UserInformationDataTransfer;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserInformation {

    private static final Logger logger = Logger.getLogger(SharePointAvailability.class);

    public ArrayList<UserInformationDataTransfer> getInformationAboutUser(){
        ArrayList<UserInformationDataTransfer> userInformationList = new ArrayList<UserInformationDataTransfer>();
        try {
            ResultSet resultSet = getInformationAboutUserSet();
            while (resultSet.next()){
                userInformationList.add(createObject(resultSet));
            }
            logger.info("information about user was got");
        } catch (SQLException e) {
            logger.error("We have some problems with getting information about user " + e.getMessage());
        }
        return userInformationList;
    }

    private UserInformationDataTransfer createObject(ResultSet resultSet) throws SQLException {
        return new UserInformationDataTransfer(
                resultSet.getString("user_first_name"),
                resultSet.getString("user_last_name"),
                resultSet.getString("user_birth_date"),
                resultSet.getString("user_email"),
                resultSet.getString("user_phone_number"),
                resultSet.getInt("take_umbrella_id"),
                resultSet.getInt("umbrella_instance_sequance_number"),
                resultSet.getInt("share_point_sequence_number"),
                resultSet.getString("address_country"),
                resultSet.getString("address_city"),
                resultSet.getString("address_street"),
                resultSet.getInt("address_house_number")
                );
    }

    private ResultSet getInformationAboutUserSet() throws SQLException {
        PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement("" +
                "select take_umbrella_id, user_first_name, user_last_name, user_birth_date, user_email, user_phone_number, umbrella_instance_sequance_number, share_point_sequence_number, address_country, address_city, address_street, address_house_number " +
                "from take_umbrella " +
                "inner join user_account " +
                "on take_umbrella.take_umbrella_user_id = user_account.user_account_id " +
                "inner join user " +
                "on user_account.user_id = user.user_id " +
                "inner join share_point " +
                "on take_umbrella.take_umbrella_share_point_id = share_point.share_point_id " +
                "inner join addresses " +
                "on share_point.share_point_address_id = addresses.address_id " +
                "inner join umbrella_instance " +
                "on take_umbrella.take_umbrella_instance_id = umbrella_instance.umbrella_instance_id;");
        return preparedStatement.executeQuery();
    }

}
