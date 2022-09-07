package Classes;

public class TaskUtils {

    public static boolean Contains(int index, Subscribers subscriber) {

        int n = subscriber.RangeDuration + subscriber.RangeStart;
        if (n < 13 && subscriber.RangeStart < index && subscriber.RangeStart + subscriber.RangeDuration >= index) {
            return true;
        }
        return false;
    }

    public static void AddToList(LinkedList<Publications> list, LinkedList<Subscribers> list1, LinkedList<Subscribers> results, String Title, int index) {
        for (list1.Start(); list1.Exist(); list1.Next()) {
            for (list.Start(); list.Exist(); list.Next()) {
                if (list.get().Title == Title && list.get().Code == list1.get().PublicationCode && Contains(index, list1.get())) {
                    results.addE(list1.get());
                }
            }
        }
    }
}
