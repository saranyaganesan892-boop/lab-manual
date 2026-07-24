import java.io.*;
import java.util.*;

public class StudentFileManagement {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("students.txt");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("\nEnter Details of " + n + " Students");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nStudent " + i);

            System.out.print("Roll No : ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Marks : ");
            int marks = sc.nextInt();
            sc.nextLine();

            fw.write(roll + "," + name + "," + marks + "\n");
        }

        fw.close();

        System.out.println("\nStudent records saved successfully.");

        // Display Records
        System.out.println("\n------ Student Records ------");

        BufferedReader br = new BufferedReader(new FileReader("students.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

        // Search Record
        System.out.print("\nEnter Roll Number to Search : ");
        int searchRoll = sc.nextInt();

        br = new BufferedReader(new FileReader("students.txt"));
        boolean found = false;

        while ((line = br.readLine()) != null) {

            String data[] = line.split(",");

            if (Integer.parseInt(data[0]) == searchRoll) {
                System.out.println("\nStudent Found");
                System.out.println("Roll No : " + data[0]);
                System.out.println("Name : " + data[1]);
                System.out.println("Marks : " + data[2]);
                found = true;
                break;
            }
        }

        br.close();

        if (!found) {
            System.out.println("Student Not Found");
        }

        // Update Marks
        System.out.print("\nEnter Roll Number to Update Marks : ");
        int updateRoll = sc.nextInt();

        File inputFile = new File("students.txt");
        File tempFile = new File("temp.txt");

        br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        found = false;

        while ((line = br.readLine()) != null) {

            String data[] = line.split(",");

            if (Integer.parseInt(data[0]) == updateRoll) {

                System.out.print("Enter New Marks : ");
                int newMarks = sc.nextInt();

                bw.write(data[0] + "," + data[1] + "," + newMarks);
                found = true;
            } else {
                bw.write(line);
            }

            bw.newLine();
        }

        br.close();
        bw.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found)
            System.out.println("Marks Updated Successfully.");
        else
            System.out.println("Student Not Found.");

        // Display Updated Records
        System.out.println("\n------ Updated Student Records ------");

        br = new BufferedReader(new FileReader("students.txt"));

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        sc.close();
    }
}
