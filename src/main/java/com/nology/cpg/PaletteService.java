package com.nology.cpg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
@Service
public class PaletteService {

    @Autowired
    PaletteRepository paletteRepository;

    public List<Integer> extractIds() {
        List<Palette> palettes = paletteRepository.findAll();
        return palettes.stream()
                .map(p -> p.getId())
                .collect(Collectors.toList());
    }

    public List<Palette> getAllPalettes() {
        return paletteRepository.findAll();
    }

//    public List<Palette> getPalettesCreatedBy(String createdBy) {
//        List<Palette> palettes = paletteRepository.findPalettesCreatedBy(createdBy);
//        return palettes;
//    }

    public Palette getById(int id){
        Palette palette = paletteRepository.findById(id).orElse(null);
        return palette;
    }

    public Palette getRandom() {
        List<Palette> palettes = paletteRepository.findAll();
        Random r = new Random();
        int randomIndex = r.nextInt(palettes.size());
        Palette randomPalette = palettes.get(randomIndex);
        return randomPalette;
    }

    public Palette createPalette(Palette palette){
        if (palette.getCreatedBy() == null || palette.getCreatedBy().length() < 1) {
            throw new RuntimeException("Palette must have created by");
        }
        return paletteRepository.save(palette);
    }

    public boolean deletePalette(int id){
        Palette paletteToDelete = paletteRepository.findById(id).orElse(null);
        if(paletteToDelete == null) {
            return false;
        }
        paletteRepository.delete(paletteToDelete);
        return true;
    }

    public int deletePalettesCreatedBy(String createdBy) {
        int deletedCount = paletteRepository.deletePalettesByCreator(createdBy);
        return deletedCount;
    }

}
