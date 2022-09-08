package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskUtils {
    /// <summary>
/// This method calculates the value of subscribers using a publication
/// </summary>
/// <param name="list"></param>
/// <param name="p"></param>
/// <returns></returns>
    public static double CalculateValue(LinkedList<Publications> list, Subscribers publication) {
        LinkedList.Iterator l = (LinkedList.Iterator) list.iterator();
        double value = 0;
        while (l.hasNext()) {
            if (Objects.equals(list.get().Code, publication.PublicationCode)) {
                value = publication.RangeDuration * list.get().Price * publication.PublicationAmount;
            }
        }
        return value;
    }

    /// <summary>
/// This method searches for the highest value of subscribers per month
/// </summary>
/// <param name="MonthlySubs">Input list of String which contains linked list data</param>
/// <param name="list1">Input of a publications linked list data</param>
/// <param name="list">Input of a publications linked list data</param>
/// <returns></returns>
    public static String SearchForHighest(LinkedList<String> MonthlySubs, LinkedList<Subscribers> list1, LinkedList<Publications> list) {

        LinkedList.Iterator l1 = (LinkedList.Iterator) MonthlySubs.iterator();
        LinkedList.Iterator l2 = (LinkedList.Iterator) list1.iterator();

        double biggest = 0;
        String oneString = "";
        while (l1.hasNext()) {
            Double value = (double) 0;
            while (l2.hasNext()) {
                if (Objects.equals(MonthlySubs.get(), list1.get().PublicationCode)) {
                    value += CalculateValue(list, list1.get());
                }

            }
            if (value > biggest) {
                oneString = String.format("{0}", MonthlySubs.get());
                biggest = value;
            } else if (value == biggest) {
                oneString += String.format(" {0}", MonthlySubs.get());
            }
        }
        return oneString;
    }

    /// <summary>
/// This method gets the highest value
/// </summary>
/// <param name="i">Input int of an index</param>
/// <param name="list">Input of a publications linked list data</param>
/// <param name="list1">Input of a subscribers linked list data</param>
/// <returns></returns>
    public static String GetHighest(int i, LinkedList<Publications> list, LinkedList<Subscribers> list1) {

        LinkedList.Iterator l1 = (LinkedList.Iterator) list.iterator();
        LinkedList.Iterator l2 = (LinkedList.Iterator) list1.iterator();

        LinkedList<String> monthlyPublications = new LinkedList<String>();
        while (l1.hasNext()) {
            while (l2.hasNext()) {
                if (Objects.equals(list.get().Code, list1.get().PublicationCode) && list1.get().RangeStart <= i + 1 && list1.get().RangeStart + list1.get().RangeDuration >= i + 1) {
                    String currVal = list.get().Code;
                    monthlyPublications.addE(currVal);
                }
            }
        }
        String highest = SearchForHighest(monthlyPublications, list1, list);
        return highest;
    }

    /// <summary>
/// This method addEs certain chosen objects to a list
/// </summary>
/// <param name="list">Input of a publications linked list data</param>
/// <param name="list1">Input of a subscribers linked list data</param>
/// <param name="results">Input of a subscribers linked list data</param>
/// <param name="Title">Input String of an object title</param>
/// <param name="index">Input int of an index</param>
    public static void addEToList(LinkedList<Publications> list, LinkedList<Subscribers> list1, LinkedList<Subscribers> results, String Title, int index) {

        LinkedList.Iterator l1 = (LinkedList.Iterator) list.iterator();
        LinkedList.Iterator l2 = (LinkedList.Iterator) list1.iterator();

        while (l1.hasNext()) {
            while (l2.hasNext()) {
                if (Objects.equals(list.get().Title, Title) && Objects.equals(list.get().Code, list1.get().PublicationCode) && Contains(index, list1.get())) {
                    results.addE(list1.get());
                }
            }
        }
    }

    /// <summary>
/// This method outputs a list which contains certain chosen data
/// </summary>
/// <param name="list1">Input of a publications linked list data</param>
/// <returns></returns>
    public static List<String> GetList(LinkedList<Publications> list1) {
        List<String> allPublications = new ArrayList<String>();
        LinkedList.Iterator l1 = (LinkedList.Iterator) list1.iterator();

        while (l1.hasNext()) {
            if (!allPublications.contains(list1.get().Title)) {
                allPublications.add(list1.get().Title);
            }
        }
        return allPublications;
    }

    /// <summary>
/// This is a method which gets all the incomes of publications and puts it into a Double list
/// </summary>
/// <param name="list1">Input of a publications linked list data</param>
/// <param name="list2">Input of a subscribers linked list data</param>
/// <returns></returns>
    public static LinkedList<Double> IncomeSum(LinkedList<Publications> list1, LinkedList<Subscribers> list2) {
        List<String> allPublications = GetList(list1);
        LinkedList<Double> SummedIncome = GetIncomeSum(allPublications, list1, list2);
        return SummedIncome;
    }

    /// <summary>
/// This method calculates the maximum income per month
/// </summary>
/// <param name="list1">Input of a subscribers linked list data</param>
/// <param name="list">Input of a publications linked list data</param>
/// <param name="fileName">Input String of a file name</param>
/// <returns></returns>
    public static List<String> MonthlyIncomeMax(LinkedList<Subscribers> list1, LinkedList<Publications> list) {
        List<String> newList = new ArrayList<String>();

        for (int i = 0; i < 12; i++) {
            String Title = GetHighest(i, list, list1);
            newList.add(Title);
        }
        InOutUtils.PrintMonthlyIncome(newList);
        return newList;
    }

    /// <summary>
/// This method calculates the lowest income per month
/// </summary>
/// <param name="list1">Input of a publications linked list data</param>
/// <param name="list2">Input of a subscribers linked list data</param>
/// <param name="fileName">Input String of a file name</param>
/// <returns></returns>
    public static LinkedList<String> LowIncome(LinkedList<Publications> list1, LinkedList<Subscribers> list2) {
        Double average = GetAverageIncome(list1, list2);
        List<String> Titles = GetList(list1);
        List<String> newTitles = new ArrayList<String>();
        for (int i = 0; i < Titles.stream().count(); i++) {
            Double av = GetAverage(Titles.get(i), list2, list1);
            if (av < average) {
                newTitles.add(Titles.get(i));
            }
        }
        list1.Sort();
        InOutUtils.PrintChosenList(newTitles, list1);
        LinkedList<String> list = InOutUtils.PrintChosenList2(newTitles, list1);
        return list;
    }

    /// <summary>
/// This method calculates the average income per month
/// </summary>
/// <param name="Title">Input String of an object title</param>
/// <param name="list2">Input of a subscribers linked list data</param>
/// <param name="list1">Input of a publications linked list data</param>
/// <returns></returns>
    public static Double GetAverage(String Title, LinkedList<Subscribers> list2, LinkedList<Publications> list1) {
        Double ave = Double.valueOf(0);
        int n = 0;
        LinkedList.Iterator l1 = (LinkedList.Iterator) list1.iterator();
        LinkedList.Iterator l2 = (LinkedList.Iterator) list2.iterator();

        while (l1.hasNext()) {
            while (l2.hasNext()) {
                if (Objects.equals(list1.get().Title, Title) && Objects.equals(list1.get().Code, list2.get().PublicationCode)) {
                    ave += list1.get().Price * list2.get().PublicationAmount;
                    n++;
                }
            }
        }
        if (n != 0) return ave / n;
        else return ave;
    }

    /// <summary>
/// This method calculates the average income per month
/// </summary>
/// <param name="list1">Input of a publications linked list data</param>
/// <param name="list2">Input of a subscribers linked list data</param>
/// <returns></returns>
    public static Double GetAverageIncome(LinkedList<Publications> list1, LinkedList<Subscribers> list2) {
        Double sum = Double.valueOf(0);
        int allPublications = 0;
        LinkedList.Iterator l1 = (LinkedList.Iterator) list1.iterator();
        LinkedList.Iterator l2 = (LinkedList.Iterator) list2.iterator();

        while (l1.hasNext()) {
            while (l2.hasNext()) {
                sum += list1.get().Price * list2.get().PublicationAmount;
                allPublications += list2.get().PublicationAmount;
            }
        }
        return sum / allPublications;
    }

    /// <summary>
/// This method calculates the average income sum per month
/// </summary>
/// <param name="allPublications">Input list of String which contains linked list data</param>
/// <param name="list1">Input of a publications linked list data</param>
/// <param name="list2">Input of a subscribers linked list data</param>
/// <returns></returns>
    public static LinkedList<Double> GetIncomeSum(List<String> allPublications, LinkedList<Publications> list1, LinkedList<Subscribers> list2) {
        LinkedList<Double> sum = new LinkedList<Double>();
        Double price = (double) 0;
        LinkedList.Iterator l1 = (LinkedList.Iterator) list1.iterator();
        LinkedList.Iterator l2 = (LinkedList.Iterator) list2.iterator();

        for (int i = 0; i < allPublications.stream().count(); i++) {
            while (l1.hasNext()) {
                while (l2.hasNext()) {
                    if (Objects.equals(list1.get().Title, allPublications.get(i)) && Objects.equals(list2.get().PublicationCode, list1.get().Code)) {
                        price += list1.get().Price * list2.get().PublicationAmount;
                    }
                }
            }
            sum.addE(price);
            price = Double.valueOf(0);
        }
        return sum;
    }

    /// <summary>
/// boolean method to check whether contains
/// </summary>
/// <param name="index">Input int of a certain number</param>
/// <param name="p"></param>
/// <returns></returns>
    public static boolean Contains(int index, Subscribers subscriber) {

        int n = subscriber.RangeDuration + subscriber.RangeStart;
        if (n < 13 && subscriber.RangeStart < index && subscriber.RangeStart + subscriber.RangeDuration >= index) {
            return true;
        }
        return false;
    }

    /// <summary>
/// boolean method to check whether an item contains characters
/// </summary>
/// <param name="str">Input String</param>
/// <returns></returns>
    public static boolean ContainsCharacters(String input) {
        for (char item : input.toCharArray()) {
            if (Character.isDigit(item)) return false;
        }
        return true;
    }
}