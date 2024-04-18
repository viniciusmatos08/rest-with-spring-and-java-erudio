package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
 * Essa anotacao combina a @Controller com a @ResponseBody. Para trabalhar com aplicacao web padrao
 * nao precisaria do @ResponseBody, pois a resposta seria um html, mas no rest a resposta sao apenas os dados
 * em json ou xml, sendo necessario entao o uso da anotacao @ResponseBody para atingir esse comportamento
 */
@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Teste") String name) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		
	}

}
