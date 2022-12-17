package model;

import lombok.Builder;
import lombok.Data;

//lombok
@Data
@Builder //insertค่าvalue
public class CaseDeaths { //เก็บค่าตัวแปรที่ดึงจากDB
  
    private Integer year;
    private Integer weeknum;
    private String province;
    private String age;
    private String age_range;
    private String occupation;
    private String update_date;

    
    
  
    
}
