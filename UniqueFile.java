/* Given an array of strings names of size n... You will create n folders in your file system such that, at the ith minute, you will create a folder with the name names[i]... Since two files cannot have the same name, if you enter a folder name that was previously used, the system will have a suffix addition to its name in the form of (k), where, k is the smallest positive integer such that the obtained name remains unique... Return an array of strings of length n where ans[i] is the actual name the system will assign to the ith folder when you create it...
 * Eg 1:  names = ["pes","fifa","gta","pes(2019)"]        Output = ["pes","fifa","gta","pes(2019)"]
 * Eg 2:  names = [gta,gta,gta,avalon]                    Output = [gta,gta0,gta1,avalon]
 */
import java.util.*;
public class UniqueFile
{
    public String[] UniqueNames(String files[])
    {
        String names[] = new String[files.length];
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();    // Hashtable created...
        int count = 0;
        for(int i = 0; i < names.length-1; i++)
        {
            table.put(files[i], 1);      // Putting it in the Hashtable...
            if(table.containsKey(files[i+1]))
            {
                names[i] = files[i] + count;    // Adding the value...
                System.out.println(names[i]);
                count++;    // Incrementing count...
            }
            else
            {
                names[i] = files[i];
                names[i+1] = files[i+1];
                count = 0;
            }
        }
        return names;     // returning names...
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of files : ");
        x = sc.nextInt();
        String files[] = new String[x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter "+(i+1)+" File name : ");
            files[i] = sc.next();
        }
        UniqueFile unique = new UniqueFile();      // Object creation...
        files = unique.UniqueNames(files);          // Calling function...
        for(int i = 0; i < files.length; i++)
            System.out.print(files[i]+", ");
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. We use Hashtable, to store the unique file names and when the file name is found in the Hashtable we use change the file name accordingly... 
*/