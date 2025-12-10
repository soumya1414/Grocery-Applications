package constants;
public class Constant {	
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx" ;
	public static final String VALIDCREDNETIAL="user was unable to login with valid credentials";//login page
	public static final String INVALIDCREDNETIAL="user was able to login with valid username";//login page
	public static final String INVALIDCREDNETIAL1="user with invalidUserNameAndValidPassword";//login page
	public static final String INVALIDCREDNETIAL2="user with validUserNameAndInvalidPassword";//login page
	public static final String VALIDSUCESSFULLY="user log out successfully";//home page
	public static final String NEWSUCESS="New user not added successfully";//admin user
	public static final String SEARCHUSER="User was unable to search the added user";//admin user
	public static final String UNABLERESET="User unable to reset search filters";//admin user
	public static final String NEWSNOT="News was not added successfully";//manage news
	public static final String USERUNABLE="User unable to search the added news";//manage news
	public static final String USERSEARCH="User unable to reset search filters";//manage news
}
