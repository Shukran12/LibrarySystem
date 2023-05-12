import java.util.Map;
import java.util.TreeMap;

public class Order extends Scarf  {
    Map<String , FictionBooks> fictionBooksStringMap = new TreeMap<>();
    Map<String , NonFictionBooks> nonFictionBooksTreeMap = new TreeMap<>();

    public Map<String, FictionBooks> fictionOrder(FictionBooks f, String gName){
         FictionBooks bookNew = new FictionBooks(f.getBookName(), f.getAuthor(), f.getQty()-1);
        fictionBooksStringMap.put(gName, bookNew);
       return fictionBooksStringMap;

    }


    public Map<String, NonFictionBooks> noneFictionOrder(NonFictionBooks nf, String gName){
        nonFictionBooksTreeMap.put(gName, nf);
        return nonFictionBooksTreeMap;
    }












}
