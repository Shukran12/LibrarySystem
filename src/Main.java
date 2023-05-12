import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scarf scarf = new Scarf();

        // Add section
        scarf.fictionAdd(new FictionBooks("Test1", "Xalid Huseyn", 1));
        scarf.fictionAdd(new FictionBooks("Test2", "Gaston Leroux", 11));
        scarf.nonFictionAdd(new NonFictionBooks("Test", "Test", 1));

        Scanner sc = new Scanner(System.in);
        System.out.println("Emeliyyati Secin");
        String work = sc.next();
        if(work.equals("Duzelt")){
            System.out.print("Hansi Kitab:  ");
            String hansi = sc.next();
            if(hansi.length() >0){
                System.out.print("Teze Adi: ");
                String neye = sc.next();
                if(neye.length() > 0){
                    System.out.print("Teze Muellif: ");
                    String muellif = sc.next();
                    if(muellif.length() > 0){
                        System.out.print("Teze Say: ");
                        int say = sc.nextInt();
                        if(say > 0){
                            for(int i=0; i<scarf.getFictionBooks().size(); i++){
                                if(scarf.getFictionBooks().get(i).getBookName().equals(hansi)){
                                    FictionBooks c = new FictionBooks(neye, muellif, say);
                                    scarf.updateFiction(hansi, c);
                                }
                            }

                            for(int i=0; i<scarf.getNonFictionBooksList().size(); i++){
                                if(scarf.getNonFictionBooksList().get(i).getBookName().equals(hansi)){
                                    NonFictionBooks c = new NonFictionBooks(neye, muellif, say);
                                    scarf.updateNoneFiction(hansi, c);
                                }
                            }

                            System.out.print(" -----------------------------------------\n| - - -  - - - Fiction Books - - - - -  - |\n");
                            for(FictionBooks fictionBooks : scarf.getFictionBooks()){
                                if(fictionBooks.getQty() > 0)
                                    System.out.print("\n|         \\"+fictionBooks.getBookName()+" -- "+fictionBooks.getAuthor()+"----"+fictionBooks.getQty()+" \\     |\n");
                            }
                            System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - - -|\n");
                            for(NonFictionBooks nonFictionBooks  : scarf.getNonFictionBooksList()){
                                if(nonFictionBooks.getQty() > 0)
                                    System.out.print("\n|               \\"+nonFictionBooks.getBookName()+" -- "+ nonFictionBooks.getAuthor() + " \\          |\n");

                            }
                        }
                    }
                }
            }


        } else if (work.equals("Elave")) {
            System.out.println("Kitabin Adi");
            String bookName = sc.next();
            if(bookName.length() > 0){
                System.out.println("Kitabin Muellifi");
                String author = sc.next();
                if(author.length() > 0){
                    System.out.println("Kitabin Sayi");
                    int qty = sc.nextInt();
                    if(qty > 0){
                     scarf.fictionAdd(new FictionBooks(bookName, author, qty));
                        for (FictionBooks fictionBooks : scarf.getFictionBooks()) {
                            if (fictionBooks.getQty() > 0)
                                System.out.print("\n|         \\" + fictionBooks.getBookName() + " -- " + fictionBooks.getAuthor() +"--" + fictionBooks.getQty() + " \\     |\n");
                        }
                        System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - - -|\n");
                        for (NonFictionBooks nonFictionBooks : scarf.getNonFictionBooksList()) {
                            if (nonFictionBooks.getQty() > 0)
                                System.out.print("\n|               \\" + nonFictionBooks.getBookName() + " -- " + nonFictionBooks.getAuthor() + " \\          |\n");

                        }
                    }
                }
            }
        } else if (work.equals("Silmek")) {
            System.out.println("Kitabin Adin daxil Edin");
            String rfName = sc.next();
            if(rfName.length() > 0){
                for (int i=0; i<scarf.getFictionBooks().size(); i++){
                    if(scarf.getFictionBooks().get(i).getBookName().equals(rfName)){
                        scarf.removeFiction(scarf.getFictionBooks().get(i));
                    }
                }





                System.out.print(" -----------------------------------------\n| - - -  - - - Fiction Books - - - - -  - |\n");
                for(FictionBooks fictionBooks : scarf.getFictionBooks()){
                    if(fictionBooks.getQty() > 0)
                        System.out.print("\n|         \\"+fictionBooks.getBookName()+" -- "+fictionBooks.getAuthor()+" \\     |\n");
                }
                System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - - -|\n");
                for(NonFictionBooks nonFictionBooks  : scarf.getNonFictionBooksList()){
                    if(nonFictionBooks.getQty() > 0)
                        System.out.print("\n|               \\"+nonFictionBooks.getBookName()+" -- "+ nonFictionBooks.getAuthor() + " \\          |\n");

                }
            }
        } else if (work.equals("Goturmek")) {
            System.out.print("Adiniz");
            String gName = sc.next();
            if(gName.length() > 0){
                System.out.println("Goturecek Kitabin Adi");
                String bName = sc.next();
                if(bName.length() > 0){
                    Order order = new Order();
                    for(int i=0; i<scarf.getFictionBooks().size(); i++){
                        if(scarf.getFictionBooks().get(i).getBookName().equals(bName)){
                            if(scarf.getFictionBooks().get(i).getQty() > 0){
                                System.out.println(order.fictionOrder(scarf.getFictionBooks().get(i), gName).get(gName).getBookName() + "--"+gName+" götürdü"+" qaldi:"+order.fictionOrder(scarf.getFictionBooks().get(i), gName).get(gName).getQty());
                            }else{
                                System.out.println("Kitab Evvelceden Goturulub");
                            }

                        }
                    }


                    for(int i=0; i<scarf.getNonFictionBooksList().size(); i++){
                        if(scarf.getNonFictionBooksList().get(i).getBookName().equals(bName)){
                            if(scarf.getNonFictionBooksList().get(i).getQty() > 0){
                                System.out.println(order.noneFictionOrder(scarf.getNonFictionBooksList().get(i), gName).get(gName).getBookName() + "   ----  "+gName+" goturdu"+"  qaldi: "+order.noneFictionOrder(scarf.getNonFictionBooksList().get(i), gName).get(gName).getQty());
                            }else{
                                System.out.println("Kitab Basqa Adamdadir");
                            }
                        }
                    }
                }
            }
        } else  {
            System.out.print(" -----------------------------------------\n| - - -  - - - Fiction Books - - - - -  - |\n");
            for(FictionBooks fictionBooks : scarf.getFictionBooks()){
                if(fictionBooks.getQty() > 0)
                    System.out.print("\n|         \\"+fictionBooks.getBookName()+" -- "+fictionBooks.getAuthor()+" \\     |\n");
            }
            System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - - -|\n");
            for(NonFictionBooks nonFictionBooks  : scarf.getNonFictionBooksList()){
                if(nonFictionBooks.getQty() > 0)
                    System.out.print("\n|               \\"+nonFictionBooks.getBookName()+" -- "+ nonFictionBooks.getAuthor() + " \\          |\n");

            }
        }









      /*  if (!user.isEmpty()) {
            if (user.equals("Admin")) {
                System.out.println("Xoş Gəlmisən, nə etmək istəyirsən?");
                String work = sc.next();
                if (!work.isEmpty()) {
                    if (work.equals("Elave")) {
                        System.out.println("Kitabin Adi:");
                        String bookName = sc.next();
                        if (!bookName.isEmpty()) {
                            System.out.println("Kitabin Muellifi:");
                            String author = sc.next();
                            if (!author.isEmpty()) {
                                System.out.println("Kitabin Sayi");
                                int qty = sc.nextInt();

                                scarf.fictionAdd(new FictionBooks(bookName, author, qty));
                                System.out.print(" -----------------------------------------\n| - - -  - - - Fiction Books - - - - -  - |\n");
                                for (FictionBooks fictionBooks : scarf.getFictionBooks()) {
                                    if (fictionBooks.getQty() > 0)
                                        System.out.print("\n|         \\" + fictionBooks.getBookName() + " -- " + fictionBooks.getAuthor() + " \\     |\n");
                                }
                                System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - - -|\n");
                                for (NonFictionBooks nonFictionBooks : scarf.getNonFictionBooksList()) {
                                    if (nonFictionBooks.getQty() > 0)
                                        System.out.print("\n|               \\" + nonFictionBooks.getBookName() + " -- " + nonFictionBooks.getAuthor() + " \\          |\n");

                                }
                            }

                        }
                    }
                    else if (work.equals("Silmek")) {
                        System.out.println("Silinecek Kitabin Adin Yaz:");
                        String booName = sc.next();
                        if (!booName.isEmpty()) {
                            for (int i = 0; i < scarf.getFictionBooks().size(); i++) {
                                if (scarf.getFictionBooks().get(i).getBookName().equals(booName)) {
                                    scarf.removeFiction(scarf.getFictionBooks().get(i));
                                }
                                for (FictionBooks fictionBooks : scarf.getFictionBooks()) {
                                    if (fictionBooks.getQty() > 0)
                                        System.out.print("\n|         \\" + fictionBooks.getBookName() + " -- " + fictionBooks.getAuthor() + " \\     |\n");
                                }
                                System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - - -|\n");


                            }
                        }
                    } else if (work=="Duzeltmek") {
                        System.out.println("Hansi Kitab");
                        String hansi = sc.next();
                        if(hansi.length() > 0){
                            System.out.println("Teze Adi Daxil Edin");
                            String
                        }
                    }
                }
            }
        }*/
    }





    // Remove Section

        String rfName = "Test";

       /* for (int i=0; i<scarf.getFictionBooks().size(); i++){
            if(scarf.getFictionBooks().get(i).getBookName().equals(rfName)){
               scarf.removeFiction(scarf.getFictionBooks().get(i));
            }
        }

        for (int i=0; i<scarf.getNonFictionBooksList().size(); i++){
            if(scarf.getNonFictionBooksList().get(i).getBookName().equals(rfName)){
                scarf.removeNonFiction(scarf.getNonFictionBooksList().get(i));
            }
        }



        System.out.print(" -----------------------------------------\n| - - -  - - - Fiction Books - - - - -  - |\n");
        for(FictionBooks fictionBooks : scarf.getFictionBooks()){
            if(fictionBooks.getQty() > 0)
                System.out.print("\n|         \\"+fictionBooks.getBookName()+" -- "+fictionBooks.getAuthor()+" \\     |\n");
        }
        System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - - -|\n");
        for(NonFictionBooks nonFictionBooks  : scarf.getNonFictionBooksList()){
            if(nonFictionBooks.getQty() > 0)
                System.out.print("\n|               \\"+nonFictionBooks.getBookName()+" -- "+ nonFictionBooks.getAuthor() + " \\          |\n");

        }

*/


