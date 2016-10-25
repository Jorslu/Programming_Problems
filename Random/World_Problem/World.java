
// Main Class given. Do not touch anything inside this class.
public class Main {
    public static void main(String[] args) {
        World myWorld = new World(
                new Country("USA",
                        new State("NY",
                                new City("New York", 8143197)),
                        new City("LA", 3844829),
                        new City("Chicago", 28425180),
                        new District("Washington D.C.", 658893)),
                new Country("Germany",
                        new City("Berlin", 3336026),
                        new City("Hamburg", 1605606),
                        new City("Munich", 831937)),
                new Country("Tamriel",
                        new State("Skyrim",
                                new City("Dragonsreach", 580),
                                new City("Falkreath", 390),
                                new District("Sheogorath's Realm", 666)),
                        new State("Morrowind",
                                new City("Seyda Neen", 46))));

        myWorld.printPopulation();

        System.out.println();

        myWorld.printWorld();
    }
}

public class World {
    public World(Country... entities){

    }
}

public class Country {
    public Country(String name, State... entities) {

    }

    public Country(String name, City... entities) {

    }

    public Country(String name, State state, City city) {

    }

    public Country(String name, State state, City city1, City city2, District district) {

    }

}

public class State {
    public State(String name, City... entities){

    }

    public State(String name, City city1, City city2, District district1) {

    }
}

public class City {
    public City(String name, int population) {}
}

public class District {
    public District(String name, int population) {}

}


abstract class PrintPopulationClass implements PopulationInterface {

    int printPopulation(int population) {
        //Call Child and pass population
    }
}

abstract class SumPopulationClass implements PopulationInterface {
    int population;

    public int printPopulation(int population) {
        int sum = this->population + population;
    }
}

interface PopulationInterface {
    int printPopulation(int population);
}