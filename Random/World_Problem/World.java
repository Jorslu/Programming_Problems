
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

public class World implements CountryAbstract{
    Country countries[];
    public World(Country... entities){
        this.countries = entities;

    }
}

public class Country extends CountryAbstract{

    public Country(String name, State... entities) {
        super(name, entities);
    }

    public Country(String name, City... entities) {
        super(name, entities);
    }

    public Country(String name, State state, City city) {
        super(name, state, city);
    }

    public Country(String name, State state, City city1, City city2, District district) {
        super(name, state, city1, city2, district);
    }

}

abstract class CountryAbstract extends StateAbstract {
    State states[];

    public CountryAbstract(String name, State... entities) {
        super(name);
        this.states = entities;
    }

    public CountryAbstract(String name, City... entities) {
        super(name, entities);
    }

    public CountryAbstract(String name, State state, City city) {
        super(name, city);
        this.states = new State[]{state};
    }

    public CountryAbstract(String name, State state, City city1, City city2, District district) {
        super(name, city1, city2, district);
        this.states = new State[]{state};
    }
}

public class State extends StateAbstract {
    public State(String name, City... entities){
        super(name, entities);
    }

    public State(String name, City city1, City city2, District district) {
        super(name, city1, city2, district);

    }
}

abstract class StateAbstract extends Name {
    City cities[];
    District districts[];

    public StateAbstract(String name, City... entities) {
        super(name);
        this.cities = entities;
    }

    public StateAbstract(String name, City city1, City city2, District district) {
        super(name);
        this.cities = new City[]{city1, city2};
        this.districts = new District[]{district};
    }
}

public class City extends CityDistrict{
    public City(String name, int population) {
        super(name, population);
    }
}

public class District extends CityDistrict{
    public District(String name, int population) {
        super(name, population);
    }

}

abstract class CityDistrict extends Population {
    public CityDistrict(String name, int population) {
        super(name, population);
    }
}

abstract class Population extends Name {
    int population;

    public Population(String name, int population) {
        super(name);
        this.population = population;
    }

}

abstract class Name {
    String name;

    public Name(String name) {
        this.name = name;
    }
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