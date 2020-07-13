package Model.Objects;

public class NewSharePointDataTransfer extends Address {

    int sharePointAvailability;

    public NewSharePointDataTransfer(String country, String city, String street, int houseNumber, int sharePointAvailability) {
        super(country, city, street, houseNumber);
        this.sharePointAvailability = sharePointAvailability;
    }

    public int getSharePointAvailability() {
        return sharePointAvailability;
    }

    public void setSharePointAvailability(int sharePointAvailability) {
        this.sharePointAvailability = sharePointAvailability;
    }

    @Override
    public String toString() {
        return "NewSharePointDataTransfer{" +
                "sharePointAvailability=" + sharePointAvailability +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
