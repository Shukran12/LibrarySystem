import java.util.ArrayList;
import java.util.List;


public class Scarf  {


       List<FictionBooks> fictionBooksList = new ArrayList<>();

       List<NonFictionBooks> nonFictionBooksList = new ArrayList<>();






    public List<FictionBooks> fictionAdd(FictionBooks f){
        fictionBooksList.add(f);
        return fictionBooksList;
    }

    public List<NonFictionBooks> nonFictionAdd(NonFictionBooks n){
        nonFictionBooksList.add(n);
        return nonFictionBooksList;

    }



    public List<FictionBooks> getFictionBooks()
    {
       return fictionBooksList;
    }

    public List<NonFictionBooks> getNonFictionBooksList() {
        return nonFictionBooksList;
    }


    public void removeFiction(FictionBooks rfBook){
        fictionBooksList.remove(rfBook);

    }




    public List<FictionBooks> updateFiction(String bookName, FictionBooks toBook){
        for(int i=0; i<fictionBooksList.size(); i++){
            if(fictionBooksList.get(i).getBookName().equals(bookName)){
                fictionBooksList.set(i,toBook);
                return fictionBooksList;
            }
        }
        return fictionBooksList;
    }

    public List<NonFictionBooks> updateNoneFiction(String bookName, NonFictionBooks toBook){
        for(int i=0; i<nonFictionBooksList.size(); i++){
            if(nonFictionBooksList.get(i).getBookName().equals(bookName)){
                nonFictionBooksList.set(i,toBook);
                return nonFictionBooksList;
            }
        }
        return nonFictionBooksList;
    }


}
