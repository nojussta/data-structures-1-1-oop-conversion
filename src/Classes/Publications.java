package Classes;

public class Publications implements Comparable<Publications> {

    @Override
    public int compareTo(Publications o) {
        return 0;
    }

    String Code;
    String Title;
    double Price;

    public Publications(String code, String title, double price) {
        Code = code;
        Title = title;
        Price = price;
    }

    @Override
    public String toString() {
        return String.format("| %8s | %15s | %10d |", Code, Title, Price);
    }

    public boolean equals(Publications other) {
        return Title.equals(other.Title);
    }

}
