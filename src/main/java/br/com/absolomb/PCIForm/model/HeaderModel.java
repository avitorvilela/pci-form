package br.com.absolomb.PCIForm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity(name = "tb_header")
@SequenceGenerator(name = "header_seq", sequenceName = "header_sequence_db", allocationSize = 1)
public class HeaderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "header_seq")
    private Long id;

    private String airport;
    private String sectionUa;
    private Double platesPerM2;
    private String address;
    private String date;

    @OneToMany(mappedBy = "header", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineModel> lines;
}
