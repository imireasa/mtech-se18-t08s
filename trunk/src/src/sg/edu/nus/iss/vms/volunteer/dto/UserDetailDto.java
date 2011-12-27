/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.volunteer.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import sg.edu.nus.iss.vms.security.dto.UserDto;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_user_detail")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserDetailDto.findAll", query = "SELECT t FROM UserDetailDto t"),
        @NamedQuery(name = "UserDetailDto.findByUsrDtlId", query = "SELECT t FROM UserDetailDto t WHERE t.usrDtlId = :usrDtlId"),
        @NamedQuery(name = "UserDetailDto.findByIntrst", query = "SELECT t FROM UserDetailDto t WHERE t.intrst = :intrst"),
        @NamedQuery(name = "UserDetailDto.findBySkillSet", query = "SELECT t FROM UserDetailDto t WHERE t.skillSet = :skillSet"),
        @NamedQuery(name = "UserDetailDto.findByQualAtt", query = "SELECT t FROM UserDetailDto t WHERE t.qualAtt = :qualAtt"),
        @NamedQuery(name = "UserDetailDto.findByJobTitleCd", query = "SELECT t FROM UserDetailDto t WHERE t.jobTitleCd = :jobTitleCd"),
        @NamedQuery(name = "UserDetailDto.findBySalary", query = "SELECT t FROM UserDetailDto t WHERE t.salary = :salary")})
public class UserDetailDto implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "USR_DTL_ID")
        private Long usrDtlId;
        @Column(name = "INTRST")
        private String intrst;
        @Column(name = "SKILL_SET")
        private String skillSet;
        @Column(name = "QUAL_ATT")
        private String qualAtt;
        @Column(name = "JOB_TITLE_CD")
        private BigInteger jobTitleCd;
        // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
        @Column(name = "SALARY")
        private BigDecimal salary;
        @JoinColumn(name = "USR_ID", referencedColumnName = "USR_ID")
        @OneToOne(optional = false)
        private UserDto usrId;

        public UserDetailDto() {
        }

        public UserDetailDto(Long usrDtlId) {
                this.usrDtlId = usrDtlId;
        }

        public Long getUsrDtlId() {
                return usrDtlId;
        }

        public void setUsrDtlId(Long usrDtlId) {
                this.usrDtlId = usrDtlId;
        }

        public String getIntrst() {
                return intrst;
        }

        public void setIntrst(String intrst) {
                this.intrst = intrst;
        }

        public String getSkillSet() {
                return skillSet;
        }

        public void setSkillSet(String skillSet) {
                this.skillSet = skillSet;
        }

        public String getQualAtt() {
                return qualAtt;
        }

        public void setQualAtt(String qualAtt) {
                this.qualAtt = qualAtt;
        }

        public BigInteger getJobTitleCd() {
                return jobTitleCd;
        }

        public void setJobTitleCd(BigInteger jobTitleCd) {
                this.jobTitleCd = jobTitleCd;
        }

        public BigDecimal getSalary() {
                return salary;
        }

        public void setSalary(BigDecimal salary) {
                this.salary = salary;
        }

        public UserDto getUsrId() {
                return usrId;
        }

        public void setUsrId(UserDto usrId) {
                this.usrId = usrId;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (usrDtlId != null ? usrDtlId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof UserDetailDto)) {
                        return false;
                }
                UserDetailDto other = (UserDetailDto) object;
                if ((this.usrDtlId == null && other.usrDtlId != null) || (this.usrDtlId != null && !this.usrDtlId.equals(other.usrDtlId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.volunteer.dto.UserDetailDto[ usrDtlId=" + usrDtlId + " ]";
        }
        
}
