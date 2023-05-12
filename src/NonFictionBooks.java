public class NonFictionBooks {
   private String bookName;
   private String author;
   int qty;

   public NonFictionBooks(String bookName, String author, int qty) {
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
