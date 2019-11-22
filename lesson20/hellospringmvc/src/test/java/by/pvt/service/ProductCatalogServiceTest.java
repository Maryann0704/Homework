package by.pvt.service;

import by.pvt.TestWebMvcConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestWebMvcConfiguration.class)
@WebAppConfiguration //если Web-приложение
public class ProductCatalogServiceTest {

    @Autowired
    private ProductCatalogService productCatalogService;

    @Test
    public void getFirstTopTenProducts() {
        assertNotNull(productCatalogService);
        assertNotNull(productCatalogService.getFirstTopTenProducts());
    }
}