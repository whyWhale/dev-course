package com.programmers.devcourse.inner_class.ex2;

public class Car {

    final String carName;
    final String carType;

    public Car(String carName, String carType) {
        this.carName = carName;
        this.carType = carType;
    }

    private String getCarName() {
        return carName;
    }

    public class Engine {

        String engineType;

        public void setEngineType() {
            if (Car.this.carType.equals("4WD")) {
                if (Car.this.getCarName().equals("Crysler")) {
                    this.engineType = "Smaller";
                } else {
                    this.engineType = "Bigger";
                }
            } else {
                this.engineType = "Bigger";
            }
        }

        public String getEngineType() {
            return this.engineType;
        }
    }
}
