package io;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class WordsCountMain{



    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String inputFile = args[0];
        String outputFile = args[1];

        //Open FileReader to read file
        FileReader reader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(reader);

        //Create a map
        Map<String, Integer> uniqueWords = new HashMap<>();

        // Open outputFile for writing
        FileWriter writer = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);


        String line = "x";
        while (null != line){
            // Read a line
            line =bufferedReader.readLine();
            

            // If line is null, we have reached the EOF
            if (null == line){
                break;
            }

            // Write to file
            // To UpperCase and Remove Punctuation
            String transformed = line.replaceAll("[\\p{Punct}]","").toLowerCase().trim();

            for (String word: transformed.split(" ")){

                int currentCount = 0;
                if(uniqueWords.containsKey(word)){
                    currentCount = uniqueWords.get(word);
                }

                currentCount++;

                uniqueWords.put(word, currentCount);

                /* 
                if (uniqueWords.containsKey(word)){
                    // Word is in the list
                    int currentCount = uniqueWords.get(word);
                    currentCount++;
                    uniqueWords.put(word, currentCount);
                } else{
                    // Word is in the list
                    uniqueWords.put(word, 1); 
                }
                */
            }
            writer.flush();
        }

        //Close the files
        reader.close();

        System.out.println();
        // Print out the keys set in alphabetical order
        for (String word: uniqueWords.keySet()){
            System.out.printf("%s = %d\n", word, uniqueWords.get(word));
            bufferedWriter.write(word + " = " + uniqueWords.get(word) + "\n");
        }

        bufferedWriter.close();

    }

}