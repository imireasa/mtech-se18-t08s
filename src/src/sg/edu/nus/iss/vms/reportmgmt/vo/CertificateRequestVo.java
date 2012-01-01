/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.vms.reportmgmt.vo;


public class CertificateRequestVo {
        private int projectId;
        private int reqType;
        private int reqStatus;
        private String reqBy;
        private String reqDate;

        /**
         * @return the projectId
         */
        public int getProjectId() {
                return projectId;
        }

        /**
         * @param projectId the projectId to set
         */
        public void setProjectId(int projectId) {
                this.projectId = projectId;
        }

        /**
         * @return the reqType
         */
        public int getReqType() {
                return reqType;
        }

        /**
         * @param reqType the reqType to set
         */
        public void setReqType(int reqType) {
                this.reqType = reqType;
        }

        /**
         * @return the reqStatus
         */
        public int getReqStatus() {
                return reqStatus;
        }

        /**
         * @param reqStatus the reqStatus to set
         */
        public void setReqStatus(int reqStatus) {
                this.reqStatus = reqStatus;
        }

        /**
         * @return the reqBy
         */
        public String getReqBy() {
                return reqBy;
        }

        /**
         * @param reqBy the reqBy to set
         */
        public void setReqBy(String reqBy) {
                this.reqBy = reqBy;
        }

        /**
         * @return the reqDate
         */
        public String getReqDate() {
                return reqDate;
        }

        /**
         * @param reqDate the reqDate to set
         */
        public void setReqDate(String reqDate) {
                this.reqDate = reqDate;
        }



}

