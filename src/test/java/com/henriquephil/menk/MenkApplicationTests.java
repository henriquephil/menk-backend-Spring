package com.henriquephil.menk;

import com.henriquephil.menk.service.CompraService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenkApplicationTests {
	@Autowired
	private CompraService compraService;

	@Test
	public void contextLoads() {
		assertNotNull(compraService);
	}

}
