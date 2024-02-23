package org;

import org.dtos.SimpleDto;

import javax.persistence.EntityManager;
import java.util.List;


// for this so-called good class, one can intuitively tell that testing the main
// method "interactWithDb" will become super easy as each functionality is in its own
// method which can be mocked and verified super easily
// there will be more unit tests for this class but each of them will be very simple
// and intuitive to understand thus the simpler better tests would indicate better code...
public class GoodClass {


    EntityManager entityManager;


    GoodClass(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void interactWithDB(List<SimpleDto> dtos, int id) throws Exception {
        // persist only if that ID does not already exist
       if (!existsInDB(dtos)) {
           persist(dtos);
       }
       // in this case mocking becomes super easy and the method can easily be tested and maintained
        // and understood by a new member of the team
    }


    protected void persist(List<SimpleDto> dtos) {
        // some logic to persist
        System.out.println("inside persist");
    }


    protected boolean existsInDB(List<SimpleDto> dtos) {
        boolean found = false;
        for (SimpleDto dto : dtos) {
            List<SimpleDto> returnedFromDb = queryDb("sample query blah blah", dto);
            if (!returnedFromDb.isEmpty()) {
                found = true;
                break;
            }
        }
        return found;
    }

    protected List<SimpleDto> queryDb(String query, SimpleDto dto) {
        return entityManager
                .createNamedQuery(query)
                .setParameter(1, dto.getBasicIdAsPrimaryKey())
                .setParameter(2, dto.getAnotherIdAsForeignKey())
                .setParameter(4, 5) // and so on you fill the query parameters
                .getResultList();
    }


}
