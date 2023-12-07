package Finals_prof;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;

class Trip{
    private String spoint;
    private String dest;
    private String discount;
    protected int tot;

    public Trip(String spoint, String dest, String discount) {
        this.spoint = spoint;
        this.dest = dest;
        this.discount = discount;
        calculateFare();
    }

    public void calculateFare() {
        int km1 = 0;
        int km2 = 0;
        
        if(spoint.equals("San Vicente")){km1 = 6;}
        else if(spoint.equals("Banay - Banay")){km1 = 6;}
        else if(spoint.equals("Pinagtung-ulan")){km1 = 10;}
        else if(spoint.equals("Dita")){km1 = 11;}
        else if(spoint.equals("Ibabao")){km1 = 12;}
        else if(spoint.equals("Labac")){km1 = 14;}
        else if(spoint.equals("Cuenca")){km1 = 15;}
        else if(spoint.equals("Dominador")){km1 = 17;}
        else if(spoint.equals("Pinagkrusan")){km1 = 18;}
        else if(spoint.equals("Alitagtag")){km1 = 20;}
        else if(spoint.equals("San Jose")){km1 = 21;}
        else if(spoint.equals("Muzon")){km1 = 23;}
        else if(spoint.equals("Sta.Teresita")){km1 = 25;}
        else if(spoint.equals("Tawilisan")){km1 = 27;}
        else if(spoint.equals("Buli")){km1 = 28;}
        else if(spoint.equals("Mahabang Ludlod")){km1 = 29;}
        else if(spoint.equals("Balisong")){km1 = 30;}
        else if(spoint.equals("Tierra")){km1 = 31;}
        else if(spoint.equals("Taal")){km1 = 32;}   
        else if(spoint.equals("Lemery")){km1 = 33;}
        else if(spoint.equals("Sm Lipa")){km1 = 0;}
        
        if(dest.equals("San Vicente")){km2 = 6;}
        else if(dest.equals("Banay - Banay")){km2 = 6;}
        else if(dest.equals("Pinagtung-ulan")){km2 = 10;}
        else if(dest.equals("Dita")){km2 = 11;}
        else if(dest.equals("Ibabao")){km2 = 12;}
        else if(dest.equals("Labac")){km2 = 14;}
        else if(dest.equals("Cuenca")){km2 = 15;}
        else if(dest.equals("Dominador")){km2 = 17;}
        else if(dest.equals("Pinagkrusan")){km2 = 18;}
        else if(dest.equals("Alitagtag")){km2 = 20;}
        else if(dest.equals("San Jose")){km2 = 21;}
        else if(dest.equals("Muzon")){km2 = 23;}
        else if(dest.equals("Sta.Teresita")){km2 = 25;}
        else if(dest.equals("Tawilisan")){km2 = 27;}
        else if(dest.equals("Buli")){km2 = 28;}
        else if(dest.equals("Mahabang Ludlod")){km2 = 29;}
        else if(dest.equals("Balisong")){km2 = 30;}
        else if(dest.equals("Tierra")){km2 = 31;}
        else if(dest.equals("Taal")){km2 = 32;}
        else if(dest.equals("Lemery")){km2 = 33;}
        
        if (km1 > km2){tot = km1 - km2;}
        else if (km2 > km1){tot = km2 - km1;}
    }
    public int getTot() {
        return tot;
    }
    
}

class Fare extends Trip {
    public Fare(String spoint, String dest, String discount) {
        super(spoint, dest, discount);
    }
    
    public void pricing(String discount) {
    	float fare = 0;
        if (discount.equals("Regular")) {
            int total = getTot();
            if  (total <= 4){
                fare = 15.00f;
            }
            else{
                fare = 15.00f + 2.25f * (total - 4);
            }
        } else {
            int total = getTot();
            if  (total <= 4){
                fare = 15.00f - (15.00f * 0.2f); 
            }
            else{
                fare = (15.00f - (15.00f * 0.2f)) + 1.76f * (total - 4);
            }
        }
        BigDecimal bd = new BigDecimal(Float.toString(fare));
    	bd = bd.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Fare: " + bd);
    }
}

public class calc {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        LocalDate currentDate = LocalDate.now();

        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        int year = currentDate.getYear();
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Select Starting Point: ");
        String spoint = scanner.nextLine();
        System.out.print("Select Destination: ");
        String dest = scanner.nextLine();
        System.out.print("Regular/Discounted: ");
        String discount = scanner.nextLine();

        System.out.println(month + "/" + day + "/" + year);
        Trip trip = new Trip(spoint, dest, discount);
        trip.calculateFare();
        Fare f = new Fare(spoint, dest, discount);
        f.pricing(discount);
    }
}