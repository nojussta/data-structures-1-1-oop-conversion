package Classes;

import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InOutUtils {

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
        System.out.println(String.format("| %38s | ", "Leidinių egzistencija per mėnesius"));
        System.out.println(String.format(dashes));
        System.out.println(String.format("| %15s | %20s |", "Mėnuo", "Leidinio kodas"));
        System.out.println(String.format(dashes));
        for (int i = 0; i < 12; i++) {
            System.out.println(String.format("| %15s | %20s |", new DateFormatSymbols().getMonths()[i], title.get(i)));
        }
    }

    public static void PrintSummedIncome(LinkedList<Double> incomeSum, LinkedList<Publications> list) {

        List<String> names = TaskUtils.GetList(list);
        list.Sort();
        LinkedList.Iterator l = (LinkedList.Iterator) incomeSum.iterator();

        String dashes = new String("--------------------------------------------------");
        System.out.println(String.format(dashes));
        System.out.println(String.format("| %46s | ", "Leidinių uždarbiai"));
        System.out.println(String.format(dashes));
        System.out.println(String.format("| %35s | %8s |", "Leidinio pavadinimas", "Uždarbis"));
        System.out.println(String.format(dashes));
        for (int i = 0; i < names.stream().count(); i++) {
            int n = 0;
            while (l.hasNext()) {
                if (n == i)
                    System.out.println(String.format("| %35s | %8s |", names.get(i), incomeSum.get()));
                n++;
            }
        }
    }

    public static void PrintChosenList(List<String> titles, LinkedList<Publications> list) {

        LinkedList.Iterator l = (LinkedList.Iterator) list.iterator();

        if (list.Count() > 0) {
            String dashes = new String("---------------------------------------------------------------------");
            System.out.println(String.format(dashes));
            System.out.println(String.format("%45s", "Duomenys tenkinantys kriterijus"));
            System.out.println(String.format(dashes));
            System.out.println(String.format("| %25s | %20s | %15s |", "Leidinio kodas", "Leidinio pavadinimas", "Kaina"));
            System.out.println(String.format(dashes));
            for (int i = 0; i < titles.stream().count(); i++) {
                while (l.hasNext()) {
                    if (list.get().Title == titles.get(i)) {
                        System.out.println(String.format("| %25s | %20s | %15s |",
                                list.get().Code, list.get().Title, list.get().Price));
                    }
                }
            }
            System.out.println();
        } else {
            System.out.println();
            System.out.println(String.format("{0,35}     ", "Sąlygą tenkinančių duomenų nėra!"));
        }
    }

    public static LinkedList<String> PrintChosenList2(List<String> titles, LinkedList<Publications> list) {
        LinkedList.Iterator l = (LinkedList.Iterator) list.iterator();
        LinkedList<String> newStringList = new LinkedList<String>();
        for (int i = 0; i < titles.stream().count(); i++) {
            while (l.hasNext()) {
                if (list.get().Title == titles.get(i)) {
                    String tempLine = "";
                    tempLine += String.format("| {0, -25} | {1, 20} | {2, 15}|", list.get().Code, list.get().Title, list.get().Price) + "\n";
                    newStringList.addE(tempLine);
                }
            }
        }
        return newStringList;
    }
}

