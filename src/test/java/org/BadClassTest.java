package org;

import org.dtos.SimpleDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class BadClassTest {

    @Mock
    EntityManager entityManager;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    public void interactWithDb() {
        // ARRANGE
        BadClass badClass = new BadClass(this.entityManager);
        SimpleDto dto = mock(SimpleDto.class);
        List<SimpleDto> dtoList = new ArrayList<>();
        dtoList.add(dto);
        Query query = mock(Query.class);
        when(entityManager.createNamedQuery(anyString())).thenReturn(query);
        when(query.setParameter(anyInt(), anyInt())).thenReturn(query)
                .thenReturn(query)
                .thenReturn(query);
        when(query.getResultList()).thenReturn(dtoList);

        // ACT + ASSERT
        assertThatThrownBy(() -> badClass.interactWithDB(dtoList, 1)).isInstanceOf(Exception.class);



    }

}