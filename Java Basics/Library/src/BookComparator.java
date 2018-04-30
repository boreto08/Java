import java.util.Comparator;

/**
 * Created by boreto on 3/24/2017.
 */
public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.compareTo(o2);
    }
}
