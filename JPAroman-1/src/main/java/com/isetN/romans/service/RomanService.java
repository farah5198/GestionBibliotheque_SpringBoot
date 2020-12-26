package com.isetN.romans.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.isetN.romans.entities.Genre;
import com.isetN.romans.entities.Roman;
public interface RomanService {
  Roman saveRoman(Roman r);
  Roman updateRoman(Roman r);
  void deleteRoman(Roman r);
  void deleteRomanById(Long id);
  Roman getRoman(Long id);
  List<Roman> getAllRomans();
  Page<Roman> getAllRomansParPage(int page, int size);
  List<Roman> findByTitreRoman(String titre);
  List<Roman> findByTitreRomanContains(String titre);
  List<Roman> findByTitrePrix (String titre, Double prix);
  List<Roman> findByGenre (Genre genre);
  List<Roman> findByGenreIdGenr(Long id);
  List<Roman> findByOrderByTitreRomanAsc();
  List<Roman> trierRomansTitresPrix();
  
}
