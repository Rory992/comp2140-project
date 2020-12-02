package data;

import java.io.*;

/**
 * @author Rory Young
 */
public class PaySysDb {
    private String filename;
    char delimiter;
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    BufferedWriter bw;

    /**
     * @param fileName used to specify the file that is to be read
     * @param delimiter the character used to separate each value in each line of the file
     */
    public PaySysDb(String fileName, char delimiter){
        this.filename = fileName;
        this.delimiter = delimiter;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

        } catch (FileNotFoundException e) {
            System.out.println("The file" + filename + " file could not be found.");
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException used to indicate if the file cannot be read/found
     * @return a boolean value indicating if a line in a file is ready to be read
     */
    public boolean hasNext() throws IOException {
        return br.ready();
    }

    /**
     * @return gives a list containing the line of data read from a file
     * @throws IOException used to indicate if the file cannot be read/found
     */
    public String [] getNext() throws IOException{
        String [] parts;
        String data;
        data = br.readLine();
        parts = data.split(String.valueOf(delimiter), -1);
        return parts;
    }

    /**
     * @throws IOException used to indicate if the file cannot be read/found
     */
    public void rewrite() throws IOException {
        if(fr!=null && br!=null){
            fr.close();
            br.close();
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
        }
    }

    /**
     * @param data a list containing the line of data read from a file
     * @throws IOException used to indicate if the file cannot be read/found
     */
    public void putNext(String[] data) throws IOException {
        fw = new FileWriter(filename,true);
        bw = new BufferedWriter(fw);
        StringBuilder line = new StringBuilder();

        for(String piece : data){
            line.append(piece).append(delimiter);
        }
        int len = line.length();
        line.deleteCharAt(len-1);
        bw.newLine();
        bw.write(String.valueOf(line));
        bw.close();
        fw.close();
    }
}