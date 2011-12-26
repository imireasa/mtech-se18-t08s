package sg.edu.nus.iss.vms.security.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_user")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserDto.findAll", query = "SELECT t FROM UserDto t"),
        @NamedQuery(name = "UserDto.findByUsrId", query = "SELECT t FROM UserDto t WHERE t.usrId = :usrId")})
public class UserDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @Basic(optional = false)
        @GeneratedValue
        @Column(name = "USR_ID")
        private Long usrId;
        @Basic(optional = false)
        @Column(name = "USR_LOGIN_ID")
        private String usrLoginId;
        @Basic(optional = false)
        @Column(name = "TP_CD")
        private long tpCd;
        @Basic(optional = false)
        @Column(name = "TITLE_CD")
        private long titleCd;
        @Basic(optional = false)
        @Column(name = "NME")
        private String nme;
        @Basic(optional = false)
        @Column(name = "EMAIL")
        private String email;
        @Basic(optional = false)
        @Column(name = "PWD")
        private String pwd;
        @Column(name = "MOBILE")
        private String mobile;
        @Column(name = "ADDR")
        private String addr;
        @Column(name = "POST_CD")
        private Integer postCd;
        @Column(name = "CTRY_CD")
        private Long ctryCd;
        @Basic(optional = false)
        @Column(name = "ACT_IND")
        private boolean actInd;
        @Basic(optional = false)
        @Column(name = "JOIN_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private Date joinDte;
        @Basic(optional = false)
        @Column(name = "CREATED_BY")
        private String createdBy;
        @Basic(optional = false)
        @Column(name = "CREATED_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdDte;
        @Basic(optional = false)
        @Column(name = "UPD_BY")
        private String updBy;
        @Basic(optional = false)
        @Column(name = "UPD_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private Date updDte;
        @Basic(optional = false)
        @Column(name = "VERSION")
        private int version;

        public UserDto() {
        }

        public UserDto(Long usrId) {
                this.usrId = usrId;
        }

        public UserDto(Long usrId, String usrLoginId, long tpCd, long titleCd, String nme, String email, String pwd, boolean actInd, Date joinDte, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.usrId = usrId;
                this.usrLoginId = usrLoginId;
                this.tpCd = tpCd;
                this.titleCd = titleCd;
                this.nme = nme;
                this.email = email;
                this.pwd = pwd;
                this.actInd = actInd;
                this.joinDte = joinDte;
                this.createdBy = createdBy;
                this.createdDte = createdDte;
                this.updBy = updBy;
                this.updDte = updDte;
                this.version = version;
        }

        public Long getUsrId() {
                return usrId;
        }

        public void setUsrId(Long usrId) {
                this.usrId = usrId;
        }

        public String getUsrLoginId() {
                return usrLoginId;
        }

        public void setUsrLoginId(String usrLoginId) {
                this.usrLoginId = usrLoginId;
        }

        public long getTpCd() {
                return tpCd;
        }

        public void setTpCd(long tpCd) {
                this.tpCd = tpCd;
        }

        public long getTitleCd() {
                return titleCd;
        }

        public void setTitleCd(long titleCd) {
                this.titleCd = titleCd;
        }

        public String getNme() {
                return nme;
        }

        public void setNme(String nme) {
                this.nme = nme;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPwd() {
                return pwd;
        }

        public void setPwd(String pwd) {
                this.pwd = pwd;
        }

        public String getMobile() {
                return mobile;
        }

        public void setMobile(String mobile) {
                this.mobile = mobile;
        }

        public String getAddr() {
                return addr;
        }

        public void setAddr(String addr) {
                this.addr = addr;
        }

        public Integer getPostCd() {
                return postCd;
        }

        public void setPostCd(Integer postCd) {
                this.postCd = postCd;
        }

        public Long getCtryCd() {
                return ctryCd;
        }

        public void setCtryCd(Long ctryCd) {
                this.ctryCd = ctryCd;
        }

        public boolean getActInd() {
                return actInd;
        }

        public void setActInd(boolean actInd) {
                this.actInd = actInd;
        }

        public Date getJoinDte() {
                return joinDte;
        }

        public void setJoinDte(Date joinDte) {
                this.joinDte = joinDte;
        }

        public String getCreatedBy() {
                return createdBy;
        }

        public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
        }

        public Date getCreatedDte() {
                return createdDte;
        }

        public void setCreatedDte(Date createdDte) {
                this.createdDte = createdDte;
        }

        public String getUpdBy() {
                return updBy;
        }

        public void setUpdBy(String updBy) {
                this.updBy = updBy;
        }

        public Date getUpdDte() {
                return updDte;
        }

        public void setUpdDte(Date updDte) {
                this.updDte = updDte;
        }

        public int getVersion() {
                return version;
        }

        public void setVersion(int version) {
                this.version = version;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (usrId != null ? usrId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof UserDto)) {
                        return false;
                }
                UserDto other = (UserDto) object;
                if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.UserDto[ usrId=" + usrId + " ]";
        }
}