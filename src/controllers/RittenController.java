package controllers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import db.RittenDAO;
import models.Bestuurder;
import models.Rit;

@Controller
public class RittenController {
    public RittenController() {
    }

    @RequestMapping(value="/Ritten",method = RequestMethod.POST)
    public ResponseEntity<List<Rit>> rittenTonen() {
        ModelAndView model = new ModelAndView("RittenTonenPage");
        RittenDAO dao = new RittenDAO();
        ArrayList<Rit> lijst = dao.getAll();
        
        Gson gson = new Gson();

        String jsonInString = gson.toJson(lijst);
        model.addObject("lijst",jsonInString);
        
		return new ResponseEntity<List<Rit>>(lijst,HttpStatus.OK);
    
        
    }
    
    @RequestMapping(value="/Ritten",method = RequestMethod.GET)
    public ResponseEntity<String> rittenTonen2() {
        ModelAndView model = new ModelAndView("RittenTonenPage");
        RittenDAO dao = new RittenDAO();
        ArrayList<Rit> lijst = dao.getAll();
        
        Gson gson = new Gson();

        String jsonInString = gson.toJson(lijst);
        model.addObject("lijst",jsonInString);
        
		return new ResponseEntity<String>(jsonInString,HttpStatus.OK);
    
        
    }
    
    @RequestMapping(value = "/Ritten/{event}", method = RequestMethod.GET)
	public ResponseEntity<String> getRitById(@PathVariable String event) {
    	
        ModelAndView model = new ModelAndView("RittenTonenPage");
        RittenDAO dao = new RittenDAO();
        ArrayList<Rit> lijst = dao.getRitByRichting(event);
        
        Gson gson = new Gson();

        String jsonInString = gson.toJson(lijst);
        model.addObject("lijst",jsonInString);
    	
		return new ResponseEntity<String>(jsonInString,HttpStatus.OK);
	}
    
    @RequestMapping(value = "/Ritten/{id}/{richting}/{evenement}/{plaats}", method = RequestMethod.GET)
	public ResponseEntity<String> insertRit(@PathVariable int id,@PathVariable String richting,@PathVariable String evenement,@PathVariable int plaats) {
    	
        ModelAndView model = new ModelAndView("RittenTonenPage");
        RittenDAO dao = new RittenDAO();
        
        Bestuurder b = dao.getBestuurderById(id);
        Rit rit = new Rit(b,richting,evenement,plaats);
        int i = dao.insert(rit);
        
        Gson gson = new Gson();

        String jsonInString = gson.toJson(rit);
        model.addObject("lijst",jsonInString);
    	
		return new ResponseEntity<String>(jsonInString,HttpStatus.OK);
	}
    
    @RequestMapping(value = "/Bestuurders/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getBestuurderById(@PathVariable int id) {
    	
        ModelAndView model = new ModelAndView("RittenTonenPage");
        RittenDAO dao = new RittenDAO();
        Bestuurder b = dao.getBestuurderById(id);
        Gson gson = new Gson();

        String jsonInString = gson.toJson(b);
        model.addObject("lijst",jsonInString);
    	
		return new ResponseEntity<String>(jsonInString,HttpStatus.OK);
	}
    
    
    
}
