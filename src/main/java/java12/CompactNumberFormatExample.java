package java12;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatExample {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(numberFormat.format(1200)); // Output: 1.2K
        System.out.println(numberFormat.format(2000000)); // Output: 2M
    }
}

/*
	Java 12 added a compact number formatting feature in java.text.NumberFormat for human-readable outputs 
	like "1.2K" for "1,200" or "2M" for "2,000,000".
*/