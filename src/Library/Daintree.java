package Library;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Daintree {
	
	// create daintree method for daintree object so can run on main of BookStore class
	public void dainTreeSystem(){
		
		//create book array for shoppingcart for user + set total price to 0 to use later to record price
		Book[] shoppingCart = new Book[1];
		int totalPrice = 0; 
		
		//manually create book objects to add to linked list type book called "avaliable".
		Book b1 = new Book("Absolute Java", "Savitch", 5, true);
		Book b2 = new Book("JAVA: How to Program", "Deitel and Deitel", 0, true);
		Book b3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman",  5, false);
		Book b4 = new Book("Java Software Solutions", "Lewis and Loftus",  5, false);
		Book b5 = new Book("Java Program Design","Cohoon and Davidson" , 1, true);
		
		LinkedList<Book> avaliable = new LinkedList<Book>();
		
		avaliable.add(0,b1);
		avaliable.add(1,b2);
		avaliable.add(2,b3);
		avaliable.add(3,b4);
		avaliable.add(4,b5);
		
		// basic menu for daintree print options on menu + use scanner to record their inputs
		System.out.println("Welcome to Daintree!\n"
							+ "Choose an option: ");
		
		@SuppressWarnings("resource") // from "scan" object
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. Add a book to shopping cart \n" + 
				           "2. View shopping cart\n" + 
				           "3. Remove a book from shopping cart\n" + 
				           "4. Checkout\n" + 
				           "5. List all books\n" + 
				           "0. Quit\n" + "");
		
		// print out use input with scanner
		int option = -1;
		try {
		option = Integer.parseInt(scan.nextLine());
		}catch (NumberFormatException e1) {
			System.out.println(e1);
		}
		System.out.println("Please make a selection: " + option);
		System.out.println();
		
		//use input from scanner to create if branches for different function of daintree menu
		
		if(option == 1 ) {
			//"Add a book to shopping cart"
			
			// set some vairables to be used to keep track of indexes and loop numbers
			// scan the input to search in "search" variable
			System.out.println("Enter the title to search for: ");
			String search = scan.nextLine();
			search = search.toUpperCase();
			
			int indexNum = 0;
			int loopNum = 0;
			int match = 1;
			
			// create integer arraylist to record number of loops to use to keep track of original index of books
			ArrayList<Integer> indexBook=new ArrayList<Integer>();
			
			// create for loop to check begining of each book title and use .starts with to match use input and title if match both uppercase so not case sensitive.
			for (int i = 0 ; i <avaliable.size();i++) {
				
				String upperTitle = avaliable.get(i).getTitle().toUpperCase();				
				if(upperTitle.startsWith(search) ) {
					System.out.println((loopNum +1) +". " + avaliable.get(i).getTitle() + " -- " + avaliable.get(i).getAuthor());
					indexBook.add(indexNum);					
					loopNum ++;
				}
				indexNum++;
			
				// check if match array are empty 
			} if(indexBook.isEmpty()) { 
				System.out.println("There is no title starting with that");
				
			}else {
			System.out.println("0. cancel");
			System.out.println("Which number item do you wish to purchase: ");	
			
			// create loop so based on different input purchase different book. original index stored in indexBook array
			for(int j = 0; j < avaliable.size();j++) {
				int optionBuyBook = scan.nextInt();
				
				// simple if else statements to go through if you want to buy physical book or ebook and check if avaliable
				if((optionBuyBook >= 1 && optionBuyBook <= 3)  && match == 1) {
						                              
					System.out.println("Purchasing: " + avaliable.get( indexBook.get(optionBuyBook -1 )).getTitle());
					System.out.println("Do you want to buy this as an ebook:");
					String buyBook = scan.next();
					
															
					if(buyBook.equals("no") && avaliable.get(indexBook.get(optionBuyBook -1)).getNumberBook() > 0 )  {
						avaliable.get(j).reduceNumberBook();
						shoppingCart[0] = avaliable.get(indexBook.get(optionBuyBook -1 )) ;
						System.out.println("\"" + avaliable.get(indexBook.get(optionBuyBook -1 )).getTitle() + "\"" + " has been added to your Cart");
							
					}
					else if (buyBook.equals("yes") && avaliable.get(indexBook.get(optionBuyBook -1 )).getAvaliableEBook() == true) {
							
						shoppingCart[0] = avaliable.get(indexBook.get(optionBuyBook -1 )).buyEBook(avaliable.get(j));// try make book type ebook version true attribute.
						//System.out.println(shoppingCart[0].getBuyEBook()); check change boolean BuyEbook to true.	
						System.out.println("\"" + avaliable.get(indexBook.get(optionBuyBook -1 )).getTitle() + "\"" + " eBook version has been added to your Cart");
							
					}												
					else if (buyBook.equals("no") && avaliable.get(indexBook.get(optionBuyBook -1)).getNumberBook() == 0){
							System.out.println("There are no physical copies of that book avaliable!");
					}	else {
							System.out.println("Invalid input");
						}
						
				}else {
					throw new RuntimeException("This is an invalid input not in accepted range of values");
					
				}
				match = 0;
					
					}
				
				}			
			
		}
	
		else if(option == 2 ) {
			//"View shopping cart" 
			
			// check shopping cart not null to display error you have no books
			if (shoppingCart[0] == null) {
				System.out.println("You have no books");
			}
			// standard print book of shopping cart for user
			else {
				System.out.println("Your Shopping Cart contains the following:");
				System.out.println("1. " + shoppingCart[0].getTitle());
			}
			
			
		}
		
		else if(option == 3 ) {
			// remove a book from shopping cart 
			shoppingCart[0] = b2;
			//check shopping cart not null then remove book based on index 0
			System.out.println("Your Shopping Cart contains the following:");
				
			if (shoppingCart[0] != null) {
				System.out.println("1. " + shoppingCart[0].getTitle());
				System.out.println("0. cancel");
				System.out.println("What do you want to remove: ");
				int removeNum = scan.nextInt();
			
				if (removeNum == 1 && shoppingCart.length > 0) {
			
					System.out.println("Item removed from Shopping Cart");
					shoppingCart[0] = null;
					
				}	
				else if (removeNum == 0) {
					System.out.println("You have canceled");
				}
				
				else {
					System.out.println("Invalid input");
				}
			}
			
			else {
				System.out.println("You have no books in shopping cart");
			}
		}
			
		else if(option == 4 ) {
			// checkout. 
			
			// check not null to get price based on book attribute getPysicalBookPrice and getEBookPrice.
			if (shoppingCart[0] != null) {
				totalPrice = shoppingCart[0].getPhysicalBookPrice();
				
				if(shoppingCart[0].getBuyEBook() == true) {
					totalPrice = shoppingCart[0].getEBookPrice();
					System.out.println("You have purchased items to the total value of $" + totalPrice );
					System.out.println("thanks for shopping at Daintree!");
					
				}else {
					System.out.println("You have purchased items to the total value of $" + totalPrice );
					shoppingCart[0].reduceNumberBook();
					System.out.println("thanks for shopping at Daintree!");
				}
			}
			else if (totalPrice == 0) {
				System.out.println("You have no books to checkout");
			}
				
		 }
	
		else if(option == 5 ) {
			//"List all books"
			
			System.out.println("The following titles are avaliable:");
			listAll(avaliable);// use listAll method to print all books in main "avaliable" book arrayList
			
			
		}
		// cancel option in menu
		else if(option == 0) {
			System.out.println("Goodbye!");
			
		}
		// try check for error on menu
		else {
			
			System.out.println("Sorry, that is an invalid option!");
		}
							
	}
	//methods to help clean up code and reduce redundancy
	public boolean isEmpty(Book[] bookCollection) {
		if(bookCollection == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void listAll(LinkedList<Book> collection) {
		for(int i = 0; i < collection.size(); i++) {
			System.out.println((i+1) + ". " + collection.get(i).toString());
		}
	}
}
