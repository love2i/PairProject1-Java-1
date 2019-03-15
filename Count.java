package WordCount;


import java.util.*;
import java.util.Map.Entry;
public class Count 
{ 
	public static int getCharCount(String content) // ͳ���ַ���
	 { 
	 char c; 
	 int charNum = 0; 
	 for (int i = 0; i < content.length(); i++) 
	   { 
	    c = content.charAt(i); //���ַ���ת��Ϊ�ַ����� 
	    if (c >= 32 && c <= 126 || c == '\r' || c == '\n'|| c == '\t') { 
	    charNum++; 
	   } 
	 } 
	 return charNum; 
	 } 

	public static int getLineCount(String content)throws Exception // ͳ����Ч����
	 {  

	  int lineNum = 0; 
	  String[] line = content.split("\r\n"); // ��ÿһ�зֿ�����һ���ַ������� 
	  for (int i = 0; i < line.length; i++) 
	  { // �ҳ���Ч�У�ͳ����Ч�� 
	  if (line[i].trim().length() == 0) 
	  continue; 
	  lineNum ++; 
	  } 
	  return lineNum; 
	 } 

	 public static String[] getWordGroup(String content) 
	 { 
		 content = content.replace('\r', ' '); 
		 content = content.replace('\r', ' '); 
		 content = content.replace('\r', ' '); 
		 String [] wordgroud = content.split(" "); 
         return wordgroud; 
	 } 

	 public static int getWordsNum(String text) 
	 { 
		 String content = text.replace('\r', ' '); 
		 content = text.replace('\b', ' '); 
		 content = text.replace('\n', ' '); 
		 String [] words = content.split(" "); 
		 int wordCount = 0; 
		 for(int i= 0; i<words.length;i++) 
		 { 
            if (words[i].length()<4) 
            	continue; 
			 int j = 0; 
			 for( j =0;j<4;j++) 
			 { 
				 char c =words[i].charAt(j); 
				 if(!((c>='A'&& c<='Z')||(c>='a'&& c<='z'))) 
				 break; 	 
			 } 

			 if(j==4) 
			wordCount++; 
		 } 
		 return wordCount; 
	 } 

	 public static String getWordFreq(String text) // ͳ��ǰ10������Ƶ�� 

	 { 

		 HashMap<String, Integer> wordFreq = new HashMap<String, Integer>(); 
		 String content = text.replace('\r', ' '); 
		 content = text.replace('\b', ' '); 
		 content = text.replace('\n', ' '); 
		 String [] wordgroud = content.split(" "); 

		 for(int i= 0; i<wordgroud.length;i++) 

		 { 

			 if (wordgroud[i].length()<4) 
				 continue; 
			 int j = 0; 
			 for(j =0;j<4;j++) 
			 { 
				 char c =wordgroud[i].charAt(j); 
				 if(!((c>='A'&& c<='Z')||(c>='a'&& c<='z'))) 
				 break; 
			 } 
			 if(j==4) 
			 { 
				wordgroud[i] = wordgroud[i].trim().toLowerCase(); // ���ַ���ת��ΪСд 
                if (wordFreq.get(wordgroud[i]) == null) 
	               { // �ж�֮ǰMap���Ƿ���ֹ����ַ��� 
	              wordFreq.put(wordgroud[i], 1); 
	                 } 
               else 
               wordFreq.put(wordgroud[i], wordFreq.get(wordgroud[i]) + 1); 
			 } 
		 } 
		 List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(wordFreq.entrySet());
		 Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
	            public int compare(Map.Entry<String, Integer> o1,
	                               Map.Entry<String, Integer> o2) {
	                if (o1.getValue() == o2.getValue()) {
	                    return o1.getKey().compareTo(o2.getKey());
	                }
	                return -(o1.getValue() - o2.getValue());
	            }
	        });
	   StringBuilder sb = new StringBuilder();
	        // The output frequency
	        for (int i = 0; i < infoIds.size() && i < 10; i++) {
	            sb.append("<" + infoIds.get(i).getKey() + ">: " + infoIds.get(i).getValue() + "\r\n");
	        }
	        return sb.toString();
	 } 

	 

	 

	 

	 

	 

	 

}


