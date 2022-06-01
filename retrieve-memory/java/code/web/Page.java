package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
class Page{
    
    @RequestMapping("/status")
    String showStatus(Model m){
        Runtime r = Runtime.getRuntime();
        double memory = r.totalMemory();
        double free = r.freeMemory();
        double usage = memory - free;
        double percent = usage / memory * 100;
        m.addAttribute("memory",r.totalMemory());
        m.addAttribute("usage",percent);
        m.addAttribute("processors",r.availableProcessors());
        return "status";  //http://localhost:8000/status.html
    }
}

@RestController
class Memory{
    @RequestMapping("/get-memory-usage")
    double m(){
        Runtime r = Runtime.getRuntime();
        double processors = Runtime.getRuntime().availableProcessors();
        double total = r.totalMemory();
        double free = r.freeMemory();
        double usage = total -free;
        return processors;   
    }
    
}