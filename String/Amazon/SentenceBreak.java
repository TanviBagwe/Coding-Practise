package Practise.Test.Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SentenceBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> results =breakSentenceSmart("the quick brown fox jumps over the lazy dog", 10);
		if(null != results && !results.isEmpty()){
			int n = results.size();
			for(int i=0;i<n;i++){
				System.out.println(" \n" + results.get(i));
			}
		}
	}
	
	public static List<String> breakSentenceSmart(String text, int maxWidth) {

	    StringTokenizer stringTokenizer = new StringTokenizer(text, " ");
	    List<String> lines = new ArrayList<String>();
	    StringBuilder currLine = new StringBuilder();
	    while (stringTokenizer.hasMoreTokens()) {
	        String word = stringTokenizer.nextToken();

	        boolean wordPut=false;
	        while (!wordPut) {
	            if(currLine.length()+word.length()==maxWidth) { //exactly fits -> dont add the space
	                currLine.append(word);
	                wordPut=true;
	            }
	            else if(currLine.length()+word.length()<=maxWidth) { //whole word can be put
	                if(stringTokenizer.hasMoreTokens()) {
	                    currLine.append(word + " ");
	                }else{
	                    currLine.append(word);
	                }
	                wordPut=true;
	            }else{
	                if(word.length()>maxWidth) {
	                    int lineLengthLeft = maxWidth - currLine.length();
	                    String firstWordPart = word.substring(0, lineLengthLeft);
	                    currLine.append(firstWordPart);
	                    //lines.add(currLine.toString());
	                    word = word.substring(lineLengthLeft);
	                    //currLine = new StringBuilder();
	                }
	                lines.add(currLine.toString());
	                currLine = new StringBuilder();
	            }

	        }
	        //
	    }
	    if(currLine.length()>0) { //add whats left
	        lines.add(currLine.toString());
	    }
	    return lines;
	}

}
