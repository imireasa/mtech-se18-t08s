package sg.edu.nus.iss.vms.project.vo;

public class ProjectProposalDocumentVo {
	private byte[] content;
	private String fileName;

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ProjectProposalDocumentVo(byte[] content, String fileName) {
		super();
		this.content = content;
		this.fileName = fileName;
	}

}
