package garyapps.fyte.Utilities;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by garrettemrick on 12/20/17.
 */

public class DateHelper{
    public static String parseMonthShortNameFromInt(int month){
        switch(month){
            case 0:
                return "Jan";
            case 1:
                return "Feb";
            case 2:
                return "Mar";
            case 3:
                return "Apr";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "Aug";
            case 8:
                return "Sep";
            case 9:
                return "Oct";
            case 10:
                return "Nov";
            case 11:
                return "Dec";
            default:
                return null;
        }
    }

    public static String parseMonthLongNameFromInt(int month){
        switch(month){
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
            default:
                return null;
        }
    }

    public static String parseShortDayName(int num){
        switch(num){
            case 0:
                return "Sun";
            case 1:
                return "Mon";
            case 2:
                return "Tues";
            case 3:
                return "Wed";
            case 4:
                return "Thur";
            case 5:
                return "Fri";
            case 6:
                return "Sat";
            default:
                return null;
        }
    }

    public static String parseLongDayName(int num){
        switch(num){
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return null;
        }
    }

    public static String getCurrentDateFormatted(){
        return parseShortDayName(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1) + ", "
                + parseMonthLongNameFromInt(Calendar.getInstance().get(Calendar.MONTH)) + " " +
                Calendar.getInstance().get(Calendar.YEAR);
    }
}