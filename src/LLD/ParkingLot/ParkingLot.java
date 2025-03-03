package LLD.ParkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLot {
    private List<List<Vehicle>> parkingSpots;
    private int totalLevels;
    private int[] openSpotsByLevel;

    public ParkingLot(int levels){
        this.totalLevels = levels;
        this.openSpotsByLevel = new int[totalLevels];

        Arrays.fill(openSpotsByLevel, 10);

        for(int i = 0; i < levels; i++){
            this.parkingSpots.add(new ArrayList<>());
        }
    }

    public boolean park(Vehicle vehicle){
        // check for open spot starting from level 0 - totalLevels
        // park it and increment openSpotsByLevel
        for(int i = 0; i < openSpotsByLevel.length; i++){
            if(vehicle.getSize() < openSpotsByLevel[i]){
                for(int j = 0; j < vehicle.getSize(); j++){
                    parkingSpots.get(i).add(vehicle);
                    openSpotsByLevel[i] = parkingSpots.get(i).size();
                    return true;
                }
            }
        }

        // no spots open in parking lot
        return false;
    }

    public boolean unpark(Vehicle vehicle){
        // find and remove from arraylist
        for(int i = 0; i < parkingSpots.size(); i++){
            for(int j = 0; j < parkingSpots.get(i).size(); j++){
                Vehicle curr = parkingSpots.get(i).get(j);
                if(vehicle.getId() == curr.getId()){
                    int size = curr.getSize();
                    for(int k = 0; k < size; k++){ parkingSpots.get(i).remove(j); }
                    return true;
                }
            }
        }

        // car doesn't exist in parking lot
        return false;
    }

    public int[] whereParked(Vehicle vehicle){
        // search arraylist for vehicle id
        for(int i = 0; i < parkingSpots.size(); i++){
            for(int j = 0; j < parkingSpots.get(i).size(); j++) {
                Vehicle curr = parkingSpots.get(i).get(j);
                if (vehicle.getId() == curr.getId()) {
                    return new int[]{ i, j };
                }
            }
        }

        // not parking in parking lot
        return new int[]{ -1, -1 };
    }
}
