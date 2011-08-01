package sg.edu.nus.iss.vms.common.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author zaw.htet
 *
 */
public class BasicMailMessage extends SimpleMailMessage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1385857811292272484L;
	
	protected String textTemplate;
	protected Map textModel;
	
	protected Map attachments = new LinkedHashMap();
	
	public BasicMailMessage() {
		super();
	}

	public BasicMailMessage(SimpleMailMessage original) {
		super(original);
	}

	/**
	 * @return the textTemplate
	 */
	public String getTextTemplate() {
		return textTemplate;
	}

    
	/**
	 * @param textTemplate the textTemplate to set
	 */
	public void setTextTemplate(String textTemplate) {
		this.textTemplate = textTemplate;
	}

	/**
	 * @return the textModel
	 */
	public Map getTextModel() {
		return textModel;
	}

	/**
	 * @param textModel the textModel to set
	 */
	public void setTextModel(Map textModel) {
		this.textModel = textModel;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.mail.SimpleMailMessage#getText()
	 */
	@Override
	public String getText() {
		if (StringUtils.isNotBlank(textTemplate) && textModel != null && StringUtils.isBlank( super.getText() )) {
			setText( StrSubstitutor.replace(textTemplate, textModel) );
		}
		
		if (null != super.getText()) {
			return super.getText();
		}
		
		// force send empty text message
		return "";
	}

	public boolean addFileAttachment(String fileAttachment)
	{
		File test = new File(fileAttachment);
		boolean exist = test.exists();
		
		// add fileAttachment as key, and check is exist and save it as value of map
		if (exist) {
			attachments.put(fileAttachment, Boolean.valueOf(exist));
		}
		return exist;
	}

	public boolean setFileAttachment(String fileAttachment)
	{
		File test = new File(fileAttachment);
		boolean exist = test.exists();
		
		// add fileAttachment as key, and check is exist and save it as value of map
		if (exist) {
			attachments.clear();
			attachments.put(fileAttachment, Boolean.valueOf(exist));
		}
		return exist;
	}

	public Object removeFileAttachment(String fileAttachment)
	{
		return attachments.remove(fileAttachment);
	}
	
	public List getFileAttachments()
	{
		return new ArrayList(attachments.keySet());
	}
	
	/*
	public List getValidFileAttachments()
	{
		List list = new ArrayList();
		for (Iterator iter = attachments.keySet().iterator(); iter.hasNext(); ) {
			String fileAttachment = (String) iter.next();
			if (Boolean.TRUE.equals( attachments.get(fileAttachment)) ) {
				list.add( fileAttachment );
			}
		}
		
		return list;
	}
	*/
}
