package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    public Patient dequeue() {
        Patient maxPriority;
        int maxPriorityIndex = 0;
        for (int i = 1; i < patients.size(); i++) {
            if (patients.get(i).getPriority().compareTo(patients.get(maxPriorityIndex).getPriority()) > 0) {
                maxPriorityIndex = i;

            }
        }
        maxPriority = patients.remove(maxPriorityIndex);
    	return maxPriority;
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}
