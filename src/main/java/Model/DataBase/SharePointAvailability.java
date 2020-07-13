package Model.DataBase;

import Model.Objects.SharePoint;
import Model.Objects.UserInformationDataTransfer;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SharePointAvailability {

    private static final Logger logger = Logger.getLogger(SharePointAvailability.class);

    public int getInformationAboutSharePoint(SharePoint sharePoint) {
        int availability = 0;
        try {

            availability += getSharePointAvailability(sharePoint.getSequenceNumber());

            logger.info("information about share point availability was got");
        } catch (SQLException e) {
            logger.error("We have some problems with getting information about share point availability " + e.getMessage());
        }
        return availability;
    }


    protected int getSharePointAvailability(int sharePointNumber) throws SQLException {
        int availability = 0;
        PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(
                "Select share_point_availability from share_point " +
                        "where share_point_sequence_number=(?);");
        preparedStatement.setInt(1, sharePointNumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            availability += resultSet.getInt(1);
        }
        return availability;
    }
}
