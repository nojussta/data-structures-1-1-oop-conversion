package Classes;

public class Subscribers {
    public String Surname;
    public String Address;
    public int RangeStart;
    public int RangeDuration;
    public String PublicationCode;

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getRangeStart() {
        return RangeStart;
    }

    public void setRangeStart(int rangeStart) {
        RangeStart = rangeStart;
    }

    public int getRangeDuration() {
        return RangeDuration;
    }

    public void setRangeDuration(int rangeDuration) {
        RangeDuration = rangeDuration;
    }

    public String getPublicationCode() {
        return PublicationCode;
    }

    public void setPublicationCode(String publicationCode) {
        PublicationCode = publicationCode;
    }

    public int getPublicationAmount() {
        return PublicationAmount;
    }

    public void setPublicationAmount(int publicationAmount) {
        PublicationAmount = publicationAmount;
    }

    public int PublicationAmount;

    public Subscribers(String surname, String address, int rangeStart, int rangeDuration, String publicationCode, int publicationAmount) {
        this.Surname = surname;
        this.Address = address;
        this.RangeStart = rangeStart;
        this.RangeDuration = rangeDuration;
        this.PublicationCode = publicationCode;
        this.PublicationAmount = publicationAmount;
    }

    @Override
    public String toString() {
        return String.format("| {0, 8} | {1, -15} | {2, -20} | {3, 5} | {4, 5} | {5, 5} |", PublicationCode, Surname, Address, RangeStart, RangeDuration, PublicationAmount);
    }

    public boolean equals(Subscribers other) {
        return Surname.equals(other.Surname);
    }
}
