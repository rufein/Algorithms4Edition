/****************************************************************************** 
 *   Exercise 3.5.14
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/35applications/LookupCSV.java.html
 *
 *   Compilation:  javac RangeLookupCSV.java
 *   Execution:    java RangeLookupCSV ip.csv 0 1
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Iterator;

public class RangeLookupCSV {
    public static void main(String[] args) {
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        // symbol table
        ST<String, String> st = new ST<String, String>();

        // read in the data from csv file
        In in = new In(args[0]);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        // Standard input to get the values
        StdOut.println("Insert the lowest value in a range of a set of data:");
        String key1 = StdIn.readString(); // lowest value
        StdOut.println("Insert the highest value in a range of a set of data:");
        String key2 = StdIn.readString(); // highest value
    
        // Print
        for (String k : st){
            if( (k.compareTo(key1) > 0) && (k.compareTo(key2) < 0) ) 
                StdOut.println("key: " + k.toString() + " // value: " + st.get(k));
        }
    }
}