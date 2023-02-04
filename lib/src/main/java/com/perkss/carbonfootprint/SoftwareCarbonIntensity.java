package com.perkss.carbonfootprint;

public class SoftwareCarbonIntensity {

    private double energyConsumed;
    private double locationBasedMarginalCarbonIntensity;
    private double embodiedEmissions;
    private double functionalUnit;

    private SoftwareCarbonIntensity(
            double energy,
            double locationBasedMarginalCarbonIntensity,
            double functionalUnit,
            double embodiedEmissions) {
        this.energyConsumed = energy;
        this.locationBasedMarginalCarbonIntensity = locationBasedMarginalCarbonIntensity;
        this.embodiedEmissions = embodiedEmissions;
        this.functionalUnit = functionalUnit;
    }

    public double getSCI() {
        double o = energyConsumed * locationBasedMarginalCarbonIntensity;
        double m = embodiedEmissions;

        return (o + m) * functionalUnit;
    }

    public static class SCIBuilder {
        private double energyConsumed;
        private double locationBasedMarginalCarbonIntensity;
        private double embodiedEmissions;
        private double functionalUnit;

        public SCIBuilder addEnergyConsumed(double energyConsumed) {
            this.energyConsumed = energyConsumed;
            return this;
        }

        public SCIBuilder addFunctionalUnit(double functionalUnit) {
            this.functionalUnit = functionalUnit;
            return this;
        }

        public SCIBuilder addLocationBasedMarginalCarbonIntensity(double locationBasedMarginalCarbonIntensity) {
            this.locationBasedMarginalCarbonIntensity = locationBasedMarginalCarbonIntensity;
            return this;
        }

        public SCIBuilder addEmbodiedEmissions(double embodiedEmissions) {
            this.embodiedEmissions = embodiedEmissions;
            return this;
        }

        public SoftwareCarbonIntensity build() {
            return new SoftwareCarbonIntensity(energyConsumed, locationBasedMarginalCarbonIntensity, functionalUnit,
                    embodiedEmissions);
        }
    }

}