// Update Section  ####

/*
        String hansi = "Test";
        String neye = "Şibumi";
        String muellif = "Trevanian";
        int say=15;

        for(int i=0; i<scarf.getFictionBooks().size(); i++){
            if(scarf.getFictionBooks().get(i).getBookName().equals(hansi)){
              FictionBooks c = new FictionBooks(neye, muellif, say);
              scarf.updateFiction(hansi, c);
            }
        }

        for(int i=0; i<scarf.getNonFictionBooksList().size(); i++){
            if(scarf.getNonFictionBooksList().get(i).getBookName().equals(hansi)){
              NonFictionBooks c = new NonFictionBooks(neye, muellif, say);
              scarf.updateNoneFiction(hansi, c);
            }
        }

        System.out.print(" -----------------------------------------\n| - - -  - - - Fiction Books - - - - -  - |\n");
        for(FictionBooks fictionBooks : scarf.getFictionBooks()){
            if(fictionBooks.getQty() > 0)
                System.out.print("\n|         \\"+fictionBooks.getBookName()+" -- "+fictionBooks.getAuthor()+" \\     |\n");
        }
        System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - - -|\n");
        for(NonFictionBooks nonFictionBooks  : scarf.getNonFictionBooksList()){
            if(nonFictionBooks.getQty() > 0)
                System.out.print("\n|               \\"+nonFictionBooks.getBookName()+" -- "+ nonFictionBooks.getAuthor() + " \\          |\n");

        }

*/









