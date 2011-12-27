/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.volunteer.vo;

import java.sql.Date;

/**
 *
 * @author zaw
 */
public class VolunteerVo {

        public String loginId;
        public String title;
        public String nme;
        public String email;
        public String pwd;
        public String cfpwd;
        public String mobile;
        public String addr;
        public String postCd;
        public String ctryCd;
        public String dob;
        public String intrst;
        public String skillSet;
        public String qualAtt;

        public String getLoginId() {
                return loginId;
        }

        public void setLoginId(String loginId) {
                this.loginId = loginId;
        }

        public String getAddr() {
                return addr;
        }

        public void setAddr(String addr) {
                this.addr = addr;
        }

        public String getCfpwd() {
                return cfpwd;
        }

        public void setCfpwd(String cfpwd) {
                this.cfpwd = cfpwd;
        }

        public String getCtryCd() {
                return ctryCd;
        }

        public void setCtryCd(String ctryCd) {
                this.ctryCd = ctryCd;
        }

        public String getDob() {
                return dob;
        }

        public void setDob(String dob) {
                this.dob = dob;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getIntrst() {
                return intrst;
        }

        public void setIntrst(String intrst) {
                this.intrst = intrst;
        }

        public String getMobile() {
                return mobile;
        }

        public void setMobile(String mobile) {
                this.mobile = mobile;
        }

        public String getNme() {
                return nme;
        }

        public void setNme(String nme) {
                this.nme = nme;
        }

        public String getPostCd() {
                return postCd;
        }

        public void setPostCd(String postCd) {
                this.postCd = postCd;
        }

        public String getPwd() {
                return pwd;
        }

        public void setPwd(String pwd) {
                this.pwd = pwd;
        }

        public String getQualAtt() {
                return qualAtt;
        }

        public void setQualAtt(String qualAtt) {
                this.qualAtt = qualAtt;
        }

        public String getSkillSet() {
                return skillSet;
        }

        public void setSkillSet(String skillSet) {
                this.skillSet = skillSet;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }
}
