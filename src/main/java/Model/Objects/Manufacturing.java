package Model.Objects;

public class Manufacturing {

    String manufacturerName;
    String modelName;

    public Manufacturing(String manufacturerName, String modelName) {
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

}
