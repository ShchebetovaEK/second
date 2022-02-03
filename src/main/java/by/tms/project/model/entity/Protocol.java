package by.tms.project.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Protocol extends Entity{
    private long protocolId;
    private LocalDate protocolData;
    private Payer protocolPayer;
    private BigDecimal protocolCost;
    private Long doctorId;
    private Long patientId;
    private List<Capability> capabilityList;

    public Protocol() {
    }

    public Protocol(long protocolId, LocalDate protocolData, Payer protocolPayer, BigDecimal protocolCost) {
        this.protocolId = protocolId;
        this.protocolData = protocolData;
        this.protocolPayer = protocolPayer;
        this.protocolCost = protocolCost;
    }

    public Protocol(long protocolId, LocalDate protocolData, Payer protocolPayer,
                    BigDecimal protocolCost, Long doctorId, Long patientId) {
        this.protocolId = protocolId;
        this.protocolData = protocolData;
        this.protocolPayer = protocolPayer;
        this.protocolCost = protocolCost;
        this.doctorId = doctorId;
        this.patientId = patientId;
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

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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
        if (!doctorId.equals(protocol.doctorId)) return false;
        if (!patientId.equals(protocol.patientId)) return false;
        return capabilityList.equals(protocol.capabilityList);
    }

    @Override
    public int hashCode() {
        int result = (int) (protocolId ^ (protocolId >>> 32));
        result = 31 * result + protocolData.hashCode();
        result = 31 * result + protocolPayer.hashCode();
        result = 31 * result + protocolCost.hashCode();
        result = 31 * result + doctorId.hashCode();
        result = 31 * result + patientId.hashCode();
        result = 31 * result + capabilityList.hashCode();
        return result;
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
        public ProtocolBuilder setDoctorId(Long doctorId) {
            protocol.setDoctorId(doctorId);
            return this;
        }
        public ProtocolBuilder setPatientId(Long patientId) {
            protocol.setPatientId(patientId);
            return this;
        }

        public Protocol buildProtocol() {
            return protocol;
        }
    }
}
