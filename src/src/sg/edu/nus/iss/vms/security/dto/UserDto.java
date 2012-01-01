/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.security.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;
import sg.edu.nus.iss.vms.volunteer.dto.UserDetailDto;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_user")
@NamedQueries({
        @NamedQuery(name = "UserDto.findAll", query = "SELECT t FROM UserDto t")})
public class UserDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "USR_ID")
        private Long usrId;
        @Basic(optional = false)
        @Column(name = "USR_LOGIN_ID")
        private String usrLoginId;
        @Basic(optional = false)
        @Column(name = "TP_CD")
        private Long tpCd;
        @Basic(optional = false)
        @Column(name = "TITLE_CD")
        private Long titleCd;
        @Basic(optional = false)
        @Column(name = "NME")
        private String nme;
        @Basic(optional = false)
        @Column(name = "DOB")
        @Temporal(TemporalType.DATE)
        private Date dob;
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
        //
        @OneToOne(cascade = CascadeType.ALL, mappedBy = "usrId", fetch = FetchType.EAGER)
        private UserDetailDto tbUserDetail;

        public UserDto() {
        }

        public UserDto(Long usrId) {
                this.usrId = usrId;
        }

        public UserDto(Long usrId, String usrLoginId, Long tpCd, Long titleCd, String nme, Date dob, String email, String pwd, boolean actInd, Date joinDte, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.usrId = usrId;
                this.usrLoginId = usrLoginId;
                this.tpCd = tpCd;
                this.titleCd = titleCd;
                this.nme = nme;
                this.dob = dob;
                this.email = email;
                this.pwd = pwd;
                this.actInd = actInd;
                this.joinDte = joinDte;

                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
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

        public Long getTpCd() {
                return tpCd;
        }

        public void setTpCd(Long tpCd) {
                this.tpCd = tpCd;
        }

        public Long getTitleCd() {
                return titleCd;
        }

        public void setTitleCd(Long titleCd) {
                this.titleCd = titleCd;
        }

        public String getNme() {
                return nme;
        }

        public void setNme(String nme) {
                this.nme = nme;
        }

        public Date getDob() {
                return dob;
        }

        public void setDob(Date dob) {
                this.dob = dob;
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

        public UserDetailDto getTbUserDetail() {
                return tbUserDetail;
        }

        public void setTbUserDetail(UserDetailDto tbUserDetail) {
                this.tbUserDetail = tbUserDetail;
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
