package term;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;

public class Tweetauth {
	 public static void main(String args[]) throws Exception{
		    // The factory instance is re-useable and thread safe.
		    Twitter twitter = new TwitterFactory().getInstance();
		    twitter.setOAuthConsumer("T1gmxhioYBn3UPGBl8Z0yQ", "TZjKHtfWMkv0NWIaIsgaya8G1x8BW6to4SMtpjQ");
		    RequestToken requestToken = twitter.getOAuthRequestToken();
		    AccessToken accessToken = null;
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    while (null == accessToken) {
		      System.out.println("Open the following URL and grant access to your account:");
		      System.out.println(requestToken.getAuthorizationURL());
		      System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
		      String pin = br.readLine();
		      try{
		         if(pin.length() > 0){
		           accessToken = twitter.getOAuthAccessToken(requestToken, pin);
		         }else{
		           accessToken = twitter.getOAuthAccessToken();
		         }
		      } catch (TwitterException te) {
		        if(401 == te.getStatusCode()){
		          System.out.println("Unable to get the access token.");
		        }else{
		          te.printStackTrace();
		        }
		      }
		    }
		    String latestStatus="Hello World, again... and again...";
		    	try{
		    		FileWriter accstok = new FileWriter("accesstok.txt");
		    		FileWriter reqtok = new FileWriter("reqtok.txt");
		    		BufferedWriter accOut = new BufferedWriter(accstok);
		    		BufferedWriter reqOut = new BufferedWriter(reqtok);
		    		accOut.write(String.valueOf(accessToken));
		    		reqOut.write(String.valueOf(requestToken));
		    		accOut.close();
		    		reqOut.close();
		    	}catch(Exception e){
		    		System.err.println("Sorry aboot that, this is what happened" + e.getMessage());
		    	}
			Status status = twitter.updateStatus(latestStatus);
		    System.out.println("Successfully updated the status to [" + status.getText() + "].");
		    System.out.println(accessToken);
		    System.out.println(requestToken);
}
}