package br.com.absolomb.PCIForm.service;

import br.com.absolomb.PCIForm.model.LineModel;
import java.util.List;

public interface LineService {
    LineModel createLine(Long headerId, LineModel line);
    List<LineModel> getLinesByHeader(Long headerId);
    void deleteLine(Long id);
}

