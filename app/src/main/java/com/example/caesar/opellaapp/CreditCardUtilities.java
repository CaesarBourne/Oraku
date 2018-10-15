//package com.example.caesar.opellaapp;
//
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import java.util.Calendar;
//import java.util.regex.Pattern;
//
//import com.cooltechworks.creditcarddesign.CreditCardUtils;
//
//public class CreditCardUtilities extends CreditCardUtils {
//
//    public static final int MAX_LENGTH_CARD_NUMBER_WITH_SPACES = 19;
//    public static final int MAX_LENGTH_CARD_NUMBER = 16;
//    public static final int MAX_LENGTH_CARD_HOLDER_NAME = 16;
//    public static final String EXTRA_CARD_NUMBER = "card_number";
//    public static final String EXTRA_CARD_CVV = "card_cvv";
//    public static final String EXTRA_CARD_EXPIRY = "card_expiry";
//    public static final String EXTRA_CARD_HOLDER_NAME = "card_holder_name";
//    public static final String EXTRA_CARD_SHOW_CARD_SIDE = "card_side";
//    public static final String EXTRA_VALIDATE_EXPIRY_DATE = "expiry_date";
//    public static final String EXTRA_ENTRY_START_PAGE = "start_page";
//    public static final int CARD_SIDE_FRONT = 1;
//    public static final int CARD_SIDE_BACK = 0;
//    public static final int CARD_NUMBER_PAGE = 0;
//    public static final int CARD_EXPIRY_PAGE = 1;
//    public static final int CARD_CVV_PAGE = 2;
//    public static final int CARD_NAME_PAGE = 3;
//    public static final String SPACE_SEPERATOR = " ";
//    public static final String DOUBLE_SPACE_SEPERATOR = "  ";
//    public static final String SLASH_SEPERATOR = "/";
//    public static final char CHAR_X = 'X';
//
//    public CreditCardUtils() {
//    }
//
//    public static String handleCardNumber(String inputCardNumber) {
//        return handleCardNumber(inputCardNumber, " ");
//    }
//
//    public static String handleCardNumber(String inputCardNumber, String seperator) {
//        String formattingText = inputCardNumber.replace(seperator, "");
//        String text;
//        if (formattingText.length() >= 4) {
//            text = formattingText.substring(0, 4);
//            if (formattingText.length() >= 8) {
//                text = text + seperator + formattingText.substring(4, 8);
//            } else if (formattingText.length() > 4) {
//                text = text + seperator + formattingText.substring(4);
//            }
//
//            if (formattingText.length() >= 12) {
//                text = text + seperator + formattingText.substring(8, 12);
//            } else if (formattingText.length() > 8) {
//                text = text + seperator + formattingText.substring(8);
//            }
//
//            if (formattingText.length() >= 16) {
//                text = text + seperator + formattingText.substring(12);
//            } else if (formattingText.length() > 12) {
//                text = text + seperator + formattingText.substring(12);
//            }
//
//            return text;
//        } else {
//            text = formattingText.trim();
//            return text;
//        }
//    }
//
//    public static String handleExpiration(String month, String year) {
//        return handleExpiration(month + year);
//    }
//
//    public static String handleExpiration(@NonNull String dateYear) {
//        String expiryString = dateYear.replace("/", "");
//        String text;
//        if (expiryString.length() >= 2) {
//            String mm = expiryString.substring(0, 2);
//            text = mm;
//
//            try {
//                if (Integer.parseInt(mm) > 12) {
//                    mm = "12";
//                }
//            } catch (Exception var9) {
//                mm = "01";
//            }
//
//            String yy;
//            if (expiryString.length() >= 4) {
//                yy = expiryString.substring(2, 4);
//
//                try {
//                    Integer.parseInt(yy);
//                } catch (Exception var8) {
//                    Calendar calendar = Calendar.getInstance();
//                    int year = calendar.get(1);
//                    yy = String.valueOf(year).substring(2);
//                }
//
//                text = mm + "/" + yy;
//            } else if (expiryString.length() > 2) {
//                yy = expiryString.substring(2);
//                text = mm + "/" + yy;
//            }
//        } else {
//            text = expiryString;
//        }
//
//        return text;
//    }
//}
