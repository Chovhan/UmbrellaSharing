package Model.Objects;

public class SharePoint {

    int sequenceNumber;
    int availability;

    public SharePoint(int sequenceNumber, int availability) {
        this.sequenceNumber = sequenceNumber;
        this.availability = availability;
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
}