/*
    // Order Section
        String gName  = "Sukran";
        String bName  = "Sari Odanin Esrari";
    Order order = new Order();
    for(int i=0; i<scarf.getFictionBooks().size(); i++){
        if(scarf.getFictionBooks().get(i).getBookName().equals(bName)){
            if(scarf.getFictionBooks().get(i).getQty() > 0){
                System.out.println(order.fictionOrder(scarf.getFictionBooks().get(i), gName).get(gName).getBookName() + "--"+gName+" götürdü"+" qaldi:"+order.fictionOrder(scarf.getFictionBooks().get(i), gName).get(gName).getQty());
            }else{
                System.out.println("Kitab Evvelceden Goturulub");
            }

        }
    }


    for(int i=0; i<scarf.getNonFictionBooksList().size(); i++){
        if(scarf.getNonFictionBooksList().get(i).getBookName().equals(bName)){
            if(scarf.getNonFictionBooksList().get(i).getQty() > 0){
                System.out.println(order.noneFictionOrder(scarf.getNonFictionBooksList().get(i), gName).get(gName).getBookName() + "   ----  "+gName+" goturdu"+"  qaldi: "+order.noneFictionOrder(scarf.getNonFictionBooksList().get(i), gName).get(gName).getQty());
            }else{
                System.out.println("Kitab Basqa Adamdadir");
            }
        }
    }


*/








       /*
        scarf.getFictionBooks();



        System.out.print(" -----------------------------------------\n| - - -  - - - Fiction Books - - - - -  - |\n");
        for(FictionBooks fictionBooks : scarf.getFictionBooks()){
            if(fictionBooks.getQty() > 0)
            System.out.print("|            \\"+fictionBooks.getBookName()+" \\          |\n");
        }
        System.out.print(" -----------------------------------------\n| - - -  - - - NonFiction Books - - - - -  - |\n");
        for(NonFictionBooks nonFictionBooks  : scarf.getNonFictionBooksList()){
            if(nonFictionBooks.getQty() > 0)
            System.out.print("|               \\"+nonFictionBooks.getBookName()+" \\          |\n");
        }

 */

    }
