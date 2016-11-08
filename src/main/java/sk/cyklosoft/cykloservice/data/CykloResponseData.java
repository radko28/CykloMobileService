package sk.cyklosoft.cykloservice.data;

import sk.cyklosoft.cykloservice.vo.CykloVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CykloResponseData {

	private CykloVO cyklo;

	public CykloVO getCyklo() {
		return cyklo;
	}

	public void setCyklo(CykloVO cyklo) {
		this.cyklo = cyklo;
	}
	
}
