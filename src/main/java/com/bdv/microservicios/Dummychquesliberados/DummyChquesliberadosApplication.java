package com.bdv.microservicios.Dummychquesliberados;

import com.bdv.microservicios.Dummychquesliberados.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DummyChquesliberadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyChquesliberadosApplication.class, args);
		Utils.cargarListaDeCheques();
	}

}


