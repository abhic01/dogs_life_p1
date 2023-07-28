package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {
    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }


    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one(){
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        int expectedResult = 1;
        //act
        long actualResult = cut.getNoOfDogs();
        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added(){
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        Dog theDog1 = new Dog();
        theDog1.setName("Max");
        cut.addDog(theDog1);

        Dog theDog2 = new Dog();
        theDog2.setName("Boom");
        cut.addDog(theDog2);

        int expectedResult = 3;
        long actualResult = cut.getNoOfDogs();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public  void    find_dog_by_name_returns_one_dog()
    {
        DogHandler cut = new DogHandler(itsDogRepo);
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog( theDog );
        Dog expectedDog = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );
        ArrayList<Dog> expectedList = new ArrayList<>();
        expectedList.add(expectedDog);
        //Mockito.when(itsDogRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Dog actualResult = cut.getDogByName( dogToFind );

        // assert
        assertEquals( expectedDog.getId(), actualResult.getId() );
        assertEquals( expectedDog.getName(), actualResult.getName() );
    }


}
