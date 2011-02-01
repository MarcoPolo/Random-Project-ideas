package term;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
 
       public static void main(String args[]) {
    	   String diff="";
            try {
                Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec("catdoc /home/marco/idea/STA3032diff.doc");
                Process prCompare = rt.exec("catdoc /home/marco/idea/STA3032.doc");
 
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                BufferedReader inputCompare = new BufferedReader(new InputStreamReader(prCompare.getInputStream()));
                String line=null;
                String lineCompare=null;
               // String diff="";
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
                }else{
                //	System.out.println(diff);

                }
                
 
                int exitVal = pr.waitFor();
               // System.out.println("Exited with error code "+exitVal);
                System.out.println("Done");
                //if()
            } catch(Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        
       System.out.println(diff);
      // Api tweetMe = Api.builder().username("yybot3020").password("statistics").build();
       // tweetMe.updateStatus("Hello").build().post();
       }
       
}