package tweetDoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CompareDoc {
	
	public String compare(String nVersion, String oVersion){
		String diff="";
        try {
            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("cmd /c dir");
            ///home/marco/idea/STA3032diff.doc
            Process pr = rt.exec("catdoc " + nVersion);
            Process prCompare = rt.exec("catdoc " + oVersion);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            BufferedReader inputCompare = new BufferedReader(new InputStreamReader(prCompare.getInputStream()));
            String line=null;
            String lineCompare=null;
            while((line=input.readLine()) != null) {
            	lineCompare=inputCompare.readLine();
           //     System.out.println(line);
             //   System.out.println(lineCompare);
                if(line.equals(lineCompare)){
              //  	System.out.println("Same");
                }else{
                	diff=diff+line;
                	//System.out.println(line);
                }
              //  diff=diff+line;
             //  System.out.println(diff);
            }
            if (diff.length()>160){
            	System.out.println("tl;dr");
            }
            int exitVal = pr.waitFor();
           // System.out.println("Exited with error code "+exitVal);
            System.out.println("Done");
            //if()
        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return diff;
	}

}
