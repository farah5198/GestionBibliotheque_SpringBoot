
package com.isetN.romans.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.isetN.romans.entities.Roman;
import com.isetN.romans.service.RomanService;
@Controller
public class RomanController {
	@Autowired
	RomanService romanService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("roman", new Roman());
	modelMap.addAttribute("mode", "new");
	return "formRoman";

	}
	
	@RequestMapping("/saveRoman")
	public String saveRoman(@Valid Roman roman,
			 BindingResult bindingResult)
			{
			if (bindingResult.hasErrors()) return "formRoman";

			romanService.saveRoman(roman);
			return "formRoman";
			}

	
	@RequestMapping("/ListeRomans")
	public String listeRomans(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size)

	{
		Page<Roman> roms = romanService.getAllRomansParPage(page, size);
		
		modelMap.addAttribute("romans", roms);
		modelMap.addAttribute("pages", new int[roms.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		
		return "listeRomans";
	}
	
	
	@RequestMapping("/supprimerRoman")
	public String supprimerRoman(@RequestParam("id") Long id,
	                             ModelMap modelMap,
	                             @RequestParam (name="page",defaultValue = "0") int page,
	                             @RequestParam (name="size", defaultValue = "4") int size)
	  {
	romanService.deleteRomanById(id);
        	Page<Roman> roms = romanService.getAllRomansParPage(page,size);
			modelMap.addAttribute("romans", roms);
			modelMap.addAttribute("pages", new int[roms.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
	return "listeRomans";
	}
	
	
	
	@RequestMapping("/modifierRoman")
	public String editerRoman(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Roman r= romanService.getRoman(id);
	modelMap.addAttribute("roman", r);
	modelMap.addAttribute("mode", "edit");
	return "formRoman";

	}
	
	@RequestMapping("/updateRoman")
	public String updateRoman(
	@ModelAttribute("roman") Roman roman,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date anneeEdition = dateformat.parse(String.valueOf(date));
	 roman.setAnneeEdition(anneeEdition);

	 romanService.updateRoman(roman);
	 List<Roman> roms = romanService.getAllRomans();
	 modelMap.addAttribute("romans", roms);
	return "listeRomans";
	}

}






