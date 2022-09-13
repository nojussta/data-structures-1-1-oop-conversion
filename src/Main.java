import Classes.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        LinkedList<Publications> list1 = new LinkedList<Publications>();
//
//
//        LinkedList<Subscribers> list2 = new LinkedList<Subscribers>();
        
        String CFd1 = "C:\\Users\\Lenovo\\IdeaProjects\\data-structures-2\\src\\Data\\U3a.txt";
        String CFd2 = "C:\\Users\\Lenovo\\IdeaProjects\\data-structures-2\\src\\Data\\U3b.txt";
        String CFr = "C:\\Users\\Lenovo\\IdeaProjects\\data-structures-2\\src\\Data\\Rezultatai.txt";

        String SearchedPublications = "Leidinys1";
        int SearchedMonth = 2;

//        System.out.println("\n========PIRMASIS FAILAS=========\n");
        LinkedList<Publications> list1 = InOutUtils.readPublications(CFd1);
//        System.out.println("\n========ANTRASIS FAILAS=========\n");
        LinkedList<Subscribers> list2 = InOutUtils.readSubscribers(CFd2);

        LinkedList<Subscribers> resultList = new LinkedList<>();
        TaskUtils.addEToList(list1, list2, resultList, SearchedPublications, SearchedMonth);
        InOutUtils.PrintResults(resultList);
        InOutUtils.PrintResultsToFile(resultList, CFr);

        List<String> monthlyIncomeList = TaskUtils.MonthlyIncomeMax(list2, list1);
        InOutUtils.PrintMonthlyIncome(monthlyIncomeList);
        InOutUtils.PrintMonthlyIncomeToFile(monthlyIncomeList, CFr);

        LinkedList<Double> Sum = TaskUtils.IncomeSum(list1, list2);
        InOutUtils.PrintSummedIncome(Sum, list1);
        InOutUtils.PrintSummedIncomeToFile(Sum, list1, CFr);

        TaskUtils.LowIncome(list1, list2, CFr);
    }
}