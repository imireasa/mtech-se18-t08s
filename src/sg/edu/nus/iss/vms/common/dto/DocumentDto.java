/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import sg.edu.nus.iss.vms.project.dto.ProjectProposalDocumentDto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_document")
@NamedQueries({
        @NamedQuery(name = "DocumentDto.findAll", query = "SELECT t FROM DocumentDto t")})
public class DocumentDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "DOC_ID")
        private Long docId;
        @Basic(optional = false)
        @Column(name = "FLE_NME")
        private String fleNme;
        @Basic(optional = false)
        @Lob
        @Column(name = "FLE")
        private byte[] fle;
        @Column(name = "DOC_DESC")
        private String desc;
        @Basic(optional = false)
        @Column(name = "DEL_IND")
        private boolean delInd;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId", fetch = FetchType.LAZY)
        private List<ProjectProposalDocumentDto> tbProjectProposalDocumentList;

        public DocumentDto() {
        }

        public DocumentDto(Long docId) {
                this.docId = docId;
        }

        public DocumentDto(Long docId, String fleNme, byte[] fle, boolean delInd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.docId = docId;
                this.fleNme = fleNme;
                this.fle = fle;
                this.delInd = delInd;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getDocId() {
                return docId;
        }

        public void setDocId(Long docId) {
                this.docId = docId;
        }

        public String getFleNme() {
                return fleNme;
        }

        public void setFleNme(String fleNme) {
                this.fleNme = fleNme;
        }

        public byte[] getFle() {
                return fle;
        }

        public void setFle(byte[] fle) {
                this.fle = fle;
        }

        public String getDesc() {
                return desc;
        }

        public void setDesc(String desc) {
                this.desc = desc;
        }

        public boolean getDelInd() {
                return delInd;
        }

        public void setDelInd(boolean delInd) {
                this.delInd = delInd;
        }

        public List<ProjectProposalDocumentDto> getTbProjectProposalDocumentList() {
                return tbProjectProposalDocumentList;
        }

        public void setTbProjectProposalDocumentList(List<ProjectProposalDocumentDto> tbProjectProposalDocumentList) {
                this.tbProjectProposalDocumentList = tbProjectProposalDocumentList;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (docId != null ? docId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof DocumentDto)) {
                        return false;
                }
                DocumentDto other = (DocumentDto) object;
                if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.DocumentDto[ docId=" + docId + " ]";
        }
}
