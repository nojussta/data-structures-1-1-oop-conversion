package Classes;

import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class InOutUtils {
//    public static void readFromFile1() {
//        LinkedList<Publications> allPublications = new LinkedList<Publications>();
//        try {
//            BufferedReader reader = new BufferedReader(
//                    new FileReader("C:\\Users\\Lenovo\\IdeaProjects\\data-structures-2\\src\\Data\\U3a.txt"));
//            String text;
//            while ((text = reader.readLine()) != null) {
////                System.out.println(text);
//                foreach (String item: text){
//                    String code = value.getBytes(0)
//                }
//            }
//            reader.close();
//        } catch (Exception ex) {
//        }
//    }

    public static LinkedList<Publications> readPublications(String fileName) {
        LinkedList<Publications> allPublications = new LinkedList<Publications>();
        FileInputStream fileStream;
        Scanner scanner;
        try {
            fileStream = new FileInputStream(fileName);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] Values = scanner.nextLine().split(";");
                String Code = Values[0];
                String Title = Values[1];
                Double Price = Double.parseDouble(Values[2]);
                Publications publication = new Publications(Code, Title, Price);
                allPublications.addE(publication);
            }
        } catch (Exception ex) {

        }
        return allPublications;
    }

    public static void readFromFile2() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\IdeaProjects\\data-structures-2\\src\\Data\\U3b.txt"));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
            reader.close();
        } catch (Exception ex) {
        }
    }

    public static LinkedList<Subscribers> readSubscribers(String fileName) {
        LinkedList<Subscribers> allSubscribers = new LinkedList<Subscribers>();
        FileInputStream fileStream;
        Scanner scanner;
        try {
            fileStream = new FileInputStream(fileName);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] Values = scanner.nextLine().split(";");
                String Surname = Values[0];
                String Address = Values[1];
                Integer RangeStart = Integer.parseInt(Values[2]);
                Integer RangeDuration = Integer.parseInt(Values[3]);
                String PublicationCode = Values[4];
                Integer PublicationAmount = Integer.parseInt(Values[5]);
                Subscribers subscriber = new Subscribers(Surname, Address, RangeStart, RangeDuration, PublicationCode, PublicationAmount);
                allSubscribers.addE(subscriber);
            }
        } catch (Exception ex) {

        }
        return allSubscribers;
    }

    public static void PrintMonthlyIncome(List<String> title) {
        String dashes = new String("------------------------------------------");
        System.out.println(dashes);
        System.out.println(String.format("| {0, -38} | ", "Leidinių egzistencija per mėnesius"));
        System.out.println(String.format(dashes));
        System.out.println(String.format("| {0, -15} | {1, 20} |", "Mėnuo", "Leidinio kodas"));
        System.out.println(String.format(dashes));
    }
}

