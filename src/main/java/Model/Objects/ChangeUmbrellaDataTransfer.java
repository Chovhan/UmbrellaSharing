package Model.Objects;

public class ChangeUmbrellaDataTransfer extends Address {

    int sequenceNumber;
    int availability;
    int sharePointSequenceNumber;
    int sharePointAvailability;

    public ChangeUmbrellaDataTransfer(String country, String city, String street, int houseNumber, int sequenceNumber, int availability, int sharePointSequenceNumber, int sharePointAvailability) {
        super(country, city, street, houseNumber);
        this.sequenceNumber = sequenceNumber;
        this.availability = availability;
        this.sharePointSequenceNumber = sharePointSequenceNumber;
        this.sharePointAvailability = sharePointAvailability;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getSharePointSequenceNumber() {
        return sharePointSequenceNumber;
    }

    public void setSharePointSequenceNumber(int sharePointSequenceNumber) {
        this.sharePointSequenceNumber = sharePointSequenceNumber;
    }

    public int getSharePointAvailability() {
        return sharePointAvailability;
    }

    public void setSharePointAvailability(int sharePointAvailability) {
        this.sharePointAvailability = sharePointAvailability;
    }

    @Override
    public String toString() {
        return "ChangeUmbrellaDataTransfer{" +
                "sequenceNumber=" + sequenceNumber +
                ", availability=" + availability +
                ", sharePointSequenceNumber=" + sharePointSequenceNumber +
                ", sharePointAvailability=" + sharePointAvailability +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
