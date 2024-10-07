package io;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class StopWordsMain {
    public static void main (String[] args) throws IOException, FileNotFoundException{
        
            String uniqueWords = args[0];
            String stopWords = args[1];
            String outputFile = args[2];

            // Read unique words
            FileReader uwReader = new FileReader(uniqueWords);
            BufferedReader buwReader = new BufferedReader(uwReader);

            List<String> uwList = new ArrayList<>();
            String line = "x";
            while (line != null){
                if (line == null) break;
                uwList.add(line.trim());
                line = buwReader.readLine();
            }

            buwReader.close();


            //Read Stop Words
            FileReader swReader = new FileReader(stopWords);
            BufferedReader bswReader = new BufferedReader(swReader);
            Set<String> swSet = new HashSet<>();
            line ="x";
            while (line != null) {
                if (line == null) break;
                swSet.add(line.trim());
                line = bswReader.readLine();
            
            }

            bswReader.close();

            // Remove the Stop Words
            List<String> filteredWords = new ArrayList<>();
            for( String word: uwList){
                if(!swSet.contains(word)){
                    filteredWords.add(word);
                }
            }

            // Sort words in alphabetical order
            Collections.sort(filteredWords);

            // Write the file
            FileWriter writer = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String word: filteredWords){
                bufferedWriter.write(word);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

    }
}
