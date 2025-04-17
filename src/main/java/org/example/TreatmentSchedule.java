package org.example;

import java.util.ArrayList;
import java.util.List;

public class TreatmentSchedule {
        private List<Treatment> treatments;

        public TreatmentSchedule() {
            treatments = new ArrayList<>();
        }

        public void addTreatment(Treatment treatment) {
            treatments.add(treatment);
        }

        public List<Treatment> getTreatments() {
            return treatments;
        }

        @Override
        public String toString() {
            return "TreatmentSchedule{" +
                    "treatments=" + treatments +
                    '}';
        }
    }


