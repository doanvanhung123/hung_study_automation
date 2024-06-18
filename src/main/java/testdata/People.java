package testdata;

import com.poiji.annotation.ExcelCellName;

public class People {

    @ExcelCellName("Name")
    private String name;

    @ExcelCellName("Id")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ExcelCellName("Number")
    private String number;

}
