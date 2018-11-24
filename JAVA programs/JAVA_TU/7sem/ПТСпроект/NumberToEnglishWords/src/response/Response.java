package response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class Response {
	private String numberWords;

	public String getNumberWords() {
		return numberWords;
	}

	public void setNumberWords(String numberWords) {
		this.numberWords = numberWords;
	}
}
