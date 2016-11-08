package sk.cyklosoft.cykloservice.data;

import sk.cyklosoft.cykloservice.vo.HrmVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HrmResponseData {
	
	private HrmVO hrm;

	public HrmVO getHrm() {
		return hrm;
	}

	public void setHrm(HrmVO hrm) {
		this.hrm = hrm;
	}

}
