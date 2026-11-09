package practice4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        TemperatureSensor sensor1 = new TemperatureSensor("sensor1", "10", 26, new double[]{0, 30});
        TemperatureSensor sensor2 = new TemperatureSensor("sensor2", "11", 22, new double[]{0, 30});
        System.out.println(sensor1);
        System.out.println(sensor2);
        try {
            sensor1.changeTemp(31);
            System.out.println(sensor1);
        } catch (IllegalArgumentException e) {
            System.out.println("ошибка: " + e.getMessage());
        }

    }
}

class TemperatureSensor {
    private String name;
    private String room;
    private double currTemp;
    private double[] permRange;

    TemperatureSensor(String name, String room, double currTemp, double[] permRange) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("некорректное имя");
        }
        if (room == null || room.isBlank()) {
            throw new IllegalArgumentException("некорректное название помещения");
        }
        if (permRange == null || permRange[0] >= permRange[1] || permRange.length != 2) {
            throw new IllegalArgumentException("некорректный диапазон");
        }

        checkTemp(currTemp, permRange);
        this.name = name;
        this.room = room;
        this.currTemp = currTemp;
        this.permRange = permRange.clone();
    }

    public void changeTemp(double newTemp) {
        checkTemp(newTemp, permRange);
        this.currTemp = newTemp;
    }

    @Override 
    public String toString() {
        return name + " " + "room: " + room + " " + "permRange: " + Arrays.toString(permRange) + " " + "current temp: " + currTemp; 
    }

    private void checkTemp(double temp, double[] range) {
        if (temp > range[1] || temp < range[0]) {
            throw new IllegalArgumentException("показания выходят за диапазон");
        }
    }
}
