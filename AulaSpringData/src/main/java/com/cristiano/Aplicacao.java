package com.cristiano;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.cristiano.model.Imagem;
import com.cristiano.model.Produto;
import com.cristiano.repository.ImagemRepository;
import com.cristiano.repository.ProdutoRepository;

@Configuration("mainBean")
@EnableJpaRepositories(basePackages = "com.cristiano.repository")
@Import(Config.class)
@Transactional(readOnly = false)
public class Aplicacao {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private ImagemRepository imagemRepository;


	private static final Logger log = LoggerFactory.getLogger(Aplicacao.class);

	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			log.info("Produto encontrado com findAll():");
			log.info("-------------------------------");
			for (Produto produto : repository.findAll()) {
				log.info(produto.toString());
			}
			log.info("");

			Produto produto = repository.findOne(1);
			log.info("Produto encontrado com findOne(1L):");
			log.info("--------------------------------");
			log.info(produto.toString());
			log.info("");

			log.info("Produto encontrado com findByLastName('Teclado'):");
			log.info("--------------------------------------------");
			for (Produto tec : repository.findByNome("Teclado")) {
				log.info(tec.toString());
			}
			log.info("");
		};
	}
	
	@Bean
	public CommandLineRunner salvarImagens() {
		return (args) -> {
			Produto p = repository.findOne(2);
			Imagem i = new Imagem();
			i.setTipo("JPEG");
			i.setProduto(p);
			Imagem i2 = new Imagem();
			i2.setTipo("GIF");
			i2.setProduto(p);
			Imagem i3 = new Imagem();
			i3.setTipo("BITMAP");
			i3.setProduto(p);
			Imagem i4 = new Imagem();
			i4.setTipo("JPG");
			i4.setProduto(p);
			
		/*	imagemRepository.save(i);
			imagemRepository.save(i2);
			imagemRepository.save(i3);
			imagemRepository.save(i4); */
			
			List<Imagem> im = imagemRepository.findByTipo("BITMAP");
			
			
			
		};
	}


}
