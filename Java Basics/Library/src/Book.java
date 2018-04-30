import java.util.Arrays;
import java.util.List;


public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors){
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors();
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    @Override
    public int compareTo(Book o) {
        if (this.getTitle().compareTo(o.getTitle()) == 0){
            if (this.getYear() < o.getYear()){
                return -1;
            }else if(this.getYear() > o.getYear()){
                return 1;
            }else{
                return 0;
            }
        }
        return  this.getTitle().compareTo(o.getTitle());

    }

    @Override
    public String toString() {
        return this.getTitle() + " " + this.getYear();
    }
}
