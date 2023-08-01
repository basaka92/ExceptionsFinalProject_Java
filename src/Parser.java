import Exceptions.DataFormatException;
import Exceptions.DataSizeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Pattern pattern;
    private Matcher matcher;
    private String firstName;
    private String secondName;
    private String lastName;
    private String dateOfBirth;
    private String number;
    private String gender;
    public void parseData(String data) {
        String buffer;
        if (data.trim().split("\s+").length != 6) {
            throw new DataSizeException(data.trim().split("\s+").length);
        } else {
                this.pattern = Pattern.compile("(\s|^)([А-Я]{1}[а-яё]{1,23})\s+([А-Я]{1}[а-яё]{1,23})\s+([А-Я]{1}[а-яё]{1,23})(\s|$)");
                this.matcher = this.pattern.matcher(data);
                if (this.matcher.find()) {
                        this.firstName = this.matcher.group().trim().split("\s+")[1];
                        this.secondName = this.matcher.group().trim().split("\s+")[0];
                        this.lastName = this.matcher.group().trim().split("\s+")[2];
                }

                this.pattern = Pattern.compile("(\s|^)(0[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)(\s|$)");
                this.matcher = this.pattern.matcher(data);
                if (this.matcher.find()) {
                        this.dateOfBirth = this.matcher.group().trim();
                }

                this.pattern = Pattern.compile("(\s|^)([0-9]{7})(\s|$)");
                this.matcher = this.pattern.matcher(data);
                if (this.matcher.find()) {
                        this.number = this.matcher.group().trim();
                }

                this.pattern = Pattern.compile("(\s|^)([fm])(\s|$)");
                this.matcher = this.pattern.matcher(data);
                if (this.matcher.find()) {
                        this.gender = this.matcher.group().trim();
                }
            }
        if (this.firstName == null || this.secondName == null || this.lastName == null || this.dateOfBirth == null || this.number == null || this.gender == null){
            throw new DataFormatException();
        }
        }
    public String getSecondName() {
        return this.secondName;
    }
    public String getCorrectData(){
        return "<" + this.secondName + ">" + "<" + this.firstName + ">" + "<" + this.lastName + ">" + "<" + this.dateOfBirth + ">" + "<" + this.number + ">" + "<" + this.gender + ">";
    }
}
