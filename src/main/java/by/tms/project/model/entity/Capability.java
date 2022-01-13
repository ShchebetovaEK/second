package by.tms.project.model.entity;

import java.math.BigDecimal;

public class Capability extends Entity{
    private String capabilityName;
    private BigDecimal capabilityCost;

    public Capability() {
    }

    public Capability(String capabilityName, BigDecimal capabilityCost) {
        this.capabilityName = capabilityName;
        this.capabilityCost = capabilityCost;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public BigDecimal getCapabilityCost() {
        return capabilityCost;
    }

    public void setCapabilityCost(BigDecimal capabilityCost) {
        this.capabilityCost = capabilityCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Capability that = (Capability) o;

        if (!capabilityName.equals(that.capabilityName)) return false;
        return capabilityCost.equals(that.capabilityCost);
    }

    @Override
    public int hashCode() {
        int result = capabilityName.hashCode();
        result = 31 * result + capabilityCost.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Capability{");
        sb.append("capabilityName='").append(capabilityName).append('\'');
        sb.append(", capabilityCost=").append(capabilityCost);
        sb.append('}');
        return sb.toString();
    }

    public static class CapabilityBuilder{
        private Capability capability = new Capability();

        public CapabilityBuilder(){}

        public CapabilityBuilder setCapabilityName(String capabilityName){
            capability.setCapabilityName(capabilityName);
            return this;
        }
        public CapabilityBuilder setCapabilityCost(BigDecimal capabilityCost){
            capability.setCapabilityCost(capabilityCost);
            return this;
        }

        public Capability buildCapability(){
            return capability;
        }
    }
}
