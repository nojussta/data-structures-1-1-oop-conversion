package Classes;

public class Publications implements Comparable<Publications> {

    @Override
    public int compareTo(Publications o) {
        return 0;
    }

    public String Code;
    public String Title;
    public double Price;

    public Publications(String code, String title, double price) {
        Code = code;
        Title = title;
        Price = price;
    }

    @Override
    public String toString() {
        return String.format("| {0, 8} | {1, -15} | {2, 10} |", Code, Title, Price);
    }

    public boolean equals(Publications other) {
        return Title.equals(other.Title);
    }

}
