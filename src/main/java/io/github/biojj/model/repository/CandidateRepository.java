package io.github.biojj.model.repository;

import io.github.biojj.model.entity.Candidate;
import io.github.biojj.rest.dto.PercentObese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Query(value = "SELECT a.state, COUNT(c.id)" +
            "FROM Candidate c\n" +
            "INNER JOIN Address a ON c.address_id = a.id\n" +
            "GROUP BY a.state", nativeQuery = true)
    List<Object[]> countCandidatesByState();

    @Query(value = "SELECT blood_type, " +
            "AVG(DATEDIFF(CURDATE(), " +
            "STR_TO_DATE(data_nasc, '%d/%m/%Y'))) AS media_idade\n" +
            "FROM Candidate\n" +
            "GROUP BY blood_type", nativeQuery = true)
    List<Object[]> averageAgeByBloodType();


    @Query(value = "SELECT\n" +
            "  receptor.blood_type AS receptor,\n" +
            "  COUNT(doador.blood_type) AS quantidade\n" +
            "FROM\n" +
            "  Candidate receptor\n" +
            "  LEFT JOIN Candidate doador ON\n" +
            "    (receptor.blood_type = 'A+' AND doador.blood_type IN ('AB+', 'A+')) OR\n" +
            "    (receptor.blood_type = 'A-' AND doador.blood_type IN ('A+', 'A-', 'AB+', 'AB-')) OR\n" +
            "    (receptor.blood_type = 'B+' AND doador.blood_type IN ('B+', 'AB+')) OR\n" +
            "    (receptor.blood_type = 'B-' AND doador.blood_type IN ('B+', 'B-', 'AB+', 'AB-')) OR\n" +
            "    (receptor.blood_type = 'AB+' AND doador.blood_type IN ('AB+')) OR\n" +
            "    (receptor.blood_type = 'AB-' AND doador.blood_type IN ('AB+', 'AB-')) OR\n" +
            "    (receptor.blood_type = 'O+' AND doador.blood_type IN ('A+', 'B+', 'O+', 'AB+')) OR\n" +
            "    (receptor.blood_type = 'O-' AND doador.blood_type IN ('A+', 'B+', 'O+', 'AB+', 'A-', 'B-', 'O-', 'AB-'))\n" +
            "GROUP BY\n" +
            "  receptor.blood_type;", nativeQuery = true)
    List<Object[]> donorsForEachBloodType();


    @Query(value = "SELECT\n" +
            "    COUNT(*) AS total,\n" +
            "    (SELECT COUNT(*) FROM Candidate WHERE sexo = 'Feminino' AND Weight / (height * height) > 30) AS totalObese,\n" +
            "    ((SELECT COUNT(*) FROM Candidate WHERE sexo = 'Feminino' AND Weight / (height * height) > 30) / (SELECT COUNT(*) FROM Candidate WHERE sexo = 'Feminino')) * 100 AS percentageObese\n" +
            "FROM Candidate\n" +
            "WHERE sexo = 'Masculino';", nativeQuery = true)
    List<Object[]> percentObeseMen();

    @Query(value = "SELECT\n" +
            "    COUNT(*) AS total,\n" +
            "    (SELECT COUNT(*) FROM Candidate WHERE sexo = 'Masculino' AND Weight / (height * height) > 30) AS totalObese,\n" +
            "    ((SELECT COUNT(*) FROM Candidate WHERE sexo = 'Masculino' AND Weight / (height * height) > 30) / (SELECT COUNT(*) FROM Candidate WHERE sexo = 'Masculino')) * 100 AS percentageObese\n" +
            "FROM Candidate\n" +
            "WHERE sexo = 'Feminino';", nativeQuery = true)
    List<Object[]> percentageObeseWoman();
}