package Classes;

public class Subscribers {
    String Surname;
    String Address;
    int RangeStart;
    int RangeDuration;
    String PublicationCode;
    int PublicationAmount;

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
        return String.format("| %8s | %15s | %20d | %5d | %5s | %5d |", PublicationCode, Surname, Address, RangeStart, RangeDuration, PublicationAmount);
    }

    public boolean equals(Subscribers other) {
        return Surname.equals(other.Surname);
    }
}
