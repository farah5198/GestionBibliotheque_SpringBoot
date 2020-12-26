package com.isetN.romans.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.isetN.romans.entities.Genre;
import com.isetN.romans.entities.Roman;
import com.isetN.romans.repos.RomanRepository;

@Service
public class RomanServiceImpl implements RomanService{
	
	@Autowired
	RomanRepository romanRepository;

	@Override
	public Roman saveRoman(Roman r) {
		return romanRepository.save(r);
		
	}

	@Override
	public Roman updateRoman(Roman r) {
		return romanRepository.save(r);
	}

	@Override
	public void deleteRoman(Roman r) {
		romanRepository.delete(r);

	}

	@Override
	public void deleteRomanById(Long id) {
		romanRepository.deleteById(id);
		
	}

	@Override
	public Roman getRoman(Long id) {
		return romanRepository.findById(id).get();
	}

	@Override
	public List<Roman> getAllRomans() {
		return romanRepository.findAll();
	}
	@Override
	public Page<Roman> getAllRomansParPage(int page, int size) {
	    return romanRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Roman> findByTitreRoman(String titre) {
		
		return romanRepository.findByTitreRoman(titre) ;
	}

	@Override
	public List<Roman> findByTitreRomanContains(String titre) {
		
		return romanRepository.findByTitreRomanContains(titre);
	}

	@Override
	public List<Roman> findByTitrePrix(String titre, Double prix) {
		
		return romanRepository.findByTitrePrix(titre, prix);
	}

	@Override
	public List<Roman> findByGenre(Genre genre) {
				return romanRepository.findByGenre(genre);
	}

	@Override
	public List<Roman> findByGenreIdGenr(Long id) {
		// TODO Auto-generated method stub
		return romanRepository.findByGenreIdGenr(id);
	}

	@Override
	public List<Roman> findByOrderByTitreRomanAsc() {
		// TODO Auto-generated method stub
		return romanRepository.findByOrderByTitreRomanAsc();
	}

	@Override
	public List<Roman> trierRomansTitresPrix() {
		// TODO Auto-generated method stub
		return null;
	}


}
