package spring.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class RegisterController {
 
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();     
        model.put("userForm", userForm);
        
        List<String> professionList = new ArrayList<String>();
        
        model.put("professionList", professionList);
        return "Registration";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user, 
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("firstname: " + user.getFirstName());
        System.out.println("lastname: " + user.getLastName());
        System.out.println("email: " + user.getEmail());
        System.out.println("password:  " + user.getPassword());
        System.out.println("country: "  + user.getCountry());
        System.out.println("city: " + user.getCity());
        System.out.println("birth date: " + user.getBirthDate());
         
        return "RegistrationSuccess";
    }
}
