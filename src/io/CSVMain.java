package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CSVMain {

    public static void main(String[] args) throws IOException, FileNotFoundException{

        String file = args[0];
        String outputFile = args[1];
        List<String[]> data = new ArrayList<>();

        // Read CSV File
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);

        // Loop through to read each line in the csv file
        String line ="x";
        while ((line =bReader.readLine()) != null){
            String[] row = line.split(",");
            data.add(row);
            line =bReader.readLine();
        }
        bReader.close();

        // Use a HashMap to store the highest and lowest rated apps per category
        Map<String, AppRating> appRatings = new HashMap<>();

        for (String[]row : data){
            // Use "if(row.length <3 ) continue;" if there are columns missing
            String category = row[1];
            String appName = row[0];
            double rating = 0;

            // Check if the rating is a valid number

            boolean validRating = row[2].matches("-?\\d+(\\.\\d+)?"); //Regex to check if there is a valid number
            if (validRating){
                rating = Double.parseDouble(row[2]);
            } else {
                System.out.println("Invalid rating format for app: " + appName);
                continue;
            }

            // initialise or update the app Ratings for the category
            appRatings.putIfAbsent(category, new AppRating(appName, rating, appName, rating));

            AppRating current = appRatings.get(category);
            if( rating > current.highestRating){
                current.highestRatedApp = appName;
                current.highestRating = rating;
            }
            if(rating < current.lowestRating){
                current.lowestRatedApp = appName;
                current.lowestRating = rating;
            }

            // Update total and count for average calculation
            current.totalRating += rating;
            current.count++;
        }

        // Write results to a text file
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        // Loop through each entry in the appRatings map
        for (Map.Entry<String, AppRating> entry : appRatings.entrySet()){
            String category = entry.getKey();
            AppRating rating = entry.getValue();
            double averageRating = rating.totalRating / rating.count; // Calculate average rating
            writer.write("Category: " + category);
            writer.newLine();
            writer.write("Highest Rated: " + rating.highestRatedApp + " (" + rating.highestRating + ")");
            writer.newLine();
            writer.write("Lowest Rating: " + rating.lowestRatedApp + " (" + rating.lowestRating + ")");
            writer.newLine();
            writer.write("Average Rating: " + averageRating);
            writer.newLine();
            writer.newLine();
        }

        writer.close();

    }

    static class AppRating {
        String highestRatedApp;
        double highestRating;
        String lowestRatedApp;
        double lowestRating;
        double totalRating;
        int count;

        AppRating(String highestRatedApp, double highestRating, String lowestRatedApp, double lowestrating){
            this.highestRatedApp = highestRatedApp;
            this.highestRating = highestRating;
            this.lowestRatedApp = lowestRatedApp;
            this.lowestRating = lowestRating;

        }
    }

}