package org;

import org.dtos.SimpleDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class GoodClassTest {

    @Mock
    EntityManager entityManager;


    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    public void interactWithDbTest() throws Exception {
        // ARRANGE
        GoodClass goodClass = spy(new GoodClass(this.entityManager));
        SimpleDto dto = mock(SimpleDto.class);
        List<SimpleDto> dtoList = new ArrayList();
        dtoList.add(dto);
        when(goodClass.existsInDB(anyList())).thenReturn(false);
        doNothing().when(goodClass).persist(anyList());

        // ACT
        goodClass.interactWithDB(dtoList, 1);

        // ASSERT
        verify(goodClass).persist(dtoList);
    }

}