package com.springboot.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.CabeceraRecibo;
import com.springboot.rest.model.Greeting;
import com.springboot.rest.model.Recibo;
import com.springboot.rest.model.ReciboDao;
import com.springboot.rest.model.ReciboDaoImpl;

@RestController
public class RecibosController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/cabecera")
    public List<CabeceraRecibo> getCabeceraAll() {
    	ReciboDao reciboDao = new ReciboDaoImpl();
    	List<CabeceraRecibo> cabeceraList = reciboDao.getCabeceraAll();    	
        return cabeceraList;
    }
    
    @RequestMapping("/recibos")
    public List<Recibo> getRecibosAll() {
    	ReciboDao reciboDao = new ReciboDaoImpl();
    	List<Recibo> recibosList = reciboDao.getRecibosAll();    	
        return recibosList;
    }
}
