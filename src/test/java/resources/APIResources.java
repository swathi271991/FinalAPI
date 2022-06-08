package resources;

public enum APIResources {
	
	AddPlaceAPI("/Library/Addbook.php"),
	getPlaceAPI("/Library/GetBook.php"),
	deletePlaceAPI("/Library/DeleteBook.php");
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
		
	}

}
