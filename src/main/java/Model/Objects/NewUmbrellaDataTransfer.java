package Model.Objects;

public class NewUmbrellaDataTransfer extends Manufacturing{


    int umbrellaAvailability;
    int sharePointId;

    public NewUmbrellaDataTransfer(String manufacturerName, String modelName, int umbrellaAvailability, int sharePointId) {
        super(manufacturerName, modelName);
        this.umbrellaAvailability = umbrellaAvailability;
        this.sharePointId = sharePointId;
    }

    public int getUmbrellaAvailability() {
        return umbrellaAvailability;
    }

    public void setUmbrellaAvailability(int umbrellaAvailability) {
        this.umbrellaAvailability = umbrellaAvailability;
    }

    public int getSharePointId() {
        return sharePointId;
    }

    public void setSharePointId(int sharePointId) {
        this.sharePointId = sharePointId;
    }

    @Override
    public String toString() {
        return "NewUmbrellaDataTransfer{" +
                "umbrellaAvailability=" + umbrellaAvailability +
                ", sharePointId=" + sharePointId +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
