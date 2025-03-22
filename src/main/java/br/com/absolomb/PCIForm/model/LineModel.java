package br.com.absolomb.PCIForm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_line")
@SequenceGenerator(name = "line_seq", sequenceName = "line_seq", allocationSize = 1)
public class LineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "line_seq")
    private Long id;

    private Integer pathology;
    private String severity;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "header_id", nullable = false)
    private HeaderModel header;
}