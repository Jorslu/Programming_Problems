// Main Class given. Do not touch anything inside this class.
class Main {
    public static void main(String[] args) {
        World myWorld = new World(
                new Country("USA",
                        new State("NY",
                                new City("New York", 8143197)),
                        new City("LA", 3844829),
                        new City("Chicago", 2842518),
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

// Author: Jorge Perez

// Interfaces
interface PopulationInterface {
    int printPopulation(int population);
}

interface PrintWorldInterface {
    void printWorld();
}

//Base Abstract classes
abstract class Name {
    String name;

    public Name(String name) {
        this.name = name;
    }
}

abstract class Population extends Name {
    int population;

    public Population(String name, int population) {
        super(name);
        this.population = population;
    }
}

//City & District Abstract/Concrete
abstract class CityDistrict extends Population implements PopulationInterface, PrintWorldInterface {
    public CityDistrict(String name, int population) {
        super(name, population);
    }

    public int printPopulation(int population) {
        return this.population + population;
    }

    public void printWorld() {
        System.out.println(this.name);
    }
}

class City extends CityDistrict {
    public City(String name, int population) {
        super(name, population);
    }
}

class District extends CityDistrict {
    public District(String name, int population) {
        super(name, population);
    }
}

// State Abstract/Concrete
abstract class StateAbstract extends Name implements PopulationInterface, PrintWorldInterface {
    City cities[];
    District districts[];

    public StateAbstract(String name, City... entities) {
        super(name);
        this.cities = entities;
        this.districts = new District[]{};
    }

    public StateAbstract(String name, City city1, City city2, District district) {
        super(name);
        this.cities = new City[]{city1, city2};
        this.districts = new District[]{district};
    }

    public int printPopulation(int population) {
        for(City city: cities) {
            population = city.printPopulation(population);
        }

        for(District district: districts) {
            population = district.printPopulation(population);
        }

        return population;
    }

    public void printWorld() {
        System.out.println(this.name);

        for (City city : cities) {
            city.printWorld();
        }

        for (District district : districts) {
            district.printWorld();
        }
    }
}

class State extends StateAbstract {
    public State(String name, City... entities) {
        super(name, entities);
    }

    public State(String name, City city1, City city2, District district) {
        super(name, city1, city2, district);
    }
}

// Country Abstract/Concrete
abstract class CountryAbstract extends StateAbstract implements PopulationInterface, PrintWorldInterface {
    State states[];

    public CountryAbstract(String name, State... entities) {
        super(name);
        this.states = entities;
    }

    public CountryAbstract(String name, City... entities) {
        super(name, entities);
        this.states = new State[]{};
    }

    public CountryAbstract(String name, State state, City city) {
        super(name, city);
        this.states = new State[]{state};
    }

    public CountryAbstract(String name, State state, City city1, City city2, District district) {
        super(name, city1, city2, district);
        this.states = new State[]{state};
    }

    //I have this here because if not, World constructor will throw error.
    // I honestly do not know why I need this if the Name Parent class has
    // this same constructor..
    public CountryAbstract(String name) {
        super(name);
    }

    public int printPopulation(int population) {
        for(State state : states) {
            population = state.printPopulation(population);
        }

        for(City city : cities) {
            population = city.printPopulation(population);
        }

        for(District district : districts) {
            population = district.printPopulation(population);
        }

        return population;
    }

    public void printWorld() {
        System.out.println(this.name);

        for(State state : states) {
            state.printWorld();
        }

        for(City city : cities) {
            city.printWorld();
        }

        for(District district : districts) {
            district.printWorld();
        }
    }
}

class Country extends CountryAbstract {

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

// World Abstract/Concrete
abstract class WorldAbstract extends CountryAbstract implements PopulationInterface, PrintWorldInterface {
    Country countries[];

    public WorldAbstract (Country... entities) {

        // Have this here because of I'm instantiating all the way to the parent classes
        // And even though I know world doesn't have a name, that doesn't mean it can't
        // have an empty string :)
        super("");
        this.countries = entities;
        this.states = new State[]{};
        this.cities = new City[]{};
        this.districts = new District[]{};
    }

    // After the fact, I realized (void printPopulation) wasn't part of the
    // interface contract. Modified it after the fact.
    public int printPopulation() {
        int sum = 0;

        for(Country country : countries) {
            sum = country.printPopulation(sum);
        }

        System.out.println(sum);

        return 0;
    }

    public void printWorld() {
        System.out.println(this.name);

        for(Country country : countries) {
            country.printWorld();
        }
    }
}

class World extends WorldAbstract {
    public World(Country... entities) {
        super(entities);
    }
}


