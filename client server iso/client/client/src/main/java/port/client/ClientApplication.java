package port.client;

import org.jpos.iso.ISOUtil;
import org.jpos.iso.MUX;
import org.jpos.q2.Q2;
import org.jpos.q2.iso.QMUX;
import org.jpos.util.NameRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean(name="Q2")
	public Q2 q2() {
		Q2 q2 = new Q2();
		q2.start();
		return q2;
	}
	
	@Bean
	public MUX mux(Q2 q2)throws NameRegistrar.NotFoundException {
		while(!q2.ready()) {
			ISOUtil.sleep(10);
		}
		return QMUX.getMUX("my-mux");
	}

}
