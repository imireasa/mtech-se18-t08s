package sg.edu.nus.iss.vms.common.dto;

import javax.persistence.*;

@MappedSuperclass
public class BaseVersionDto {

        @Basic(optional = false)
        @Column(name = "CREATED_BY")
        private String createdBy;
        @Basic(optional = false)
        @Column(name = "CREATED_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private java.util.Date createdDte;
        @Basic(optional = false)
        @Column(name = "UPD_BY")
        private String updBy;
        @Basic(optional = false)
        @Column(name = "UPD_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private java.util.Date updDte;
        @Basic(optional = false)
        @Column(name = "VERSION")
        private int version;

        public String getCreatedBy() {
                return createdBy;
        }

        public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
        }

        public java.util.Date getCreatedDte() {
                return createdDte;
        }

        public void setCreatedDte(java.util.Date createdDte) {
                this.createdDte = createdDte;
        }

        public String getUpdBy() {
                return updBy;
        }

        public void setUpdBy(String updBy) {
                this.updBy = updBy;
        }

        public java.util.Date getUpdDte() {
                return updDte;
        }

        public void setUpdDte(java.util.Date updDte) {
                this.updDte = updDte;
        }

        public int getVersion() {
                return version;
        }

        public void setVersion(int version) {
                this.version = version;
        }
}
