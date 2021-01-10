package main.java.Utilities;

import org.testng.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTextData {
    private static final String CVPATH = "src/main/resources/File/car_input.txt";
    private static final String OUTPUT = "src/main/resources/File/car_output.txt";

    public static List<String> readFile() throws Exception {
        File originalFile = new File(CVPATH);
        List<String> regNo = new ArrayList<>();
        Matcher matcher;

        int i=1 ;

        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        String line ;

        while ((line = br.readLine()) != null) {
            final String regex = ("[(A-Z0-9\\s]{8,9}");// print car regNo
            Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);//check pattern as per regex
             matcher = pattern.matcher(line);

            while (matcher.find()) {
                System.out.println("Full match: " + matcher.group(0));
                regNo.add(matcher.group(0));// store regNo in array's

                for ( i = 1; i <= matcher.groupCount(); i++) {
                    System.out.println("Group " + i + ": " + matcher.group(i));

                }
            }

        }


        return regNo;
    }

    public static void compareOutputData(String regNo,String make,String model,String colour,String year) throws IOException {

        File originalFile = new File(OUTPUT);


        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        String line = null;


        while ((line = br.readLine()) != null) {
            if (line.contains(regNo) && line.contains(make) && line.contains(model) && line.contains(colour) && line.contains(year)) {
                System.out.println(line);
                break;
            }else
                if (null == br.readLine()){
                    Assert.fail("Car Details for: " + regNo + " Doesnt Match");
                }




        }

        }

    }




