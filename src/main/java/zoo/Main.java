package zoo;

public class Main {

    public static void main(String[] argv) {

        // Create zoo
        Zoo zoo = new Zoo();
        // Add animals to the zoo
        String filePath = null;
        String fileFormat = null;

        for (String s : argv) {
            String[] args = s.split("=");
            if (args[0].equals("-configtype")) {
                fileFormat = args[1];
            } else if (args[0].equals("-configfile")) {
                filePath = args[1];
            } else {
                throw new IllegalArgumentException("Wrong config parameters");
            }
        }

        switch (fileFormat) {
            case "xml":
                zoo.addAnimalsFromXml(filePath);
                break;
            case "json":
                zoo.addAnimalsFromJson(filePath);
                break;
            case "db":
                zoo.addAnimalsFromDataBase(filePath);
                break;
            default:
                throw new IllegalArgumentException("Wrong file format");
        }


        // Create user action trigger
        ActionTrigger trigger = new ActionTrigger(zoo);

        AnimalType herbivore = AnimalType.HERBIVORE;
        AnimalType carnivore = AnimalType.CARNIVORE;

        // All of the following actions are up to users choice
        zoo.printAllStates();
        trigger.setMorning();
        zoo.printAllStates();

        trigger.visit(herbivore);
        zoo.printAllStates();
        trigger.feedAnimals(herbivore);
        zoo.printAllStates();

        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.setThunder();
        zoo.printAllStates();
        trigger.feedAnimals(carnivore);
        zoo.printAllStates();

        trigger.feedAnimals(herbivore);
        zoo.printAllStates();
        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.waterAnimals(herbivore);
        trigger.feedAnimals(herbivore);
        zoo.printAllStates();
        trigger.setRain();
        trigger.setThunder();
        zoo.printAllStates();
    }
}