import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class addVaccine{
    public String name;
    public int num;
    public int gap;

    public addVaccine(String x, int y, int z){
        name = x;
        num = y;
        gap = z;
    }

    public String getname(){
        return name;
    }
    public int getnum(){
        return num;
    }
    public int getgap(){
        return gap;
    }

    public void display(){
        System.out.println("Vaccine Name:"+ name+","+"Number of Doses:"+num+","+"Gap Between Doses:"+gap);
    }
}
class regHospital{
    public String Hosp_name;
    public int Pincode;
    public int uniqueID;
    public ArrayList vaccine = new ArrayList();

    public regHospital(String x,int y,int z) {
        Hosp_name = x;
        Pincode = y;
        uniqueID = z;
    }
    public String getHosp_name(){
        return Hosp_name;
    }
    public int getPincode(){
        return Pincode;
    }
    public int getuniqueID(){
        return uniqueID;
    }
    public void display() {
        System.out.println("Allocated Hospital ID is "+uniqueID);
        System.out.println("Hospital Name: "+Hosp_name+","+" PinCode: "+Pincode+"," +"Unique ID: "+uniqueID);
    }
    public void setVaccine(String vac){
        vaccine.add(vac);
    }
    public boolean getVaccine(String vac){
        for(int i = 0;i<vaccine.size();i++){
            if(vaccine.get(i).equals(vac)){
                return true;
            }
        }
        return false;
    }

}
class regCitizen{
    public String name;
    public int age;
    public long uniqueID;
    public String vaccination_status;
    public String vaccine;
    public int givenDoses ;
    public int citizen_day_number;

    public regCitizen(String x, int y, long z){
        name = x;
        age = y;
        uniqueID = z;
        givenDoses = 0;
    }

//    public regCitizen(){
//
//    }
    public String getname(){
        return name;
    }
    public int getage(){
        return age;
    }
    public long getuniqueID(){
        return uniqueID;
    }
    public String getvaccination_status(){
        return vaccination_status;
    }
    public String getvaccine(){
        return vaccine;
    }
    public int getGivenDoses(){
        return givenDoses;
    }
    public void setGivenDoses(){
        givenDoses = givenDoses +1;
    }
    public void setDay_number(int x){
        citizen_day_number = x;
    }
    public int getDay_number(){
        return citizen_day_number;
    }
    public void display(){
        System.out.println("Citizen Name: "+name+"," +"Age: "+age+","+"Unique ID: "+uniqueID);
    }
}
class Slots {
    public int HospitalID;
    public int vaccine_day_number;
    public int quantity;
    public String vaccine;
    public int curr_day_number;

    public Slots(int x, int y, int z,String vac){

        HospitalID = x;
        vaccine_day_number =  y;
        quantity = z;
        vaccine = vac;
        //citizen_day_number = super(citizen_day_number )
    }


    public int getHospitalID(){
        return HospitalID;
    }
    public int getVaccine_day_number(){
        return vaccine_day_number;
    }
    public int getquantity(){
        return quantity;
    }
    public void setDay_number(int x){
        curr_day_number = x;
    }
    public int getDay_number(){
        return curr_day_number;
    }
    public String getvaccine(){
        return vaccine;
    }

