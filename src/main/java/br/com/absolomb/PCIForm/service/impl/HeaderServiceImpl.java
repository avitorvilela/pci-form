package br.com.absolomb.PCIForm.service.impl;

import br.com.absolomb.PCIForm.model.HeaderModel;
import br.com.absolomb.PCIForm.repository.HeaderRepository;
import br.com.absolomb.PCIForm.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderService {

    @Autowired
    private HeaderRepository headerModelRepository;

    @Override
    public HeaderModel createHeader(HeaderModel header) {
        return headerModelRepository.save(header);
    }

    @Override
    public HeaderModel getHeaderById(Long id) {
        return headerModelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Header not found with id " + id));
    }

    @Override
    public List<HeaderModel> getAllHeaders() {
        return headerModelRepository.findAll();
    }

    @Override
    public HeaderModel updateHeader(Long id, HeaderModel header) {
        if (!headerModelRepository.existsById(id)) {
            throw new RuntimeException("Header not found with id " + id);
        }
        header.setId(id);
        return headerModelRepository.save(header);
    }

    @Override
    public void deleteHeader(Long id) {
        if (!headerModelRepository.existsById(id)) {
            throw new RuntimeException("Header not found with id " + id);
        }
        headerModelRepository.deleteById(id);
    }
}

