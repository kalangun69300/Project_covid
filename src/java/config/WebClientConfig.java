package config;

import static constant.BaseUrlConStant.BASE_URI;
import static constant.BaseUrlConStant.DEATH_TOLL_DATA;
import static constant.BaseUrlConStant.REPORT_TIMELINE_ALL_CASE_LATER;
import static constant.BaseUrlConStant.TO_DAY_CASE_ALL;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


public class WebClientConfig { //เป็นส่วนcallหาapi

    private final Client client = ClientBuilder.newClient(); //บอกว่าต้องการสร้าง element จะสามารเข้าถึง func

    public String caseDeath() {
        String caseDeath
                = client.target(BASE_URI) //เป็นเบสurlว่าต้องการยิงไปที่serverไหน
                        .path(DEATH_TOLL_DATA)//pathที่ต้องการเข้าถึง
                        .request(MediaType.APPLICATION_JSON) //ข้อมูลที่รับส่งเป็นjson
                        .get(String.class); //บอกว่าให้ข้อมูลเป็นString
                        
        return caseDeath;
    }

    public String getToDayCaseAll() {
        String caseDeath
                = client.target(BASE_URI)
                        .path(TO_DAY_CASE_ALL)
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        return caseDeath;
    }

    public String getReportTimelineLater() {
        String caseDeath
                = client.target(BASE_URI)
                        .path(REPORT_TIMELINE_ALL_CASE_LATER)
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        return caseDeath;
    }

 

}
