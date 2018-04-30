
public class Book {

    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }


    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        } else {
            this.title = title;
        }
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        String[] names = author.split("\\s+");
        String secName = names[1];
        if (Character.isDigit(secName.charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        } else {
            this.author = author;
        }

    }

    protected double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");

        }else {
            this.price = price;
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}
