package com.example.test1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Test1ApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void add() {
        Test1Application test1Application = new Test1Application();
        assert(test1Application.add(5,5) == 10);

    }
}
