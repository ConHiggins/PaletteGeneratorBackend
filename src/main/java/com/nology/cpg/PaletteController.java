package com.nology.cpg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PaletteController {

    @Autowired
    PaletteRepository paletteRepository;
    @Autowired
    PaletteService paletteService;

    @GetMapping("/palettes/ids")
    public ResponseEntity<List<Integer>> getPaletteIds () {
        List<Integer> paletteIds = paletteService.extractIds();
        return ResponseEntity.status(HttpStatus.OK).body(paletteIds);
    }

    @PostMapping("/palettes/create")
    public ResponseEntity<String[]> createPalette(@RequestBody PaletteBuilder pb) {
        PaletteGenerator pg = new PaletteGenerator();
        Palette palette = pg.createPalette(pb.getBase(), pb.getSize());
        String[] hexCols = new String[palette.colours.length];
        for(int i=0; i<palette.colours.length; i++) {
            hexCols[i] = pg.rgbToHex(palette.colours[i]);
        }
        return ResponseEntity.status(HttpStatus.OK).body(hexCols);
    }

    @GetMapping("/palettes")
    public ResponseEntity<List<Palette>> getPalettes() {
        List<Palette> palettes = paletteService.getAllPalettes();
        return ResponseEntity.status(HttpStatus.OK).body(palettes);
    }

    @PostMapping("/palettes/save")
    public ResponseEntity savePalette(@RequestBody Palette palette) {
        paletteRepository.save(palette);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
