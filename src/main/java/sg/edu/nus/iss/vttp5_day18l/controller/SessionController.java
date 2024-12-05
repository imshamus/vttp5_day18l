package sg.edu.nus.iss.vttp5_day18l.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.vttp5_day18l.model.SessionData;
import sg.edu.nus.iss.vttp5_day18l.model.SessionDataList;

// Mark this class as a Controller to handle HTTP requests
@Controller
@RequestMapping("/sessions") // Base URL for all methods in this controller
public class SessionController {

    private SessionDataList sessionDataList;

    @PostConstruct
    public void init(){
        this.sessionDataList = new SessionDataList();
    }

    // Display the home page
    @GetMapping("/home")
    public String displayHomePage() {
        // This method returns the name of the HTML template ("home.html") to render
        return "home";
    }

    // Display the list of session data
    @GetMapping("/list")
    public String showSessions(HttpSession httpSession, Model model) {
        // Retrieve the session data list from the HttpSession using the key "s"
        SessionDataList sessionDataList = (SessionDataList) httpSession.getAttribute("s");
        List<SessionData> listOfSessionDatas = sessionDataList.getSessionDataList();
        // List<SessionData> sessions = (List<SessionData>) httpSession.getAttribute("s");

        // If no session data exists, initialize an empty list
        if (sessions == null) {
            sessions = new ArrayList<>();
        }

        // Add the session data list to the model for rendering in the "sessionlist.html" template
        model.addAttribute("s", sessions);

        // Return the name of the HTML template to render ("sessionlist.html")
        return "sessionlist";
    }

    // Display the form to create a new session entry
    @GetMapping("/createsession")
    public String createSessionForm(Model model) {
        // Add an empty SessionData object to the model for form binding
        model.addAttribute("s", new SessionData());

        // Return the name of the HTML template to render ("createsession.html")
        return "createsession";
    }

    // Handle the form submission to create a new session entry
    @PostMapping("/createsession")
    public String postCreateSessionForm(@ModelAttribute("s") SessionData sessionData, HttpSession httpSession) {
        // Retrieve the current session data list from HttpSession using the key "s"
        SessionDataList sessionDataList = new SessionDataList();
        List<SessionData> list = sessionDataList.getSessionDataList();
        list.add(sessionData);
        httpSession.setAttribute("s", sessionDataList);

        SessionDataList sessionList = (SessionDataList) httpSession.getAttribute("s");
        sessionList.getSessions() = List<SessionData>;
        List<SessionData> sessions = (List<SessionData>) httpSession.getAttribute("s");

        // If no session data exists, initialize an empty list
        if (sessions == null) {
            sessions = new ArrayList<>();
        }

        // Add the new session data to the list
        sessions.add(sessionData);

        // Save the updated list back into the HttpSession using the key "s"
        httpSession.setAttribute("s", sessions);

        // Redirect the user to the session list page
        return "redirect:/sessions/list";
    }

    // Clear all session data
    @PostMapping("/clear")
    public String clearSession(HttpSession httpSession) {
        // Remove the session data list from HttpSession using the key "s"
        httpSession.removeAttribute("s");

        // Redirect the user to the home page
        return "redirect:/sessions/home";
    }
}
