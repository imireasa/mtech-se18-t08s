/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_certificate_request")
@NamedQueries({
        @NamedQuery(name = "CertificateRequestDto.findAll", query = "SELECT t FROM CertificateRequestDto t")})
public class CertificateRequestDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "CERT_REQ_ID")
        private Long certReqId;
        @Basic(optional = false)
        @Column(name = "PRJ_ID")
        private Long prjId;
        @Basic(optional = false)
        @Column(name = "REQ_TP")
        private Long reqTp;
        @Basic(optional = false)
        @Column(name = "REQ_STS")
        private Long reqSts;
        @Basic(optional = false)
        @Column(name = "REQ_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private Date reqDte;
        @Basic(optional = false)
        @Column(name = "REQ_BY")
        private String reqBy;

        public CertificateRequestDto() {
        }

        public CertificateRequestDto(Long certReqId) {
                this.certReqId = certReqId;
        }

        public CertificateRequestDto(Long certReqId, Long prjId, Long reqTp, Long reqSts, Date reqDte, String reqBy, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.certReqId = certReqId;
                this.prjId = prjId;
                this.reqTp = reqTp;
                this.reqSts = reqSts;
                this.reqDte = reqDte;
                this.reqBy = reqBy;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getCertReqId() {
                return certReqId;
        }

        public void setCertReqId(Long certReqId) {
                this.certReqId = certReqId;
        }

        public Long getPrjId() {
                return prjId;
        }

        public void setPrjId(Long prjId) {
                this.prjId = prjId;
        }

        public Long getReqTp() {
                return reqTp;
        }

        public void setReqTp(Long reqTp) {
                this.reqTp = reqTp;
        }

        public Long getReqSts() {
                return reqSts;
        }

        public void setReqSts(Long reqSts) {
                this.reqSts = reqSts;
        }

        public Date getReqDte() {
                return reqDte;
        }

        public void setReqDte(Date reqDte) {
                this.reqDte = reqDte;
        }

        public String getReqBy() {
                return reqBy;
        }

        public void setReqBy(String reqBy) {
                this.reqBy = reqBy;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (certReqId != null ? certReqId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof CertificateRequestDto)) {
                        return false;
                }
                CertificateRequestDto other = (CertificateRequestDto) object;
                if ((this.certReqId == null && other.certReqId != null) || (this.certReqId != null && !this.certReqId.equals(other.certReqId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.CertificateRequestDto[ certReqId=" + certReqId + " ]";
        }
}
