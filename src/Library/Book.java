package Library;



public class Book {
	// attributes for book class
	private String title;
	private String author;
	private int numberBook;
	private boolean avaliableEBook;
	private int physicalBookPrice = 50;
	private int eBookPrice = 8;
	private boolean eBookVersion = false;
	
	// constructor to populate variable of book class
	public Book(String title,String author, int numberBook, boolean avaliableEBook) {
		this.title = title;
		this.author = author;
		this.numberBook = numberBook;
		this.avaliableEBook = avaliableEBook;
	}
	
	//toString method to print all variables for book
	public String toString() {
		
		String eBookAvaliable = (avaliableEBook == true) ? "ebook avaliable" : "no ebook"; 
		String checkSingleCopy = (numberBook == 1)? "copy": "copies";
		return (title + ", " +  author +", " + numberBook + " "+ checkSingleCopy + ", " + eBookAvaliable);
	}
	
	//simple getter setter methods to return or change variables values
	public String getTitle() {
		return title;
	}
	
	public int getNumberBook() {
		return numberBook;
	}
	
	// to reduce number of copies of book when checkout
	public void reduceNumberBook() {
		numberBook--;
	}
	
	public int getPhysicalBookPrice() {
		return physicalBookPrice;
	}
	
	public int getEBookPrice() {
		return eBookPrice;
	}
	
	public boolean getAvaliableEBook() {
		return avaliableEBook;
	}
	
	// to show this book is eBook boolean switch from original
	public Book buyEBook(Book book) {
		eBookVersion = true;
		return book;
	}
	
	public boolean getBuyEBook() {
		return eBookVersion;
	}
	
	public String getAuthor() {
		return author;
	}


}
