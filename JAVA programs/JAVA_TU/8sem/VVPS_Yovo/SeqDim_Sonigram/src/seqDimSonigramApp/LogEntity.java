package seqDimSonigramApp;
public class LogEntity {
	private String eventContext;
	private String component;
	private String eventName;
	private String description;

	public LogEntity(String eventContext, String component, String eventName, String description) {
		this.eventContext = eventContext;
		this.component = component;
		this.eventName = eventName;
		this.description = description;
	}

	public LogEntity(LogEntity logEntity) {
		this.eventContext = logEntity.eventContext;
		this.component = logEntity.component;
		this.eventName = logEntity.eventName;
		this.description = logEntity.description;
	}

	public LogEntity() {

	}

	public int getUserIdFromDescription() {
		if (description != null && !description.isEmpty()) {
			String splitDescr[] = description.split("'", 3);
		
			if (splitDescr.length > 1) {
				try {
				int result = Integer.parseInt(splitDescr[1]);
				return result;
			} catch (NumberFormatException e){
					return -1;
				}
			} 
		}
		return -1;
	}

	public String getEventContext() {
		return eventContext;
	}

	public String getComponent() {
		return component;
	}

	public String getEventName() {
		return eventName;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}