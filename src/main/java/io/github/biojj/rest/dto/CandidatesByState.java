package io.github.biojj.rest.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CandidatesByState {

    private String state;
    private Integer amount;

    @Builder
    public CandidatesByState(String state, Integer amount){
        this.state = state;
        this.amount = amount;

    }
}
