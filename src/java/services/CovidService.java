package services;

import config.ConfigDb;
import config.WebClientConfig;
import java.util.List;

import javax.jws.WebService;
import javax.jws.WebMethod;
import model.CaseDeaths;


@WebService(serviceName = "covid") //ตั้งชื่อwebsevice
public class CovidService {

     WebClientConfig clientConfig;
     ConfigDb configDb;  //callหา

   
    @WebMethod(operationName = "caseDeath") //เข้าfuncตามoperatorname ชื่อpathที่เราตั้งไว้
    public  String  caseDeath() {
        clientConfig = new WebClientConfig();
        return clientConfig.caseDeath(); //returnfunc
    }

    @WebMethod(operationName = "caseAll") 
    public String getToDayCaseAll() {
        clientConfig = new WebClientConfig();
        return clientConfig.getToDayCaseAll();
    }

    @WebMethod(operationName = "report")
    public String getReportTimelineLater() {
        clientConfig = new WebClientConfig();
        return clientConfig.getReportTimelineLater();
    }
    
     @WebMethod(operationName = "findALlCaseDeath")
    public List<CaseDeaths> caseDeathByDb() {
        configDb = new ConfigDb();
        return configDb.getCaseDeath(); //ก็จะทำการreturn list
    }

}
