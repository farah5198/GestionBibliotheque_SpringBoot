package com.isetN.romans;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.isetN.romans.entities.Genre;
import com.isetN.romans.entities.Roman;
import com.isetN.romans.repos.RomanRepository;
import com.isetN.romans.service.RomanService;
import com.isetN.romans.service.RomanServiceImpl;

@SpringBootTest
class RomansApplicationTests {

	@Autowired
	private RomanRepository romanRepository;
	
	@Autowired
	private RomanService romanService;
	 
	@Test
	public void testCreateRoman() {
	Roman rom = new Roman("Imagination",2200.500,new Date());
	romanRepository.save(rom);
	}
	
	 @Test
	 public void testFindRoman()
	 {
	 Roman r = romanRepository.findById(2L).get();
	 System.out.println(r);
	 }
	 
	 @Test
	 public void testUpdateRoman()
	 {
	 Roman r = romanRepository.findById(2L).get();
	 r.setPrixRoman(2000.0);
	 romanRepository.save(r);
	 
	 System.out.println(r);
	 }
	 
	 @Test
	 public void testDeleteRoman()
	 {
	   romanRepository.deleteById(2L);
	 
	 }
	 
	 @Test
	 public void testListerTousRomans()
	 {
	 List<Roman> roms = romanRepository.findAll();
	 for (Roman r : roms)
	 {
	 System.out.println(r);
	 }
	 }
	 
	 @Test
	 public void testFindByTitreRomanContains()
	 {
	 Page<Roman> prods = romanService.getAllRomansParPage(0,2);
	 System.out.println(prods.getSize());
	 System.out.println(prods.getTotalElements());
	 System.out.println(prods.getTotalPages());
	 prods.getContent().forEach(p -> {System.out.println(p.toString());
	  });
	 /*ou bien
	 for (Roman r : roms)
	 {
	 System.out.println(r);
	 } */
	 }

	 @Test
	 public void testFindByTitreRoman()
	 {
	 List<Roman> roms = romanRepository.findByTitreRoman("sadness");
	
     for ( Roman r :roms)
	      System.out.println(r);
	 }
	 
	 @Test
	 public void testFindByTitreRomanContains1()
	 {
	 List<Roman> roms = romanRepository.findByTitreRomanContains("s");
	
     for ( Roman r :roms)
	      System.out.println(r);
	 }
	 
	 @Test
	 public void testfindByNomPrix()
	 {
	 List<Roman> roms = romanRepository.findByTitrePrix("sadness", 1000.0);
	 for (Roman r : roms)
	 {
	 System.out.println(r);
	 }
	 }
	 
	 
	 
	 @Test
	 public void testfindByGenre()
	 {
	 Genre genr = new Genre();
	 genr.setIdGenr(1L);
	 List<Roman> roms = romanRepository.findByGenre(genr);
	 for (Roman r : roms)
	 {
	 System.out.println(r);
	 }
	 }
	 
	 @Test
	 public void findByGenreIdGenr()
	 {
	 List<Roman> roms = romanRepository.findByGenreIdGenr(1L);
	 for (Roman r : roms)
	 {
	 System.out.println(r);
	 }
	  }

	 @Test
	 public void testfindByOrderByTitreRomanAsc()
	 {
	 List<Roman> roms = romanRepository.findByOrderByTitreRomanAsc();
	 for (Roman r : roms)
	 {
	 System.out.println(r);
	 }
	 }
	 
	 @Test
	 public void testTrierRomansTitresPrix()
	 {
	 List<Roman> roms = romanRepository.trierRomansTitresPrix();
	 for (Roman r : roms)
	 {
	 System.out.println(r);
	 }
	 }

	 
	 

}
