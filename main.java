import java.util.Arrays;

class Station {
    String name;
    int openingYear;

    public Station(String name, int openingYear) {
        this.name = name;
        this.openingYear = openingYear;
    }
}

class Hour {
    int passengerCount;
    String comment;

    public Hour(int passengerCount, String comment) {
        this.passengerCount = passengerCount;
        this.comment = comment;
    }
}

public class Main {
    public static void main(String[] args) {
        Station station = new Station("Площа Льва Толстого", 1976);
        Hour[] hours = {
                new Hour(100, "Багато пасажирів"),
                new Hour(50, "Нормально"),
                new Hour(75, "Пік години"),
                new Hour(30, "Мало пасажирів")
        };
        
        int totalPassengers = 0;
        for (Hour hour : hours) {
            totalPassengers += hour.passengerCount;
        }
        System.out.println("Сумарна кількість пасажирів: " + totalPassengers);

        Hour minPassengerHour = findMinPassengerHour(hours);
        System.out.println("Година з найменшою кількістю пасажирів: " + minPassengerHour.passengerCount);

        Hour maxWordCommentHour = findMaxWordCommentHour(hours);
        System.out.println("Година з найбільшою кількістю слів у коментарі: " + maxWordCommentHour.comment);
    }

    private static Hour findMinPassengerHour(Hour[] hours) {
        Hour minHour = hours[0];
        for (Hour hour : hours) {
            if (hour.passengerCount < minHour.passengerCount) {
                minHour = hour;
            }
        }
        return minHour;
    }

    private static Hour findMaxWordCommentHour(Hour[] hours) {
        Hour maxHour = hours[0];
        for (Hour hour : hours) {
            if (countWords(hour.comment) > countWords(maxHour.comment)) {
                maxHour = hour;
            }
        }
        return maxHour;
    }

    private static int countWords(String str) {
        return str.split("\\s+").length;
    }
}
