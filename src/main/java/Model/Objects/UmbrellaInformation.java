package Model.Objects;

public class UmbrellaInformation extends SharePoint {

    int umbrellaId;
    int umbrellaSequenceNumber;
    int umbrellaAvailability;

    public UmbrellaInformation(int sharePointId, int sharePointSequenceNumber, int umbrellaId, int umbrellaSequenceNumber, int umbrellaAvailability) {
        super(sharePointId, sharePointSequenceNumber);
        this.umbrellaId = umbrellaId;
        this.umbrellaSequenceNumber = umbrellaSequenceNumber;
        this.umbrellaAvailability = umbrellaAvailability;
    }

    public int getUmbrellaId() {
        return umbrellaId;
    }

    public void setUmbrellaId(int umbrellaId) {
        this.umbrellaId = umbrellaId;
    }

    public int getUmbrellaSequenceNumber() {
        return umbrellaSequenceNumber;
    }

    public void setUmbrellaSequenceNumber(int umbrellaSequenceNumber) {
        this.umbrellaSequenceNumber = umbrellaSequenceNumber;
    }

    public int getUmbrellaAvailability() {
        return umbrellaAvailability;
    }

    public void setUmbrellaAvailability(int umbrellaAvailability) {
        this.umbrellaAvailability = umbrellaAvailability;
    }
}
