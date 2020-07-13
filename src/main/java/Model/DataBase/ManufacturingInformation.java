package Model.DataBase;

import Model.Objects.Manufacturing;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManufacturingInformation {

    private static final Logger logger = Logger.getLogger(ManufacturingInformation.class);

    public ArrayList<Manufacturing> getManufacturingInformation(){
        ArrayList<Manufacturing> manufacturingList = new ArrayList<Manufacturing>();
        try {
            Connection connection = ConnectionPool.getConnection();
            ResultSet resultSet = getManufacturerResultSet(connection);
            while (resultSet.next()){
                manufacturingList.add(createObject(resultSet.getString("manufacturer_name"), resultSet.getString("umbrella_model_name")));
            }
            logger.info("manufacturing information was found in db");
        } catch (SQLException e) {
            logger.error("Some problems with getting information from db " + e.getMessage());
        }
        return manufacturingList;
    }

    private ResultSet getManufacturerResultSet(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select manufacturer_name, umbrella_model_name from manufacturing " +
                        "inner join manufacturer " +
                        "on manufacturing.manufacturer_id = manufacturer.manufacturer_id " +
                        "inner join umbrella_model " +
                        "on manufacturing.umbrella_model_id = umbrella_model.umbrella_model_id");
        return preparedStatement.executeQuery();
    }

    private Manufacturing createObject(String manufacturer, String model){
        return new Manufacturing(manufacturer, model);
    }

}
