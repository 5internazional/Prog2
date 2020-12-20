package pflicht8;

public class BookCatalogue extends BinTreeGen<Book>{
    private BinTreeGen<Book> AntiquarBuecher;
    private Book book;

    private StringBuilder sb = new StringBuilder();

    public BookCatalogue() {
        AntiquarBuecher = new BinTreeGen<>();
    }

    public int countBooks() {
        return AntiquarBuecher.countNodes();
    }

    public int countBooksUntil(int year) {
//        book = new Book("name", "author", year);
//        return AntiquarBuecher.countNodes(AntiquarBuecher.find(book));

        return countBooksUntil(AntiquarBuecher.getRoot(), year);

    }

    private int countBooksUntil(BinNodeGen<Book> k, int year) {
        if (k == null)
            return 0;
        if (k.data.getJahr() <= year) {
            int count = 1 + (k.left == null ? 0 : AntiquarBuecher.countNodes(k.left));
            if (k.data.getJahr() == year)
                return count;
            return count + countBooksUntil(k.right, year);
        } else return countBooksUntil(k.left, year);
    }


    public boolean insertBook(Book b) {
        return AntiquarBuecher.insertNode(b);
    }

    public Book searchBook(int year) {
        book = new Book("name", "author", year);
        return AntiquarBuecher.find(book).data;

    }

    public String getAllUntil(int year) {
        return "Books published until " + year + " year: \n" + printAllUntil(AntiquarBuecher.getRoot(), year);
    }

    private String printAllUntil(BinNodeGen<Book> k, int year) {
        if (k == null)
            return "";
        if (k.data.getJahr() <= year) {
            String s = k.data.toString() + "\n" + (k.left == null ? "" : AntiquarBuecher.print(k.left));
            if (k.data.getJahr() == year)
                return s;
            return s + printAllUntil(k.right, year);
        } else return printAllUntil(k.left, year);
    }

    @Override
    public String toString() {
        return "BookCatalogue " + AntiquarBuecher;
    }
}
