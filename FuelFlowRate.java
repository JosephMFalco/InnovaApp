public class FuelFlowRate {

    private double fuelTankSize;
    private double flowRate;

    public FuelFlowRate() {



    }

    public FuelFlowRate(double tank) {

        fuelTankSize = tank;

    }

    public FuelFlowRate(double rate, double tank) {

        fuelTankSize = tank;
        flowRate = rate;

    }

    public void setFuelRate(double rate) {

        flowRate = rate;

    }

    public void setTankSize(double tank) {

        fuelTankSize = tank;

    }

    public double getFlowRate() {

        return flowRate;

    }

    public double getFuelTankSize() {

        return fuelTankSize;

    }

}
