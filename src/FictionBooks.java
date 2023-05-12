import java.util.Objects;

public class FictionBooks {

    private String bookName;
    private String author;
    private int qty = 1;


    public FictionBooks(String bookName, String author, int qty) {
        this.bookName = bookName;
        this.author = author;
        this.qty = qty;


    }


    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getQty() {
        return qty;
    }



}


