import java.io.*;

public class TextParserMain {

    public static void parseText(String path) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        sb.append("Time,Course,Day Before,Piece,Accumulated\n");


        br.readLine();
        br.readLine();
        br.readLine();

        String line;
        int count = 0;
        while((line = br.readLine())!=null)
        {
            if(count>=5) {
                count = 0;
                sb.append("\n");
            }

            if(!line.equals("")) {
                line = line.transform(c -> c.replace(',','.'));
                sb.append(line + ",");
                count++;
            }
        }


        String writeTo = path.replace(".txt",".csv");

        BufferedWriter bw = new BufferedWriter(new FileWriter(writeTo,false));

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        String paths[] = {"C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 21-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 22-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 23-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 25-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 28-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 15-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 16-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 17-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 18-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 14-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 19-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 24-3-22.txt",
                "C:\\Users\\ivan_\\IntelliJ\\TextParserCSV\\data\\DAX 11-3-22.txt"};
        for(String path : paths)
            parseText(path);

    }

}
