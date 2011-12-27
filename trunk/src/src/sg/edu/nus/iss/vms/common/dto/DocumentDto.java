/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import sg.edu.nus.iss.vms.project.dto.ProjectProposalDocumentDto;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_document")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DocumentDto.findAll", query = "SELECT t FROM DocumentDto t"),
        @NamedQuery(name = "DocumentDto.findByDocId", query = "SELECT t FROM DocumentDto t WHERE t.docId = :docId"),
        @NamedQuery(name = "DocumentDto.findByFleNme", query = "SELECT t FROM DocumentDto t WHERE t.fleNme = :fleNme")})
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
        @Column(name = "DESC")
        private String description;
        @Basic(optional = false)
        @Column(name = "DEL_IND")
        private boolean delInd;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId")
        private List<ProjectProposalDocumentDto> tbProjectProposalDocumentList;

        public DocumentDto() {
        }

        public DocumentDto(Long docId) {
                this.docId = docId;
        }

        public DocumentDto(Long docId, String fleNme, byte[] fle, boolean delInd) {
                this.docId = docId;
                this.fleNme = fleNme;
                this.fle = fle;
                this.delInd = delInd;
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
                return description;
        }

        public void setDesc(String desc) {
                this.description = desc;
        }

        public boolean getDelInd() {
                return delInd;
        }

        public void setDelInd(boolean delInd) {
                this.delInd = delInd;
        }

        @XmlTransient
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
