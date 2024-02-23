package org;

import org.dtos.simpleDto;

import javax.persistence.EntityManager;
import java.util.List;


// testing this class would be very difficult as everything is
// inside the same method and there would be no mocking possible
// we would have to test every possible flow of execution which will create
// a very unnecessarily complex test
public class badClass {

    EntityManager entityManager;


    badClass(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public void interactWithDB(List<simpleDto> dtos, int id) throws Exception {
        // check to see if entities with that ID already exist in the db
        for (simpleDto dto : dtos) {
            List<simpleDto> returnedFromDb = entityManager
                    .createNamedQuery("insert super long query to find the element in the db")
                    .setParameter(1, dto.getBasicIdAsPrimaryKey())
                    .setParameter(2, dto.getAnotherIdAsForeignKey())
                    .setParameter(4, 5) // and so on you fill the query parameters
                    .getResultList();
            if (!returnedFromDb.isEmpty()) {
                throw new Exception();
            }
        }
        // now save the list into the db which would be something similar to what is above
        // testing this would be very painful and time consuming as mocking behaviours in this context
        // is not so simple... the same is implemented in the goodClass but using OOP to make it testable

    }




}
