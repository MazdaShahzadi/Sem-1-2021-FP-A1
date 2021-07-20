package Library;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DaintreeUnitTest {

	//Basic unit tests on some methods used in the Daintree system. 
	//Used basic asserEquals with expected value to check if methods work properly.
	@Test
	public void isEmptyTest() {
		Book b3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman",  5, false);
		Book[] shoppingCart = new Book[1];
		shoppingCart[0] = b3;
		boolean result = isEmpty(shoppingCart);
		assertEquals(false, result);
		
	}
	
	public boolean isEmpty(Book[] bookCollection) { //added method call since won't be able to access since in Daintree class
		if(bookCollection == null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Test
	public void getAuthorTest() {
		Book b3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman",  5, false);
		String authorName = b3.getAuthor();
		assertEquals("Horstman", authorName);
	}
	
	@Test
	public void reduceNumberBookTest() {
		Book b3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman",  5, false);
		b3.reduceNumberBook();
		int numBook = b3.getNumberBook();
		assertEquals(4, numBook);
	}
	
	
	
	
	
}
