package br.com.absolomb.PCIForm.service.impl;

import br.com.absolomb.PCIForm.model.HeaderModel;
import br.com.absolomb.PCIForm.model.LineModel;
import br.com.absolomb.PCIForm.repository.HeaderRepository;
import br.com.absolomb.PCIForm.repository.LineRepository;
import br.com.absolomb.PCIForm.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LineServiceImpl implements LineService {

    @Autowired
    private LineRepository lineModelRepository;

    @Autowired
    private HeaderRepository headerModelRepository;

    @Override
    public LineModel createLine(Long headerId, LineModel line) {
        HeaderModel header = headerModelRepository.findById(headerId)
                .orElseThrow(() -> new RuntimeException("Header not found with id " + headerId));

        line.setHeader(header);
        return lineModelRepository.save(line);
    }

    @Override
    public List<LineModel> getLinesByHeader(Long headerId) {
        HeaderModel header = headerModelRepository.findById(headerId)
                .orElseThrow(() -> new RuntimeException("Header not found with id " + headerId));

        return lineModelRepository.findByHeader(header);
    }

    @Override
    public void deleteLine(Long id) {
        if (!lineModelRepository.existsById(id)) {
            throw new RuntimeException("Line not found with id " + id);
        }
        lineModelRepository.deleteById(id);
    }
}

