package org.katawraper.utils;

import org.katawraper.exceptions.NegativeNumberException;

import java.util.List;

public class Wraper {

    public static String wrap(String textString, int columnNumber) throws NegativeNumberException {

        if ( columnNumber <= 0 ){
            throw new NegativeNumberException("Negative number not allowed");
        } else if ( textString.isEmpty() ) {
            return "0";
        }

        List<String> stringList = List.of(textString.trim().split(" "));

        return columnNumber > stringList.size()
            ? textString
            : insertLineBreaks(stringList, columnNumber);

    }

    private static String insertLineBreaks(List<String> stringList, int lineBreakNumber){

        String response = "";

        for (int index = 0 ; index < stringList.size() ; index++) {

            if ( index > 0 && (index + 1) % lineBreakNumber == 0 ){
                response += stringList.get(index) + "\n";
            } else {
                response += stringList.get(index) + " ";
            }

        }

        return response.trim();
    }

}
