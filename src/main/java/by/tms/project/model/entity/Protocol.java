package by.tms.project.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Protocol extends Entity{
    private long protocolId;
    private LocalDate protocolData;
    private Payer protocolPayer;
    private BigDecimal protocolCost;
    private Doctor doctor;
    private Patient patient;
    private List<Capability> capabilityList;

    public Protocol() {
    }

    public Protocol(long protocolId, LocalDate protocolData, Payer protocolPayer, BigDecimal protocolCost) {
        this.protocolId = protocolId;
        this.protocolData = protocolData;
        this.protocolPayer = protocolPayer;
        this.protocolCost = protocolCost;
    }

    public long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(long protocolId) {
        this.protocolId = protocolId;
    }

    public LocalDate getProtocolData() {
        return protocolData;
    }

    public void setProtocolData(LocalDate protocolData) {
        this.protocolData = protocolData;
    }

    public Payer getProtocolPayer() {
        return protocolPayer;
    }

    public void setProtocolPayer(Payer protocolPayer) {
        this.protocolPayer = protocolPayer;
    }

    public BigDecimal getProtocolCost() {
        return protocolCost;
    }

    public void setProtocolCost(BigDecimal protocolCost) {
        this.protocolCost = protocolCost;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Capability> getCapabilityList() {
        return capabilityList;
    }

    public void setCapabilityList(List<Capability> capabilityList) {
        this.capabilityList = capabilityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Protocol protocol = (Protocol) o;

        if (protocolId != protocol.protocolId) return false;
        if (!protocolData.equals(protocol.protocolData)) return false;
        if (protocolPayer != protocol.protocolPayer) return false;
        if (!protocolCost.equals(protocol.protocolCost)) return false;
        if (!doctor.equals(protocol.doctor)) return false;
        if (!patient.equals(protocol.patient)) return false;
        return capabilityList.equals(protocol.capabilityList);
    }

    @Override
    public int hashCode() {
        int result = (int) (protocolId ^ (protocolId >>> 32));
        result = 31 * result + protocolData.hashCode();
        result = 31 * result + protocolPayer.hashCode();
        result = 31 * result + protocolCost.hashCode();
        result = 31 * result + doctor.hashCode();
        result = 31 * result + patient.hashCode();
        result = 31 * result + capabilityList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Protocol{");
        sb.append("protocolId=").append(protocolId);
        sb.append(", protocolData=").append(protocolData);
        sb.append(", protocolPayer=").append(protocolPayer);
        sb.append(", protocolCost=").append(protocolCost);
        sb.append(", doctor=").append(doctor);
        sb.append(", patient=").append(patient);
        sb.append(", capabilityList=").append(capabilityList);
        sb.append('}');
        return sb.toString();
    }

    public static class ProtocolBuilder {
     private Protocol protocol = new Protocol();

       public ProtocolBuilder(){}

        public ProtocolBuilder setProtocolId(Long protocolId) {
            protocol.setProtocolId(protocolId);
            return this;
        }

        public ProtocolBuilder setProtocolData(LocalDate protocolData) {
            protocol.setProtocolData(protocolData);
            return this;
        }

        public ProtocolBuilder setProtocolPayer(Payer protocolPayer) {
            protocol.setProtocolPayer(protocolPayer);
            return this;
        }

        public ProtocolBuilder setProtocolCost(BigDecimal protocolCost) {
            protocol.setProtocolCost(protocolCost);
            return this;
        }

        //todo

        public Protocol buildProtocol() {
            return protocol;
        }
    }
}
