package com.rubypaper;

import com.rubypaper.domain.BoardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorderControllerTest2 {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHello() throws Exception {
        String result = restTemplate.getForObject("/hello?name=둘리", String.class);
        assertEquals("Hello : 둘리", result);
    }

    @Test
    public void testGetBoard() throws Exception {
        BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
        assertEquals("테스터", board.getWriter());
    }
}
