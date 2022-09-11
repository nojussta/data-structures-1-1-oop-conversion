import Classes.*;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        LinkedList<Publications> list1 = new LinkedList<Publications>();
//
//
//        LinkedList<Subscribers> list2 = new LinkedList<Subscribers>();


        LinkedList<Publications> list1 = InOutUtils.readPublications("C:\\Users\\Lenovo\\IdeaProjects\\data-structures-2\\src\\Data\\U3a.txt");
//        System.out.println("\n========ANTRASIS FAILAS=========\n");
        LinkedList<Subscribers> list2 = InOutUtils.readSubscribers("C:\\Users\\Lenovo\\IdeaProjects\\data-structures-2\\src\\Data\\U3b.txt");

        String SearchedPublications = "Leidinys1";
        Integer SearchedMonth = 2;

        LinkedList<Subscribers> resultList = new LinkedList<Subscribers>();
        TaskUtils.addEToList(list1, list2, resultList, SearchedPublications, SearchedMonth);
        InOutUtils.PrintResults(resultList);

        List<String> monthlyIncomeList = TaskUtils.MonthlyIncomeMax(list2, list1);
        InOutUtils.PrintMonthlyIncome(monthlyIncomeList);

        LinkedList<Double> Sum = TaskUtils.IncomeSum(list1, list2);
        InOutUtils.PrintSummedIncome(Sum, list1);

        TaskUtils.LowIncome(list1, list2);
    }
}