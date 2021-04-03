package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.brands.Brand;
import com.brunoIgarzabal.invcontrol.repositories.BaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BrandServiceTest {

    private BrandService service;

    @Mock
    private BaseRepository<Brand> brandRepository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(BaseRepository.class);
        service = new BrandService();
        service.repository = brandRepository;
    }

    @Test
    public void itShouldCreateBrandWhenCall() {
        Brand brand = new Brand(null, "SomeBrand");
        Brand brand1 = new Brand(1L, "SomeBrand");

        Mockito.when(brandRepository.save(Mockito.any())).thenReturn(brand1);

        brand = this.service.insert(brand);

        assertNotNull(brand);
        assertEquals(brand, brand1);

        Mockito.verify(brandRepository).save(Mockito.any());
    }
}