    public void display(){
        System.out.println("Slot added by Hospital "+HospitalID+" for Day:"+vaccine_day_number+","+"Available Quantity:"+quantity+" of Vaccine "+vaccine);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CoWin Portal initialized....");
        ArrayList vaccines = new ArrayList();
        ArrayList hospitalIDs = new ArrayList();
        ArrayList citizenIDs = new ArrayList();
        addVaccine v[] = new addVaccine[100];
        regHospital h[] = new regHospital[100];
        regCitizen Citizen[] = new regCitizen[100];
        Slots slot[] = new Slots[100];
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
	    while(true){
            printMenu();
	        int x = sc.nextInt();
	        if(x==1){
	            System.out.print("Vaccine Name: ");
	            String a = sc.next();
                System.out.print("Number of Doses: ");
                int b = sc.nextInt();
                int c = 0;
                if(b>1){
                    System.out.print("Gap between Doses: ");
                    c = sc.nextInt();
                }
                v[count] = new addVaccine(a,b,c);
                //vaccines.add(v);
                v[count].display();
                count += 1;
            }
	        if(x==2){
	            System.out.print("Hospital Name:");
	            String a = sc.next();
                System.out.print("PinCode:");
                int b = sc.nextInt();
                int c = ThreadLocalRandom.current().nextInt(100000,999999);
                h[count1] = new regHospital(a,b,c);
                hospitalIDs.add(h);
                h[count1].display();
                count1 += 1;
            }
            if(x==3){
                System.out.print("Citizen Name:");
                String a = sc.next();
                System.out.print("Age:");
                int b = sc.nextInt();
                System.out.print("Unique ID:");
                long c = sc.nextLong();
                long temp = c;
                int counter = 0;
                while(temp!=0){
                    temp = temp/10;
                    ++counter;
                }
                if(counter==12){
                    if(b>=18){
                        citizenIDs.add(h);
                        Citizen[count2] = new regCitizen(a,b,c);
                        Citizen[count2].display();
                        count2 += 1;
                    }
                    else{
                        regCitizen c1 = new regCitizen(a,b,c);
                        c1.display();
                        System.out.println("Only above 18 are allowed");
                    }
                }
                else{
                    System.out.println("Please enter a valid ID");
                }
            }
            if(x==4){
                System.out.print("Enter Hospital ID:");
                int HI = sc.nextInt();
                System.out.print("Enter number of Slots to be added:");
                int s = sc.nextInt();
                for(int j = 0;j<s;j++){
                    System.out.print("Enter Day Number:");
                    int d = sc.nextInt();
                    System.out.print("Enter Quantity:");
                    int quant = sc.nextInt();
                    System.out.println("Select Vaccine");
                    for(int i  = 0;i<v.length;i++){
                        if(v[i]!=null){
                            System.out.println(i+"."+v[i].getname());
                        }
                    }
                    int q = sc.nextInt();
                    String v1 = v[q].getname();
                    boolean flag = true;
//                    for(int i = 0;i< slot.length;i++){
//                        if(slot[i]!=null){
//                            if(slot[i].getVaccine_day_number()==d){
//                                if(slot[i].getvaccine()!=null){
//                                    if(slot[i].getvaccine().equals(v1)){
//                                        slot[i].quantity += quant;
//                                        flag = false;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    if(flag){
                        slot[count3] = new Slots(HI,d,quant,v1);
                        slot[count3].display();
                        count3 += 1;
                        for(int i = 0;i<h.length;i++){
                            if(h[i]!=null){
                                if(h[i].getuniqueID()==HI){
                                    h[i].setVaccine(v1);
                                }
                            }
                        }
                    }

            }
            if(x==5){
                System.out.print("Enter patient Unique ID: ");
                long id = sc.nextLong();
                boolean flag2 = true;
                String vacc1 = null;
                for(int i = 0;i<Citizen.length;i++){
                    if(Citizen[i]!=null){
                        if(Citizen[i].getuniqueID()==id){
                            flag2 = false;
                            vacc1 = Citizen[i].getvaccine();
                        }
                    }
                }
                if(!flag2){
                    System.out.println("1. Search by area ");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.print("Enter option: ");
                    int a = sc.nextInt();
                    boolean flag = false;
                    if(a==1) {
                        if (vacc1 == null) {
                            int day_no = 0;
                            System.out.print("Enter PinCode: ");
                            int b = sc.nextInt();
                            for (int i = 0; i < h.length; i++) {
                                if (h[i] != null) {
                                    if (h[i].getPincode() == b) {
                                        System.out.println(h[i].getuniqueID() + " " + h[i].getHosp_name());
                                    }
                                }
                            }
                            System.out.print("Enter hospital id: ");
                            int c = sc.nextInt();
                            for (int i = 0; i < slot.length; i++) {
                                if (slot[i] != null) {
                                    if (slot[i].getHospitalID() == c) {
                                        int r = slot[i].getVaccine_day_number();
                                        if (slot[i].getDay_number() < r) {

                                                if (vacc1 == null) {
                                                    System.out.println(r - 1 + "->" + "Day: " + r + " Available Qty:" + slot[i].getquantity() + " Vaccine:" + slot[i].getvaccine());
                                                    flag = true;
                                                } else if (slot[i].getvaccine().equals(vacc1)) {
                                                    System.out.println(r - 1 + "->" + "Day: " + r + " Available Qty:" + slot[i].getquantity() + " Vaccine:" + slot[i].getvaccine());
                                                    flag = true;
                                                }


                                        }
//                                else if(i== slot.length-1 && flag == true){
//                                    flag = false;
//                                }
                                    } else if (i == slot.length - 1 && slot[i].getHospitalID() != c) {
                                        flag = false;
                                    }
                                }
                            }
                            String vacc = null;
                            boolean flag1 = true;
                            for (int i = 0; i < Citizen.length; i++) {
                                if (Citizen[i] != null) {
                                    if (Citizen[i].getuniqueID() == id) {
                                        if (Citizen[i].getvaccination_status() != null) {
                                            if (Citizen[i].getvaccination_status().equals("FULLY VACCINATED")) {
                                                System.out.println("Citizen completely vaccinated");
                                                flag = false;
                                                flag1 = false;
                                            }
                                        }
                                    }
                                }

                            }
                            if (flag) {
                                System.out.print("Choose Slot: ");
                                int slot_no = sc.nextInt();
                                boolean flags = true;
                                for (int i = 0; i < slot.length; i++) {
                                    if (slot[i] != null) {
                                        if (slot[i].getVaccine_day_number() - 1 == slot_no) {
                                            if(slot[i].getquantity()!=0){
                                                slot[i].quantity -= 1;
                                                vacc = slot[i].getvaccine();
                                                day_no = slot[i].getVaccine_day_number();
                                                slot[i].setDay_number(day_no);
                                            }
                                            else{
                                                flags = false;
                                            }
                                        }
                                    }
                                }
                                int num = 0;
                                for(int i = 0;i<v.length;i++){
                                    if(v[i]!=null){
                                        if(v[i].getname().equals(vacc)){
                                            num = v[i].getnum();
                                        }
                                    }
                                }
                                if(flags){
                                    for (int i = 0; i < Citizen.length; i++) {
                                        if (Citizen[i] != null) {
                                            Citizen[i].vaccine = vacc;
                                            Citizen[i].setGivenDoses();
                                            if (Citizen[i].getuniqueID() == id) {
                                                if (Citizen[i].getGivenDoses() != num) {
                                                    Citizen[i].vaccination_status = "PARTIALLY VACCINATED";
                                                    System.out.println(Citizen[i].getname() + " vaccinated with " + Citizen[i].getvaccine());
                                                } else {
                                                    Citizen[i].vaccination_status = "FULLY VACCINATED";
                                                    System.out.println(Citizen[i].getname() + " vaccinated with " + Citizen[i].getvaccine());
                                                }
                                                Citizen[i].setDay_number(day_no);
                                            }
                                        }
                                    }
                                }
                                else{
                                    System.out.println("No slots available");
                                }

                            } else if (!flag) {
                                if (flag1) {
                                    System.out.println("No slots available");
                                }
                            }

                        }
                        else {
                            int day_no = 0;
                            System.out.print("Enter PinCode: ");
                            int b = sc.nextInt();
                            for(int i = 0;i<h.length;i++){
                                if(h[i]!=null){
                                    if(h[i].getPincode()==b){
                                        System.out.println(h[i].getuniqueID()+ " "+ h[i].getHosp_name());
                                    }
                                }
                            }
                            System.out.print("Enter hospital id: ");
                            int c = sc.nextInt();
                            int gap = 0;
                            int num = 0;
                            for(int i = 0;i<v.length;i++){
                                if(v[i]!=null){
                                    if(vacc1!=null){
                                        if(v[i].getname().equals(vacc1)){
                                            gap = v[i].getgap();
                                            num = v[i].getnum();
                                        }
                                    }
                                }
                            }
                            for(int i = 0;i<slot.length;i++){
                                if(slot[i]!=null){
                                    if(slot[i].getHospitalID()==c){
                                        int r = slot[i].getVaccine_day_number();
                                        if(slot[i].getDay_number()+gap<r){

                                                if(vacc1==null){
                                                    System.out.println(r-1+"->"+"Day: "+r+" Available Qty:"+slot[i].getquantity()+ " Vaccine:"+slot[i].getvaccine());
                                                    flag = true;

                                                }
                                                else if(slot[i].getvaccine().equals(vacc1)){
                                                    System.out.println(r-1+"->"+"Day: "+r+" Available Qty:"+slot[i].getquantity()+ " Vaccine:"+slot[i].getvaccine());
                                                    flag = true;

                                                }


                                        }
//                                else if(i== slot.length-1 && flag == true){
//                                    flag = false;
//                                }
                                    }
                                    else if(i== slot.length-1 && slot[i].getHospitalID()!=c){
                                        flag = false;
                                    }
                                }
                            }
                            String vacc = null;
                            boolean flag1 = true;
                            for(int i = 0;i<Citizen.length;i++){
                                if(Citizen[i]!=null){
                                    if(Citizen[i].getuniqueID()==id){
                                        if(Citizen[i].getvaccination_status()!=null){
                                            if(Citizen[i].getvaccination_status().equals("FULLY VACCINATED")){
                                                System.out.println("Citizen completely vaccinated");
                                                flag = false;
                                                flag1 = false;
                                            }
                                        }
                                    }
                                }

                            }
                            if(flag){
                                System.out.print("Choose Slot: ");
                                int slot_no = sc.nextInt();
                                boolean flags = true;
                                for(int i = 0;i<slot.length;i++){
                                    if(slot[i]!=null){
                                        if(slot[i].getVaccine_day_number()-1==slot_no){
                                            if(slot[i].getquantity()!=0){
                                                slot[i].quantity -= 1;
                                                vacc = slot[i].getvaccine();
                                                day_no = slot[i].getVaccine_day_number();
                                                slot[i].setDay_number(day_no);
                                            }
                                            else{
                                                flags = false;
                                            }
                                        }
                                    }
                                }
                                if(flags){
                                    for(int i = 0;i<Citizen.length;i++){
                                        if(Citizen[i]!=null){
                                            Citizen[i].vaccine = vacc;
                                            Citizen[i].setGivenDoses();
                                            if(Citizen[i].getuniqueID()==id){
                                                if(Citizen[i].getGivenDoses()!=num){
                                                    Citizen[i].vaccination_status = "PARTIALLY VACCINATED";
                                                    System.out.println(Citizen[i].getname()+ " vaccinated with "+Citizen[i].getvaccine());
                                                }
                                                else{
                                                    Citizen[i].vaccination_status = "FULLY VACCINATED";
                                                    System.out.println(Citizen[i].getname()+ " vaccinated with "+Citizen[i].getvaccine());
                                                }
                                                Citizen[i].setDay_number(day_no);
                                            }
                                        }
                                    }
                                }
                                else{
                                    System.out.println("No slots available");
                                }

                            }
                            else if (!flag){
                                if(flag1){
                                    System.out.println("No slots available");
                                }
                            }


                        }
                    }
                    if(a==2){
                        if(vacc1==null){
                            System.out.print("Enter Vaccine name: ");
                            String b = sc.next();
                            for(int i = 0;i<h.length;i++){
                                if(h[i]!=null){
                                    if(h[i].getVaccine(b)){
                                        System.out.println(h[i].getuniqueID()+" "+h[i].getHosp_name());
                                    }
                                }
                            }
                            System.out.print("Enter hospital id: ");
                            int c = sc.nextInt();
                            for(int i = 0;i<slot.length;i++){
                                if(slot[i]!=null){
                                    if(slot[i].getHospitalID()==c){
                                        int r = slot[i].getVaccine_day_number();
                                        if(slot[i].getDay_number()<r){
                                            if(slot[i].getquantity()!=0){
                                                if(slot[i].getvaccine().equals(b)){
                                                    System.out.println(r-1+"->"+"Day: "+r+" Available Qty:"+slot[i].getquantity()+ " Vaccine:"+slot[i].getvaccine());
                                                    flag = true;
                                                }
                                            }

                                        }
                                    }
//                            else if(i== slot.length-1 && slot[i].getHospitalID()!=c){
//                                flag = false;
//                            }
                                }

                            }
                            boolean flag1 = true;
                            for(int i = 0;i<Citizen.length;i++){
                                if(Citizen[i]!=null){
                                    if(Citizen[i].getuniqueID()==id){
                                        if(Citizen[i].getvaccination_status()!=null){
                                            if(Citizen[i].getvaccination_status().equals("FULLY VACCINATED")){
                                                System.out.println("Citizen completely vaccinated");
                                                flag = false;
                                                flag1 = false;
                                            }
                                        }
                                    }
                                }

                            }
                            String vacc = null;
                            boolean flags = true;
                            if(flag){
                                int day_no = 0;
                                System.out.print("Choose Slot: ");
                                int slot_no = sc.nextInt();
                                for(int i = 0;i<slot.length;i++){
                                    if(slot[i]!=null){
                                        if(slot[i].getVaccine_day_number()-1==slot_no){
                                            if(slot[i].getquantity()!=0){
                                                slot[i].quantity -= 1;
                                                vacc = slot[i].getvaccine();
                                                day_no = slot[i].getVaccine_day_number();
                                                slot[i].setDay_number(day_no);
                                            }
                                            else{
                                                flags = false;
                                            }
                                        }
                                    }
                                }
                                int num = 0;
                                for(int i = 0;i<v.length;i++){
                                    if(v[i]!=null){
                                        if(v[i].getname().equals(vacc)){
                                            num = v[i].getnum();
                                            System.out.println(num);
                                        }
                                    }
                                }
                                if(flags){
                                    for(int i = 0;i<Citizen.length;i++){
                                        if(Citizen[i]!=null){
                                            if(Citizen[i].getuniqueID()==id){
                                                Citizen[i].vaccine = b;
                                                Citizen[i].setGivenDoses();
                                                if(Citizen[i].getGivenDoses()!=num){
                                                    Citizen[i].vaccination_status = "PARTIALLY VACCINATED";
                                                    System.out.println(Citizen[i].getname()+ " vaccinated with "+Citizen[i].getvaccine());
                                                }
                                                else{
                                                    Citizen[i].vaccination_status = "FULLY VACCINATED";
                                                    System.out.println(Citizen[i].getname()+ " vaccinated with "+Citizen[i].getvaccine());
                                                }
                                                Citizen[i].setDay_number(day_no);
                                            }
                                        }

                                    }
                                }
                                else{
                                    System.out.println("No slots available");
                                }
                            }
                            else if(!flag){
                                if(flag1){
                                    System.out.println("No slots available");
                                }
                            }
                        }
                        else {
                            System.out.print("Enter Vaccine name: ");
                            String b = sc.next();
                            if(vacc1.equals(b)){
                                for(int i = 0;i<h.length;i++){
                                    if(h[i]!=null){
                                        if(h[i].getVaccine(b)){
                                            System.out.println(h[i].getuniqueID()+" "+h[i].getHosp_name());
                                        }
                                    }
                                }
                                System.out.print("Enter hospital id: ");
                                int c = sc.nextInt();
                                int gap = 0;
                                int num = 0;
                                for(int i = 0;i<v.length;i++){
                                    if(v[i]!=null){
                                        if(vacc1!=null){
                                            if(v[i].getname()==vacc1){
                                                gap = v[i].getgap();
                                                num = v[i].getnum();
                                            }
                                        }
                                    }
                                }
                                for(int i = 0;i<slot.length;i++){
                                    if(slot[i]!=null){
                                        if(slot[i].getHospitalID()==c){
                                            int r = slot[i].getVaccine_day_number();
                                            if(slot[i].getDay_number()+gap<r){
                                                if(slot[i].getquantity()!=0){
                                                    if(slot[i].getvaccine().equals(b)){
                                                        System.out.println(r-1+"->"+"Day: "+r+" Available Qty:"+slot[i].getquantity()+ " Vaccine:"+slot[i].getvaccine());
                                                        flag = true;
                                                    }
                                                }

                                            }
                                        }
//                            else if(i== slot.length-1 && slot[i].getHospitalID()!=c){
//                                flag = false;
//                            }
                                    }

                                }
                                boolean flag1 = true;
                                for(int i = 0;i<Citizen.length;i++){
                                    if(Citizen[i]!=null){
                                        if(Citizen[i].getuniqueID()==id){
                                            if(Citizen[i].getvaccination_status()!=null){
                                                if(Citizen[i].getvaccination_status().equals("FULLY VACCINATED")){
                                                    System.out.println("Citizen completely vaccinated");
                                                    flag = false;
                                                    flag1 = false;
                                                }
                                            }
                                        }
                                    }

                                }
                                if(flag){
                                    int day_no = 0;
                                    System.out.print("Choose Slot: ");
                                    int slot_no = sc.nextInt();
                                    boolean flags = true;
                                    for(int i = 0;i<slot.length;i++){
                                        if(slot[i]!=null){
                                            if(slot[i].getVaccine_day_number()-1==slot_no){
                                                if(slot[i].getquantity()!=0){
                                                    slot[i].quantity -= 1;
                                                    day_no = slot[i].getVaccine_day_number();
                                                    slot[i].setDay_number(day_no);
                                                }
                                                else{
                                                    flags = false;
                                                }
                                            }
                                        }
                                    }
                                    if(flags){
                                        for(int i = 0;i<Citizen.length;i++){
                                            if(Citizen[i]!=null){
                                                if(Citizen[i].getuniqueID()==id){
                                                    Citizen[i].vaccine = b;
                                                    Citizen[i].setGivenDoses();
                                                    if(Citizen[i].getGivenDoses()!=num){
                                                        Citizen[i].vaccination_status = "PARTIALLY VACCINATED";
                                                        System.out.println(Citizen[i].getname()+ " vaccinated with "+Citizen[i].getvaccine());
                                                    }
                                                    else{
                                                        Citizen[i].vaccination_status = "FULLY VACCINATED";
                                                        System.out.println(Citizen[i].getname()+ " vaccinated with "+Citizen[i].getvaccine());
                                                    }
                                                    Citizen[i].setDay_number(day_no);
                                                }
                                            }

                                        }
                                    }
                                    else{
                                        System.out.println("No slots available");
                                    }
                                }
                                else if(!flag){
                                    if(flag1){
                                        System.out.println("No slots available");
                                    }
                                }
                            }
                            else{
                                System.out.println("Cannot choose this Vaccine");
                            }
                        }
                        }
                    if(a==3){
                    }
                }
                else{
                    System.out.println("Citizen NOT REGISTERED");
                }

            }
            if(x==6){
                System.out.print("Enter Hospital Id: ");
                int a = sc.nextInt();
                for(int i = 0;i< slot.length;i++){
                    if(slot[i] != null){
                        if(slot[i].getHospitalID()==a){
                            System.out.println("Day: "+slot[i].getVaccine_day_number()+" Vaccine: "+slot[i].getvaccine()+ " Available Qty: "+slot[i].getquantity());
                        }
                    }
                }
            }
            if(x==7){
                System.out.print("Enter Patient ID: ");
                long a = sc.nextLong();
                boolean flag = true;
                for(int i = 0;i<Citizen.length;i++){
                    if(Citizen[i]!=null){
                        if(Citizen[i].getuniqueID()==a){
                            int gap = 0;
                            flag = false;
                            if(Citizen[i].getvaccination_status()==null){
                                System.out.println("Citizen REGISTERED");
                            }
                            else if(Citizen[i].getvaccination_status().equals("FULLY VACCINATED")){
                                System.out.println(Citizen[i].getvaccination_status());
                                System.out.println(Citizen[i].getvaccine());
                                System.out.println("Number of Doses given: "+Citizen[i].getGivenDoses());
                            }
                            else if(Citizen[i].getvaccination_status().equals("PARTIALLY VACCINATED")){
                                System.out.println(Citizen[i].getvaccination_status());
                                System.out.println(Citizen[i].getvaccine());
                                System.out.println("Number of Doses given: "+Citizen[i].getGivenDoses());
                                for(int j = 0;j<v.length;j++){
                                    if(v[j]!=null){
                                        if(v[j].getname().equals(Citizen[i].getvaccine())){
                                            gap = v[j].getgap();
                                        }
                                    }
                                }
                                int day = Citizen[i].getDay_number();
                                int res = day+gap;
                                System.out.println("Next Dose due date: "+res);
                            }
                        }

                    }
                }
                if(flag){
                    System.out.println("Citizen NOT REGISTERED");
                }
            }
	        if(x==8){
	            break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("---------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("---------------------------------");
    }
}
