package DFS_BFS;

public class Word_Ladder_127 {
	//One end, BFS, Queue,  71ms
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList); //change List to Set
        
        //Set<String> visit=new HashSet<>(); //If wordList can NOT be changed, use visited set
        
        if(!dict.contains(endWord)) return 0;
        Deque<String> que=new ArrayDeque<>();
        que.offer(beginWord);
        //visit.add(beginWord);
        dict.remove(beginWord);
        int length=1;   // counting the start
        while(!que.isEmpty()){
            for(int i=que.size();i>0;i--){
                String word=que.poll();
                if(word.equals(endWord)) return length; //Exist when word==endWord
               
                char[] wordArr=word.toCharArray();
                for(int j=0;j<word.length();j++){
                    char old=wordArr[j]; //record this letter
                    for(char k='a';k<='z';k++){
                    	//if(k==wordArr[j]) continue; //skip duplicate
                        wordArr[j]=k;
                        String str=new String(wordArr);
                        if(dict.remove(str)) que.offer(str);
                                              
                        
                        // if(dict.contains(str)&&visit.add(str)){
                        //     que.offer(str);  // If wordList can NOT be changed, use visited set
                        // }
                        
                        
                    }
                    wordArr[j]=old;
                }
            }
            length++;
        }
        return 0;
    }
    
    //Two-End, much faster, 21ms
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList); //change List to Set
        if(!dict.contains(endWord)) return 0;
        Set<String> start=new HashSet<>();
        Set<String> end=new HashSet<>();
        Set<String> visit=new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        int length=2; // counting the start and end word
        while(!start.isEmpty()){
            if(start.size()>end.size()){ //swap,always use smaller one to search
                Set<String> temp=start;
                start=end;
                end=temp;
            }
            Set<String> next=new HashSet<>();
            for(String str:start){ //for each word
                char[] arr=str.toCharArray();
                for(int i=0;i<str.length();i++){ //for each letter
                    char old=arr[i];
                    for(char j='a';j<='z';j++){
                        if(j==arr[i]) continue; //avoid duplicate
                        arr[i]=j;
                        String word=new String(arr);
                        if(end.contains(word)) return length; //Exit when start meet end, in end means in dict
                        if(dict.contains(word)&&visit.add(word)) next.add(word); //in dict and not visited
                    }
                    arr[i]=old;
                }
            }
            start=next;
            length++;
        }
        return 0;
    }
}
