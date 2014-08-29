
/****************************************************************************** 
 *   Exercise 2.5.29
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac LS.java
 *   Execution:    java LS (directory-name) + N
 *                 java LS (directory-name) - D 
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.net.URI;

public class LS {

    /*************************************************
     *  CLASS EXTENDED
     ************************************************/
    public static class FileExtended extends File { 
        
        // Builder
        public FileExtended(File parent, String child){
            super(parent, child);
        }
        
        public FileExtended(String pathname){
            super(pathname);
        }
        
        public FileExtended(String parent, String child){
            super(parent, child);
        }
        
        public FileExtended(URI uri){
            super(uri);
        }
        
        // Comparators
        public static class OrderByName implements Comparator<File>{
            public int compare( File v, File w){
                return v.compareTo(w);
            }
        }
        
        public static class OrderByNameInverse implements Comparator<File>{
            public int compare( File v, File w){
                return -v.compareTo(w);
            }
        }
        
        public static class OrderBySize implements Comparator<File>{
            public int compare( File v, File w){
                if(v.length() > w.length() ) return 1;
                else if(v.length() < w.length() ) return -1;
                else return 0;
            }
        }
        
        public static class OrderBySizeInverse implements Comparator<File>{
            public int compare( File v, File w){
                if(v.length() > w.length() ) return -1;
                else if(v.length() < w.length() ) return 1;
                else return 0;
            }
        }
        
        public static class OrderByDate implements Comparator<File>{
            public int compare( File v, File w){
                if(v.lastModified() > w.lastModified() ) return 1;
                else if(v.lastModified() < w.lastModified() ) return -1;
                else return 0;
            }
        }
        
        public static class OrderByDateInverse implements Comparator<File>{
            public int compare( File v, File w){
                if(v.lastModified() > w.lastModified() ) return -1;
                else if(v.lastModified() < w.lastModified() ) return 1;
                else return 0;
            }
        }
        
        /*
         *  Test function
         */
        public static void main(String[] args) {
            
        }  
    }
    
    /***********************************************************
    *  Variables
    ************************************************************/
    
    public FileExtended directory;
    public File[] files;
    
    public LS( String d ){
        directory = new FileExtended(d);
        files = directory.listFiles();
    }
    
    /*
      *  Test function
     */
    public static void main(String[] args) {
        LS directory = new LS(args[0]);     // root directory
        File[] files = directory.files;
        
        String sign = args[1];
        String comp = args[2]; // What kind of sort
        Comparator c = new FileExtended.OrderByName();
        
        if(sign.equals("+")){
            if( comp.equals("N") ) {}
            if( comp.equals("S") ) c = new FileExtended.OrderBySize();
            if( comp.equals("D") ) c = new FileExtended.OrderByDate();
            Arrays.sort(files, c);
        }
        else if(sign.equals("-")){
            if( comp.equals("N") ) c = new FileExtended.OrderByNameInverse();
            if( comp.equals("S") ) c = new FileExtended.OrderBySizeInverse();
            if( comp.equals("D") ) c = new FileExtended.OrderByDateInverse();
            Arrays.sort(files, c);
        }
        else{
            Arrays.sort(files);
        }
                
        for (int i = 0; i < files.length; i++)
            StdOut.println(files[i].getName());
    }

}