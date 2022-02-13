package hw;

import java.util.ArrayList;
import java.util.List;

public class Trains {
    private List<Train> trains;

    public Trains(List<Train> trains) {
        this.trains = trains;
    }

    public Trains() {
        trains = new ArrayList<>();
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void addTrain(Train train) {
        trains.add(train);
    }
}
