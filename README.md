# pci-form
API para o Decola Tech 2025.

```mermaid
erDiagram
    FORMULARIO {
        Long id
        String aeroporto
        Date data
        String secao_ua
        Double placas_por_m2
        String endereco
    }
    
    LINHA {
        Long id
        Integer patologia
        String severidade
        Integer quantidade
    }

    FORMULARIO ||--|{ LINHA : possui
```
