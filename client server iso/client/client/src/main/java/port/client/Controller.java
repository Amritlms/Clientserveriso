package port.client;

import org.jpos.iso.ISOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private MyService service;
	
	@GetMapping("/request")
	public String request() throws ISOException{
		return this.service.response();
	}
}
