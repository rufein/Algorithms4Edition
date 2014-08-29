
/****************************************************************************** 
 *   Exercise 2.5.29
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac FileSorter.java
 *   Execution:    java FileSorter 
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.net.URI;

public class FileExtended extends File { 
    
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
    public static class OrderByName implements Comparator<FileExtended>{
        public int compare( FileExtended v, FileExtended w){
           return v.compareTo(w);
        }
    }
    
    public static class OrderByNameInverse implements Comparator<FileExtended>{
        public int compare( FileExtended v, FileExtended w){
           return -v.compareTo(w);
        }
    }
    
    public static class OrderBySize implements Comparator<FileExtended>{
        public int compare( FileExtended v, FileExtended w){
           if(v.length() > w.length() ) return 1;
           else if(v.length() < w.length() ) return -1;
           else return 0;
        }
    }
    
     public static class OrderBySizeInverse implements Comparator<FileExtended>{
        public int compare( FileExtended v, FileExtended w){
           if(v.length() > w.length() ) return -1;
           else if(v.length() < w.length() ) return 1;
           else return 0;
        }
    }
    
     public static class OrderByDate implements Comparator<FileExtended>{
        public int compare( FileExtended v, FileExtended w){
           if(v.lastModified() > w.lastModified() ) return 1;
           else if(v.lastModified() < w.lastModified() ) return -1;
           else return 0;
        }
    }
     
     public static class OrderByDateInverse implements Comparator<FileExtended>{
        public int compare( FileExtended v, FileExtended w){
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