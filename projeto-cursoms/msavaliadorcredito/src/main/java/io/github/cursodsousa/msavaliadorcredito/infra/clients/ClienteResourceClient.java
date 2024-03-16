package io.github.cursodsousa.msavaliadorcredito.infra.clients;

import io.github.cursodsousa.msavaliadorcredito.domain.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Comunicação Síncrona (direta) entre os micros serviços
// O FeignClient é um HTTP client que vai fazer a comunicação entre os micros serviços
//@FeignClient(url = "http://localhost:8080", path = "/clientes")  // Utilizar quando for fazer acesso direto pelo http
// msclientes -> é o spring.application.name do micro serviço no application.yml
@FeignClient(value = "msclientes", path = "/clientes")  // Utilizar quando for acessar via Gateway (LoadBalancer)
public interface ClienteResourceClient {

    // Mesma implementação do micro serviço msclientes na classe: ClientesResource.java
    @GetMapping(params = "cpf")
    // Aqui tem que especificar o tipo de objeto ResponseEntity como DadosCliente
    ResponseEntity<DadosCliente> dadosCliente(@RequestParam("cpf") String cpf);

}
