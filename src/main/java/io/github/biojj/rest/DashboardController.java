package io.github.biojj.rest;


import io.github.biojj.rest.dto.AverageAgeByBloodType;
import io.github.biojj.rest.dto.CandidatesByState;
import io.github.biojj.rest.dto.DonorsForEachBloodType;
import io.github.biojj.rest.dto.PercentObese;
import io.github.biojj.service.CandidateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final CandidateService candidateService;

    public DashboardController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("candidate-by-state")
    public List<CandidatesByState> countCandidatesByState() {
        return candidateService.countCandidatesByState();
    }

    @GetMapping("average-age-by-blood-type")
    public List<AverageAgeByBloodType> averageAgeByBloodType() {
        return candidateService.averageAgeByBloodType();
    }

    @GetMapping("donors-for-each-blood-type")
    public List<DonorsForEachBloodType> donorsForEachBloodType() {
        return candidateService.donorsForEachBloodType();
    }

    @GetMapping("percent-obese-men")
    public List<PercentObese> percentObeseMen() {
        return candidateService.percentObeseMen();
    }

    @GetMapping("percentage-obese-woman")
    public List<PercentObese> percentageObeseWoman() {
        return candidateService.percentageObeseWoman();
    }
}
