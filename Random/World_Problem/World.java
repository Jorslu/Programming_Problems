
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

public class World implements PrintPopulation {
    public World(Country... entities){

    }
}

public class Country implements PrintPopulation {

}

public class State implements PrintPopulation {

}

public class City implements PrintPopulation {

}

public class District implements PrintPopulation {

}

interface PrintPopulation {
    int printPopulation(int population);
}