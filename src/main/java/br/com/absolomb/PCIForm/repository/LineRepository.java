package br.com.absolomb.PCIForm.repository;

import br.com.absolomb.PCIForm.model.HeaderModel;
import br.com.absolomb.PCIForm.model.LineModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineRepository extends JpaRepository<LineModel, Long> {
    List<LineModel> findByHeader(HeaderModel header);
}
