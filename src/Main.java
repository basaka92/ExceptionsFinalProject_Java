import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data;
        boolean check = true;
        while (check) {
            System.out.println("Введите новые данные (введите end для выхода из программы).");
            data = sc.nextLine();
            if (data.toLowerCase().equals("end"))
            {
                check = false;
            }else{
                try{
                    Parser parser = new Parser();
                    parser.parseData(data);
                    FileWriter fileWriter = new FileWriter(parser.getSecondName()+".txt", true);
                    fileWriter.write(parser.getCorrectData() +"\n");
                    fileWriter.close();
                    System.out.println("Данные успешно обработаны и сохранены!");
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}