package br.com.absolomb.PCIForm.service;

import br.com.absolomb.PCIForm.model.HeaderModel;

import java.util.List;

public interface HeaderService {
    HeaderModel createHeader(HeaderModel header);
    HeaderModel getHeaderById(Long id);
    List<HeaderModel> getAllHeaders();
    HeaderModel updateHeader(Long id, HeaderModel header);
    void deleteHeader(Long id);
}