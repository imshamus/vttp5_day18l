package sg.edu.nus.iss.vttp5_day18l.model;

import java.util.ArrayList;
import java.util.List;

public class SessionDataList {
    private List<SessionData> sessionDataList;

    public SessionDataList(){
        this.sessionDataList = new ArrayList<>();
    }

    public SessionDataList(List<SessionData> sessionDataList) {
        this.sessionDataList = sessionDataList;
    }

    public List<SessionData> getSessionDataList() {
        return sessionDataList;
    }

    public void setSessionDataList(List<SessionData> sessionDataList) {
        this.sessionDataList = sessionDataList;
    }

    
}
