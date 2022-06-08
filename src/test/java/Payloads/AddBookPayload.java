package Payloads;

import org.apache.commons.lang3.RandomStringUtils;

import PoJos.AddBookPojo;

public class AddBookPayload {
	
	
	public static AddBookPojo addBook(String isbn, String aisle, String authorname)
	{
		//String isbnvalue = RandomStringUtils.randomAlphanumeric(4);
		//String aisleval = RandomStringUtils.randomNumeric(4);
		
		
		int aisleval = Integer.parseInt(aisle);
		
		AddBookPojo ab = new AddBookPojo();
		
		ab.setName("New Automation Java");
		ab.setIsbn(isbn);
		ab.setAisle(aisleval);
		ab.setAuthor(authorname);
		
		return ab;
	}

	
	public static String deleteBook(String id)
	{
		return "{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+id+"\"\r\n" + 
				" \r\n" + 
				"} ";
	}
	
}
