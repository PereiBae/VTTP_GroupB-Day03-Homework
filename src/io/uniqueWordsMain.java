package io;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class uniqueWordsMain{

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String inputFile = args[0];
        String outputFile = args[1];

        //Open FileReader to read file
        FileReader reader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(reader);

        // Open outputFile for writing
        FileWriter writer = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        // Create a set of String
        Set<String> uniqueWords = new HashSet<>();


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
                uniqueWords.add(word);
            }
            //  String[] words = transformed.split(" ")
            writer.flush();
        }

        //Close the files
        reader.close();

        System.out.printf("Unique words in %s: %d\n", inputFile, uniqueWords.size());

        for (String word: uniqueWords){
            System.out.printf("%s, ", word);
            bufferedWriter.write(word + "\n");
        }

        bufferedWriter.close();

        System.out.println();

    }

}