package Classes;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.List;
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
                allPublications.addF(publication);
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
                allSubscribers.addF(subscriber);
            }
        } catch (Exception ex) {

        }
        return allSubscribers;
    }

    public static void PrintMonthlyIncome(List<String> title) {
        String dashes = new String("------------------------------------------");
        System.out.println(dashes);
        System.out.println(String.format("| %38s | ", "Leidini?? egzistencija per m??nesius"));
        System.out.println(String.format(dashes));
        System.out.println(String.format("| %15s | %20s |", "M??nuo", "Leidinio kodas"));
        System.out.println(String.format(dashes));
        for (int i = 0; i < 12; i++) {
            System.out.println(String.format("| %15s | %20s |", new DateFormatSymbols().getMonths()[i], title.get(i)));
        }
        System.out.println(String.format(dashes) + "\n");
    }

    public static void PrintSummedIncome(LinkedList<Double> incomeSum, LinkedList<Publications> list) {

        List<String> names = TaskUtils.GetList(list);
        list.Sort();
        LinkedList.Iterator l = (LinkedList.Iterator) incomeSum.iterator();

        String dashes = new String("--------------------------------------------------");
        System.out.println(String.format(dashes));
        System.out.println(String.format("| %46s | ", "Leidini?? u??darbiai"));
        System.out.println(String.format(dashes));
        System.out.println(String.format("| %35s | %8s |", "Leidinio pavadinimas", "U??darbis"));
        System.out.println(String.format(dashes));
        for (int i = 0; i < names.stream().count(); i++) {
            int n = 0;
            for (incomeSum.Start(); incomeSum.Exist(); incomeSum.Next()) {
                if (n == i)
                    System.out.println(String.format("| %35s | %8d |", names.get(i), Math.round(incomeSum.get())));
                n++;
            }
        }
        System.out.println(String.format(dashes) + "\n");
    }

    public static void PrintChosenList1(List<String> titles, LinkedList<Publications> list) {

        LinkedList.Iterator l = (LinkedList.Iterator) list.iterator();

        if (list.Count() > 0) {
            String dashes = new String("----------------------------------------------------------------------");
            System.out.println(String.format(dashes));
            System.out.println(String.format("| %66s |", "Duomenys tenkinantys kriterijus"));
            System.out.println(String.format(dashes));
            System.out.println(String.format("| %25s | %20s | %15s |", "Leidinio kodas", "Leidinio pavadinimas", "Kaina"));
            System.out.println(String.format(dashes));
            for (int i = 0; i < titles.stream().count(); i++) {
                for (list.Start(); list.Exist(); list.Next()) {
                    if (list.get().Title == titles.get(i)) {
                        System.out.println(String.format("| %25s | %20s | %15s |", list.get().Code, list.get().Title, list.get().Price));
                    }
                }
            }
            System.out.println(String.format(dashes) + "\n");
        } else {
            System.out.println();
            System.out.println(String.format("s%35s", "S??lyg?? tenkinan??i?? duomen?? n??ra!"));
        }
    }

    public static void PrintResults(LinkedList<Subscribers> list) {
        String dashes = new String("-------------------------------------------------------");
        if (list.Count() > 0) {
            System.out.println("\n" + dashes);
            System.out.println(String.format("| %51s |", "S??lyg?? tenkinantys duomenys atrinkti!"));
            System.out.println(dashes);
            System.out.println(String.format("| %5s | %20s | %20s |", "Kodas", "Pavard??", "Adresas"));
            System.out.println(dashes);
            for (list.Start(); list.Exist(); list.Next()) {
                System.out.println(String.format("| %5s | %20s | %20s |", list.get().PublicationCode, list.get().Surname, list.get().Address));
            }
            System.out.println(String.format(dashes) + "\n");
        } else {
            System.out.println(dashes);
            System.out.println(String.format("S??lyg?? tenkinan??i?? duomen?? n??ra!"));
            System.out.println(String.format(dashes) + "\n");
        }
    }

    public static void PrintMonthlyIncomeToFile(List<String> title, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            String dashes = String.format("------------------------------------------") + "\n";
            writer.write(dashes);
            writer.write(String.format("| %38s | ", "Leidini?? egzistencija per m??nesius"));
            writer.newLine();
            writer.write(String.format(dashes));
            writer.write(String.format("| %15s | %20s |", "M??nuo", "Leidinio kodas") + "\n");
            writer.write(String.format(dashes));
            for (int i = 0; i < 12; i++) {
                writer.write(String.format("| %15s | %20s |", new DateFormatSymbols().getMonths()[i], title.get(i)) + "\n");
            }
            writer.write(String.format(dashes) + "\n");
            writer.close();
        } catch (Exception ex) {
        }
    }

    public static void PrintSummedIncomeToFile(LinkedList<Double> incomeSum, LinkedList<Publications> list, String fileName) {

        List<String> names = TaskUtils.GetList(list);
        list.Sort();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            String dashes = String.format("--------------------------------------------------") + "\n";
            writer.write(String.format(dashes));
            writer.write(String.format("| %46s | ", "Leidini?? u??darbiai") + "\n");
            writer.write(String.format(dashes));
            writer.write(String.format("| %35s | %8s |", "Leidinio pavadinimas", "U??darbis") + "\n");
            writer.write(String.format(dashes));
            for (int i = 0; i < names.stream().count(); i++) {
                int n = 0;
                for (incomeSum.Start(); incomeSum.Exist(); incomeSum.Next()) {
                    if (n == i)
                        writer.write(String.format("| %35s | %8d |", names.get(i), Math.round(incomeSum.get())) + "\n");
                    n++;
                }
            }
            writer.write(String.format(dashes) + "\n");
            writer.close();
        } catch (Exception ex) {
        }
    }

    public static void PrintChosenList1ToFile(List<String> titles, LinkedList<Publications> list, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            if (list.Count() > 0) {
                String dashes = String.format("----------------------------------------------------------------------") + "\n";
                writer.write(String.format(dashes));
                writer.write(String.format("| %66s |", "Duomenys tenkinantys kriterijus") + "\n");
                writer.write(String.format(dashes));
                writer.write(String.format("| %25s | %20s | %15s |", "Leidinio kodas", "Leidinio pavadinimas", "Kaina") + "\n");
                writer.write(String.format(dashes));
                for (int i = 0; i < titles.stream().count(); i++) {
                    for (list.Start(); list.Exist(); list.Next()) {
                        if (list.get().Title == titles.get(i)) {
                            writer.write(String.format("| %25s | %20s | %15s |", list.get().Code, list.get().Title, list.get().Price) + "\n");
                        }
                    }
                }
                writer.write(String.format(dashes) + "\n");
            } else {
                writer.write(String.format("%35s", "S??lyg?? tenkinan??i?? duomen?? n??ra!"));
            }
            writer.close();
        } catch (Exception ex) {

        }
    }

    public static void PrintResultsToFile(LinkedList<Subscribers> list, String fileName) {
        String dashes = String.format("-------------------------------------------------------") + "\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            if (list.Count() > 0) {
                writer.write("\n" + dashes);
                writer.write(String.format("| %51s |", "S??lyg?? tenkinantys duomenys atrinkti!") + "\n");
                writer.write(dashes);
                writer.write(String.format("| %5s | %20s | %20s |", "Kodas", "Pavard??", "Adresas") + "\n");
                writer.write(dashes);
                for (list.Start(); list.Exist(); list.Next()) {
                    writer.write(String.format("| %5s | %20s | %20s |", list.get().PublicationCode, list.get().Surname, list.get().Address) + "\n");
                }
                writer.write(String.format(dashes));
            } else {
                writer.write(dashes);
                writer.write(String.format("S??lyg?? tenkinan??i?? duomen?? n??ra!") + "\n");
                writer.write(String.format(dashes));
            }
        } catch (Exception ex) {

        }
    }
}

