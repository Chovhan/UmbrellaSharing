package Model.Objects;

public class User {

    String firstName;
    String lastName;
    String userBirthDate;
    String userEmail;
    String userPhoneNumber;

    public User(String firstName, String lastName, String userBirthDate, String userEmail, String userPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userBirthDate = userBirthDate;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
