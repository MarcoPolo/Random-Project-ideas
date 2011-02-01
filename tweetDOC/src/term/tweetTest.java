package term;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;



public class tweetTest {
	public static void main(String[] args) throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		String reqtokString;
		String acctokString;
			try{
		File reqtok = new File("/home/marco/workspace/tweetDOC/reqtok.txt");
		FileInputStream fis = new FileInputStream(reqtok);
		FileReader fileRead = new FileReader(reqtok);
		BufferedReader buffile = new BufferedReader(fileRead);
		//BufferedInputStream bis = new BufferedInputStream(fis);
		//DataInputStream dis = new DataInputStream(bis);
			while(fileRead.read() != -1){
			System.out.println(buffile.readLine());
			reqtokString=String.valueOf(fileRead.read());
			}
		
		
		
		}catch(FileNotFoundException e){
			System.err.println("Where's the file mister??");
		}catch(IOException ee){
			System.err.println(ee.getMessage());
		}
		
		String ConsumerKey="T1gmxhioYBn3UPGBl8Z0yQ";
		String ConsumerSecret="TZjKHtfWMkv0NWIaIsgaya8G1x8BW6to4SMtpjQ";
		
	//	AccessToken accessToken = null;
	/*	cb.setUser("YYBOT3020");
		cb.setPassword("statistics");
		cb.setOAuthConsumerKey("");
		cb.setOAuthConsumerSecret("");
		cb.setOAuthAccessToken("rnAWTOneQCPpel6LUGf9TcIS4cI7onAGgZZ02E87w");
		cb.setOAuthAccessTokenSecret("xaIwy31UQ7wlC7q8d8svLC5ng9jUwHIsNteeUxcLSg");
		//cb.setOAuthAccessToken("Whmk4VkhZVU10OyH8VZ8VKlx9kesyVGojX4GKCs");
		//cb.setOAuthAccessTokenSecret("vNEhIC25OPRVkPHMHUImY627GIwEyyZ79V6PfLqJKA");
	//	factory instance is re-useable and thread safe.
	 */
		TwitterFactory tfup = new TwitterFactory();
	    Twitter twitter = tfup.getInstance();
	    twitter.setOAuthConsumer(ConsumerKey, ConsumerSecret);
	    RequestToken twitterRequestToken = twitter.getOAuthRequestToken();
	    String token = twitterRequestToken.getToken();
	    String tokenSecret = twitterRequestToken.getTokenSecret();
	    AccessToken accesstok = twitter.getOAuthAccessToken(token, tokenSecret);
	    twitter.setOAuthAccessToken(accesstok);
	    //System.out.println(token);
	    //System.out.println(tokenSecret);
	    int id = accesstok.getUserId();
	    
	    User user = twitter.showUser(id+"");
	    String screenName = user.getScreenName();
	    String latestStatus="Hello World v4!";
		Status status = twitter.updateStatus(latestStatus);
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");

	}
}
