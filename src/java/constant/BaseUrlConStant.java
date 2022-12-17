package constant;

public class BaseUrlConStant { //pathที่เราตั้งไว้
    
    // base url
    public static final String BASE_URI = "https://covid19.ddc.moph.go.th/api";
        
    // puclicสามารถเข้าถึงได้ทุกที่ finalไม่สามารถแก้ไขไก้
    public static final String DEATH_TOLL_DATA =  "/Deaths/weekly-deaths-line-lists"; 
    public static final String TO_DAY_CASE_ALL = "/Cases/today-cases-all"; 
    public static final String REPORT_TIMELINE_ALL_CASE_LATER = "/Cases/timeline-cases-all"; 
    public static final String ROUND_LINE_LIST =  "/Cases/round-1to2-line-lists"; 


}
