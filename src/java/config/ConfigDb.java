package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import model.CaseDeaths;


@Stateless //บอกว่าclassนี้มีการconnectJDBC
public class ConfigDb {

//configdb
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String JDBC_URL = "jdbc:mysql://localhost:3306/cdx-covid"; //ชื่อdb
    String USER_ROOT = "root";
    String PASSWORD = "";

    public List<CaseDeaths> getCaseDeath() {

        List<CaseDeaths> deathsDaos = new ArrayList<>(); //ข้อมูลที่ได้มาเป็นlistเลยสร้างให้เก็บเป็นlist
        try {

            Class.forName("com.mysql.jdbc.Driver"); //บอกว่าเราต้องการใช้driverอะไร
            Connection con = DriverManager.getConnection(JDBC_URL, USER_ROOT, PASSWORD); //ทำการconncetกับค่าที่ตั้งไว้
            Statement statement = con.createStatement(); //ดึงข้อมูลที่เปนstructureว่ามีอะไรบ้างในdatabase
            ResultSet rs = statement.executeQuery("select * from deaths_line_lists"); //ดึงข้อมูลจาก table  

            while (rs.next()) { //มันเป็นข้อมูลหลายชุดเลยต้องเอามาloopไปเรื่อยๆจนครบจำนวน
                int year = rs.getInt(2); //ดึงข้อมูล เลขคือfiled
                int weeknum = rs.getInt(3);
                String province = rs.getString(4);
                String age = rs.getString(5);
                String age_rage = rs.getString(6);
                String occypation = rs.getString(7);
                String type = rs.getString(8);
                String death_cluster = rs.getString(9);
                String update_date = rs.getString(10);

                    deathsDaos.add(CaseDeaths.builder() //เลือกมาแสดงแค่3ตัว ใbuilderคือบอกว่าต้องการบิ้วค่าอะไรลงไปบ้าง
                            .year(year)
                            .weeknum(weeknum)
                            .age(age)
                            .build());
                con.close();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.fillInStackTrace()); //ถ้าerrorให้printว่าเพราะอะไร
        }

        return deathsDaos; //return listออกไป
    }

}
