package LLD.ParkingLot;

public abstract class Vehicle {
    private Long id;
    private int size;

    public Vehicle(Long id){
        this.id = id;
        if(this instanceof Car || this instanceof Moto){
            this.size = 1;
        }else{
            this.size = 3;
        }
    }

    public int getSize() {
        return size;
    }

    public Long getId() {
        return id;
    }
}
