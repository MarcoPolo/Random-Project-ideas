package tweetDoc;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareDoc compare= new CompareDoc();
		String difference = compare.compare("/home/marco/idea/STA3032diff.doc", "/home/marco/idea/STA3032.doc");
		System.out.println(difference);
		
		
	}

}
