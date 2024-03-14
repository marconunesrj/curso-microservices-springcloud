package io.github.cursodsousa.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscloudgatewayApplication.class, args);
	}

	// Para fazer o Roteamento para o Discovery Server (Eureka)
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder
				.routes()
					// Quando fizer requisição para /clientes/**
				    // será redirecionado para o LoadBalance do micro serviço msclientes registrado no Eureka
					.route( r -> r.path("/clientes/**").uri("lb://msclientes") )
					.route( r -> r.path("/cartoes/**").uri("lb://mscartoes") )
					.route( r -> r.path("/avaliacoes-credito/**").uri("lb://msavaliadorcredito") )
				.build();
	}

}
