package home.assignment;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class StringDataParsing {
    public Date dateAndTimeParser(String dataLogString ) throws ParseException {
        Date newDateFormat = new SimpleDateFormat("yyyyMMdd.HHmmssSSS").parse(dataLogString);
        //System.out.println("\t" +newDateFormat);
        return newDateFormat;
    }
}
