package home.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadLog {
    StringDataParsing stringDataExtraction = new StringDataParsing();
    ObjectBuffer object = new ObjectBuffer(null,null,null,null);
    ArrayList<ObjectBuffer> objects = new ArrayList<ObjectBuffer>();
    public void readFromLog (String pathToLog) throws Exception {
        try {
            File myLogFile = new File(pathToLog);
            Scanner fileReader = new Scanner(myLogFile);
            while (fileReader.hasNextLine()) {
                String stringFromLogFile = new String();
                stringFromLogFile = fileReader.nextLine();
                if (!stringFromLogFile.equals("   --- End of inner exception stack trace ---")) {
                    String[] arrOfStr = stringFromLogFile.split(":",2);
                    String dateAndTime = arrOfStr[0];
                    String splitString = arrOfStr[1];
                    Date dateTimeFormat = stringDataExtraction.dateAndTimeParser(dateAndTime);
                    arrOfStr = splitString.split("::",2);
                    String messageType = arrOfStr[0];
                    splitString = arrOfStr[1];
                    String messageText;
                    String exceptionData;
                    if (splitString.contains("Exception: System.Exception: Some fake exception with some fake inner exception ---> "))
                    {
                    arrOfStr = splitString.split("Exception: System.Exception: Some fake exception with some fake inner exception ---> ",2);
                    messageText = arrOfStr[0];
                    exceptionData = arrOfStr[1];
                    }
                    else
                    {
                        messageText = splitString;
                        exceptionData = null;
                    }

                    ObjectBuffer object = new ObjectBuffer(dateTimeFormat,messageType,messageText,exceptionData);
                    objects.add(object);
                }
            }
            for (ObjectBuffer buffer : objects) {
                System.out.println(buffer);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
