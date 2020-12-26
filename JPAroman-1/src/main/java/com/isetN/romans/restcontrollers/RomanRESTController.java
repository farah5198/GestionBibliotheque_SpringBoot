package com.isetN.romans.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.isetN.romans.entities.Roman;
import com.isetN.romans.service.RomanService;
@RestController
@RequestMapping("/api")



@CrossOrigin
public class RomanRESTController {
@Autowired
RomanService romanService;
@RequestMapping(method = RequestMethod.GET)
public List<Roman> getAllRomans() 
{
  return romanService.getAllRomans();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Roman getRomanById(@PathVariable("id") Long id) {
return romanService.getRoman(id);
 }

@RequestMapping(method = RequestMethod.POST)
public Roman createRoman(@RequestBody Roman roman) {
return romanService.saveRoman(roman);
}

@RequestMapping(method = RequestMethod.PUT)
public Roman updateRoman(@RequestBody Roman roman) {
return romanService.updateRoman(roman);
}

@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteRoman(@PathVariable("id") Long id)
{
romanService.deleteRomanById(id);
}

@RequestMapping(value="/romsGenr/{idGenr}",method = RequestMethod.GET)
public List<Roman> getRomansByGenrId(@PathVariable("idGenr") Long idGenr) {
return romanService.findByGenreIdGenr(idGenr);
}


} 