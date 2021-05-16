package cz.czechitas.java2webapps.ukol6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitatyService {

    private final CitatyRepository citatyRepository;
    private final NahodneCisloService nahodneCisloService;

    @Autowired
    public CitatyService(CitatyRepository citatyRepository, NahodneCisloService nahodneCisloService) {
        this.citatyRepository = citatyRepository;
        this.nahodneCisloService = nahodneCisloService;
    }

    public String nahodnyCitat() {
        return citatyRepository.citat(nahodneCisloService.dejNahodneCislo(citatyRepository.pocet()));
    }

    public String konkretniCitat(int cislo) {
        if (cislo >= citatyRepository.pocet() || cislo <= 0) {
            return null;
        }
        return citatyRepository.citat(cislo - 1);
    }
}