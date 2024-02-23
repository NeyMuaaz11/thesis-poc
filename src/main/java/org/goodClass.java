package org;

import org.dtos.simpleDto;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;



// for this so-called good class, one can intuitively tell that testing the main
// method "interactWithDb" will become super easy as each functionality is in its own
// method which can be mocked and verified super easily
// there will be more unit tests for this class but each of them will be very simple
// and intuitive to understand thus the simpler better tests would indicate better code...
public class goodClass {


    EntityManager entityManager;


    goodClass(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void interactWithDB(List<simpleDto> dtos, int id) throws Exception {
        // check to see if entities with that ID already exist in the db
       if (!existsInDB(dtos)) {
           persist(dtos);
       }
       // in this case mocking becomes super easy and the method can easily be tested and maintained
        // and understood by a new member of the team
    }


    protected void persist(List<simpleDto> dtos) {
        // some logic to persist
    }


    protected boolean existsInDB(List<simpleDto> dtos) {
        boolean found = false;
        for (simpleDto dto : dtos) {
            List<simpleDto> returnedFromDb = queryDb("sample query blah blah", dto);
            if (!returnedFromDb.isEmpty()) {
                found = true;
                break;
            }
        }
        return found;
    }

    protected List<simpleDto> queryDb(String query, simpleDto dto) {
        return entityManager
                .createNamedQuery(query)
                .setParameter(1, dto.getBasicIdAsPrimaryKey())
                .setParameter(2, dto.getAnotherIdAsForeignKey())
                .setParameter(4, 5) // and so on you fill the query parameters
                .getResultList();
    }


}
