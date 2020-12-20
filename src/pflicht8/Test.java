package pflicht8;



public class Test {

        public static void main (String args[]) {
            Person p1 = new Person("AAA", "Khfd", "64563456");
            Person p2 = new Person("AAA", "Khfd", "456");
            Person p3 = new Person("AAA", "shgf", "64563456");
            Person p4 = new Person("AAA", "sfb", "45");
            Person p5 = new Person("AAA", "Khvbfd", "yyy");
            Person p6 = new Person("AAA", "Khrrrfd", "64563456");

            Telefonbuch t =  new Telefonbuch();
            Telefonbuch t2 =  new Telefonbuch();

//            PhoneBook pb = new PhoneBook();
//            pb.insertPerson(p1);
//            pb.insertPerson(p2);
//            pb.insertPerson(p3);
//            pb.insertPerson(p4);
//            System.out.println(pb);

            t.insertPerson(p6);
            t.insertPerson(p1);
            t.insertPerson(p4);
            t.insertPerson(p2);
            t.insertPerson(p5);
            t.insertPerson(p3);

//            System.out.println(t);
//            System.out.println(t2);
//            System.out.println(t.countEntries());
//            System.out.println(t2.countEntries());
           System.out.println(t.searchPerson("Khfd"));
            System.out.println(t.searchPerson("jsdfhg"));
//            System.out.println(t2.searchPerson("hjdgf"));


            Book b1 = new Book("AAA", "jsg", 2342);
            Book b2 = new Book("BB", "hfdjg", 123512);
            Book b3 = new Book("CC", "dfgd", 43);
            Book b4 = new Book("DDD", "jsffffg", 752);
            BookCatalogue bk = new BookCatalogue();
            BookCatalogue bk2 = new BookCatalogue();

            bk.insertBook(b2);
            bk.insertBook(b1);
            bk.insertBook(b3);
            bk.insertBook(b4);
        System.out.println(bk);
//            System.out.println(bk2);
//            System.out.println(bk.countBooks());
//            System.out.println(bk2.countBooks());
//            System.out.println(bk.getAllUntil(2342));
//            System.out.println(bk2.getAllUntil(2342));
//            System.out.println(bk.countBooksUntil(2342));
//            System.out.println(bk2.countBooksUntil(2342));
//
           System.out.println(bk.searchBook(242));
            System.out.println(bk.countBooksUntil(753));


//
//            System.out.println(t.searchPerson("hh"));
//           System.out.println(bk.searchBook(754));
//           // System.out.println(bk.getAllUntil(2342));



        }
    }


