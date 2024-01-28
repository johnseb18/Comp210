package assn05;

public class Main {

    public static void main(String[] args) {
        testP1();
        testP2();
        testP3();
        testP4();
    }

    public static void testP1(){
        SimpleEmergencyRoom simpleER = new SimpleEmergencyRoom();
        simpleER.addPatient("Patient1", 5);
        simpleER.addPatient("Patient2", 3);
        simpleER.addPatient("Patient3", 4);

        System.out.println(simpleER.dequeue().getValue());

    }

    public static void testP2(){

    }

    public static void testP3(){
    }


    public static void testP4() {
    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }
    
    public static double[] compareRuntimes() {
    	double[] results = new double[4];
    	
        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        double time1 = System.nanoTime();
        for (int i = 0; i < simplePQ.size(); i++) {
            simplePQ.dequeue();
        }

        double time2 = System.nanoTime();
        results[0] = time2-time1;
        results[1] = results[0] / 100000;

        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        double time1b = System.nanoTime();
        for (int i = 0; i < binHeap.size(); i++) {
            binHeap.dequeue();
        }
        double time2b = System.nanoTime();
        results[2] = time2b - time1b;
        results[3] = results[2] / 100000;

        return results;
    }

}



