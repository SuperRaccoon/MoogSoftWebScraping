import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class TextProcessor {

    //main control flow
    public void processAndPrintText(ArrayList<String> textFiles, int numberEntries) {
        HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
        TextProcessor sample1 = new TextProcessor();

        //processing steps for each file
        for(String textFile: textFiles) {
            String filename = "./" + textFile;
            File file = new File(filename);
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // process the line.
                    line = line.replaceAll("[ ]*[\r\n\t]+[ ]*", "");
                    dictionary = sample1.wordCounter(line.toLowerCase(), dictionary);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        dictionary = sample1.removeCommonWords(dictionary);
        dictionary.remove(" "); // i keep getting a bug where it reads newlines
        SortedMap<Double, String> mySortedList = sample1.shrinkList(dictionary, numberEntries);


        //below code is just to reverse to set to make it look nicer
        Set<Double> myset =  mySortedList.keySet();
        List list = new ArrayList(myset);
        Collections.sort(list, Collections.reverseOrder());
        myset = new LinkedHashSet(list);

        //print out keywords
        System.out.println("Printing out top " + numberEntries+ " keywords");
        for(Double s: myset){
            //System.out.println(StringEscapeUtils.escapeJava(mySortedList.get(s));
            System.out.println("keyword: \"" + mySortedList.get(s) +"\" found " + s.intValue()+ " times");
        }


    }



    //cuts the dictionary down to the specified number of Entries
    public SortedMap<Double, String> shrinkList(HashMap<String, Integer> dictionary, int numberEntries){
        TreeMap<Double, String> tree= new TreeMap<>();//TreeMaps are more efficient to traverse, keys are the frequency
        //iterate over a map
        Iterator<String> it= dictionary.keySet().iterator();
        while (it.hasNext()) {
            String key= it.next();
            if (tree.containsKey(dictionary.get(key).doubleValue())) {
                tree.put(dictionary.get(key) + Math.random(), key);
            }
            else{
                tree.put( dictionary.get(key).doubleValue(), key);
            }
        }

        Double toKey = null;
        int k = 0;
        for (Double key : tree.descendingKeySet()) {
            if (k++ == numberEntries) {
                toKey = key;
                break;
            }
        }

        SortedMap<Double, String> shrunkMap = tree.tailMap(toKey);

        return shrunkMap;
    }

    //parses the document and counts the words
    public HashMap<String, Integer> wordCounter(String sentence, HashMap<String, Integer> dictionary){
        ////counts all words in a string and stores the counts in a dictionary
        String[] delimitedString = sentence.split("[\\p{Punct}\\s]+");;//we assume words are separated by grammar marks
        for(int i = 0; i < delimitedString.length; i++) {
            if(delimitedString[i].length() > 1) {// kinda janky but i figure anything less than 1 character isn't a keyword


                if (dictionary.containsKey(delimitedString[i])) {
                    dictionary.replace(delimitedString[i], dictionary.get(delimitedString[i]) + 1);
                } else {
                    dictionary.put(delimitedString[i], 1);
                }
                continue;
            }
        }

        return dictionary;
    }


    //here i took the top 20 most common words in the english language and remove them
    //from https://github.com/first20hours/google-10000-english/blob/master/20k.txt
    public HashMap<String, Integer> removeCommonWords(HashMap<String, Integer> dictionary){
        String commonWords = "the s of and to a in for is on that by this with i you it not or be are from at as your all have new more an was we will '\n' '\r\n' ";
        String[] delimitedString = commonWords.split("[\\p{Punct}\\s]+");;//we assume words are separated by grammar marks
        for(int i = 0; i < delimitedString.length; i++) {
            dictionary.remove(delimitedString[i]);
        }
        dictionary.remove(" ");
        return dictionary;
    }
}
