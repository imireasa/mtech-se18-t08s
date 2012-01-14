/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import javax.persistence.*;
import sg.edu.nus.iss.vms.common.dto.DocumentDto;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_project_proposal_document")
@NamedQueries({
        @NamedQuery(name = "ProjectProposalDocumentDto.findAll", query = "SELECT t FROM ProjectProposalDocumentDto t")})
public class ProjectProposalDocumentDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "PROP_DOC_ID")
        private Long propDocId;
        @JoinColumn(name = "PRJ_PROP_ID", referencedColumnName = "PRJ_PROP_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private ProjectProposalDto prjPropId;
        @JoinColumn(name = "DOC_ID", referencedColumnName = "DOC_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private DocumentDto docId;

        public ProjectProposalDocumentDto() {
        }

        public ProjectProposalDocumentDto(Long propDocId) {
                this.propDocId = propDocId;
        }

        public Long getPropDocId() {
                return propDocId;
        }

        public void setPropDocId(Long propDocId) {
                this.propDocId = propDocId;
        }

        public ProjectProposalDto getPrjPropId() {
                return prjPropId;
        }

        public void setPrjPropId(ProjectProposalDto prjPropId) {
                this.prjPropId = prjPropId;
        }

        public DocumentDto getDocId() {
                return docId;
        }

        public void setDocId(DocumentDto docId) {
                this.docId = docId;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (propDocId != null ? propDocId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof ProjectProposalDocumentDto)) {
                        return false;
                }
                ProjectProposalDocumentDto other = (ProjectProposalDocumentDto) object;
                if ((this.propDocId == null && other.propDocId != null) || (this.propDocId != null && !this.propDocId.equals(other.propDocId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.ProjectProposalDocumentDto[ propDocId=" + propDocId + " ]";
        }
}
