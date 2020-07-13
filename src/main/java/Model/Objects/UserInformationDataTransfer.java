package Model.Objects;

public class UserInformationDataTransfer extends User {

    int takeUmbrellaId;
    int umbrellaSequenceNumber;
    int sharePointSequenceNumber;
    String country;
    String city;
    String street;
    int houseNumber;

    public UserInformationDataTransfer(String firstName, String lastName, String userBirthDate, String userEmail, String userPhoneNumber, int takeUmbrellaId, int umbrellaSequenceNumber, int sharePointSequenceNumber, String country, String city, String street, int houseNumber) {
        super(firstName, lastName, userBirthDate, userEmail, userPhoneNumber);
        this.takeUmbrellaId = takeUmbrellaId;
        this.umbrellaSequenceNumber = umbrellaSequenceNumber;
        this.sharePointSequenceNumber = sharePointSequenceNumber;
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public int getTakeUmbrellaId() {
        return takeUmbrellaId;
    }

    public void setTakeUmbrellaId(int takeUmbrellaId) {
        this.takeUmbrellaId = takeUmbrellaId;
    }

    public int getUmbrellaSequenceNumber() {
        return umbrellaSequenceNumber;
    }

    public void setUmbrellaSequenceNumber(int umbrellaSequenceNumber) {
        this.umbrellaSequenceNumber = umbrellaSequenceNumber;
    }

    public int getSharePointSequenceNumber() {
        return sharePointSequenceNumber;
    }

    public void setSharePointSequenceNumber(int sharePointSequenceNumber) {
        this.sharePointSequenceNumber = sharePointSequenceNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
