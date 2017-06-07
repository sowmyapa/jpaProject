package relationships.entity;


import javax.persistence.*;
import java.util.Date;

/*
 * Survey Entity - maps to PRODUCT_SURVEY table
 */
@Entity(name = "PRODUCT_SURVEY")
public class Survey {
	@Id
	@Column(name = "SURVEY_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long surveyId;
	
	@Column(name = "PROD_ID", nullable = false)
	private long prodId;
	
	@Column(name = "SURVEY_RESULT", nullable = false,length = 4000)
	private String surveyResult;
	
	@Column(name = "YEAR_OF_SURVEY")
	private int year;
	
	@Column(name = "LAST_UPDATED_TIME")
	private Date updatedTime;
	

	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String toString() {
       StringBuffer sb = new StringBuffer();
       sb.append("prodId : " + prodId);
       sb.append("   surveyId : " + surveyId);
       sb.append("   surveyResult : " + surveyResult);
       sb.append("   year : " + year);
       return sb.toString();
    }
	
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}
	public String getSurveyResult() {
		return surveyResult;
	}
	public void setSurveyResult(String surveyResult) {
		this.surveyResult = surveyResult;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
