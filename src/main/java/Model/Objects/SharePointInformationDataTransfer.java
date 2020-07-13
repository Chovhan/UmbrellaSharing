package Model.Objects;

public class SharePointInformationDataTransfer extends Address {

    int sharePointId;
    int sharePointAvailability;
    int sharePointSequenceNumber;
    int umbrellaCol;

    public SharePointInformationDataTransfer(String country, String city, String street, int houseNumber, int sharePointId, int sharePointAvailability, int sharePointSequenceNumber, int umbrellaCol) {
        super(country, city, street, houseNumber);
        this.sharePointId = sharePointId;
        this.sharePointAvailability = sharePointAvailability;
        this.sharePointSequenceNumber = sharePointSequenceNumber;
        this.umbrellaCol = umbrellaCol;
    }

    public int getSharePointId() {
        return sharePointId;
    }

    public void setSharePointId(int sharePointId) {
        this.sharePointId = sharePointId;
    }

    public int getSharePointAvailability() {
        return sharePointAvailability;
    }

    public void setSharePointAvailability(int sharePointAvailability) {
        this.sharePointAvailability = sharePointAvailability;
    }

    public int getSharePointSequenceNumber() {
        return sharePointSequenceNumber;
    }

    public void setSharePointSequenceNumber(int sharePointSequenceNumber) {
        this.sharePointSequenceNumber = sharePointSequenceNumber;
    }

    public int getUmbrellaCol() {
        return umbrellaCol;
    }

    public void setUmbrellaCol(int umbrellaCol) {
        this.umbrellaCol = umbrellaCol;
    }

    @Override
    public String toString() {
        return "SharePointInformationDataTransfer{" +
                "sharePointId=" + sharePointId +
                ", sharePointAvailability=" + sharePointAvailability +
                ", sharePointSequenceNumber=" + sharePointSequenceNumber +
                ", umbrellaCol=" + umbrellaCol +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
