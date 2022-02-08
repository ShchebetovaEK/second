package by.tms.project.model.entity;

import java.util.Date;
import java.util.List;

public class Protocol extends Entity{
    private long protocolId;
    private Date protocolData;
    private Payer protocolPayer;
    private Long protocolCost;
    private Long doctorsUsersId;
    private Long patientsUsersId;
    private Application application;
    private Status status;
    private List<Capability> capabilityList;

    public Protocol() {
    }

    public Protocol(Date protocolData, Payer protocolPayer, Long doctorsUsersId, Long patientsUsersId) {
        this.protocolData = protocolData;
        this.protocolPayer = protocolPayer;
        this.doctorsUsersId = doctorsUsersId;
        this.patientsUsersId = patientsUsersId;
    }

    public Protocol(Date protocolData, Payer protocolPayer,
                    Long protocolCost, Long doctorsUsersId, Long patientsUsersId, Application application) {
        this.protocolData = protocolData;
        this.protocolPayer = protocolPayer;
        this.protocolCost = protocolCost;
        this.doctorsUsersId = doctorsUsersId;
        this.patientsUsersId = patientsUsersId;
        this.application = application;
    }

    public Protocol(Date protocolData, Payer protocolPayer, Long protocolCost, Long doctorId, Long patientId) {
        this.protocolData = protocolData;
        this.protocolPayer = protocolPayer;
        this.protocolCost = protocolCost;
        this.doctorsUsersId = doctorId;
        this.patientsUsersId = patientId;
    }

    public Protocol(Date protocolData, Payer protocolPayer, Long protocolCost, Long doctorsUsersId, Long patientsUsersId, Status status) {
        this.protocolData = protocolData;
        this.protocolPayer = protocolPayer;
        this.protocolCost = protocolCost;
        this.doctorsUsersId = doctorsUsersId;
        this.patientsUsersId = patientsUsersId;
        this.status = status;
    }

    public Protocol(long protocolId, Date protocolData, Payer protocolPayer, Long protocolCost,
                    Long doctorsUsersId, Long patientsUsersId, Application application, Status status) {
        this.protocolId = protocolId;
        this.protocolData = protocolData;
        this.protocolPayer = protocolPayer;
        this.protocolCost = protocolCost;
        this.doctorsUsersId = doctorsUsersId;
        this.patientsUsersId = patientsUsersId;
        this.application = application;
        this.status = status;
    }

    public long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(long protocolId) {
        this.protocolId = protocolId;
    }

    public Date getProtocolData() {
        return protocolData;
    }

    public void setProtocolData(Date protocolData) {
        this.protocolData = protocolData;
    }

    public Payer getProtocolPayer() {
        return protocolPayer;
    }

    public void setProtocolPayer(Payer protocolPayer) {
        this.protocolPayer = protocolPayer;
    }

    public Long getProtocolCost() {
        return protocolCost;
    }

    public void setProtocolCost(Long protocolCost) {
        this.protocolCost = protocolCost;
    }

    public Long getDoctorsUsersId() {
        return doctorsUsersId;
    }

    public void setDoctorsUsersId(Long doctorsUsersId) {
        this.doctorsUsersId = doctorsUsersId;
    }

    public Long getPatientsUsersId() {
        return patientsUsersId;
    }

    public void setPatientsUsersId(Long patientsUsersId) {
        this.patientsUsersId = patientsUsersId;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        if (!doctorsUsersId.equals(protocol.doctorsUsersId)) return false;
        if (!patientsUsersId.equals(protocol.patientsUsersId)) return false;
        if (application != protocol.application) return false;
        if (status != protocol.status) return false;
        return capabilityList.equals(protocol.capabilityList);
    }

    @Override
    public int hashCode() {
        int result = (int) (protocolId ^ (protocolId >>> 32));
        result = 31 * result + protocolData.hashCode();
        result = 31 * result + protocolPayer.hashCode();
        result = 31 * result + protocolCost.hashCode();
        result = 31 * result + doctorsUsersId.hashCode();
        result = 31 * result + patientsUsersId.hashCode();
        result = 31 * result + application.hashCode();
        result = 31 * result + status.hashCode();
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
        sb.append(", doctorsUsersId=").append(doctorsUsersId);
        sb.append(", patientsUsersId=").append(patientsUsersId);
        sb.append(", application=").append(application);
        sb.append(", status=").append(status);
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

        public ProtocolBuilder setProtocolData(Date protocolData) {
            protocol.setProtocolData(protocolData);
            return this;
        }

        public ProtocolBuilder setProtocolPayer(Payer protocolPayer) {
            protocol.setProtocolPayer(protocolPayer);
            return this;
        }

        public ProtocolBuilder setProtocolCost(Long protocolCost) {
            protocol.setProtocolCost(protocolCost);
            return this;
        }
        public ProtocolBuilder setDoctorId(Long doctorsUsersId) {
            protocol.setDoctorsUsersId(doctorsUsersId);
            return this;
        }
        public ProtocolBuilder setPatientId(Long patientsUsersId) {
            protocol.setPatientsUsersId(patientsUsersId);
            return this;
        }

        public ProtocolBuilder setApplication(Application application){
           protocol.setApplication(application);
           return this;
        }

        public ProtocolBuilder setStatus(Status status){
           protocol.setStatus(status);
           return this;
        }

        public Protocol buildProtocol() {
            return protocol;
        }
    }
}
