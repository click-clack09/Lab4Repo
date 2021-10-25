package application.model;

/**This class is used for Advertisements which will be accessed by the ClassifedsController and shown 
 * on the Classifieds view.
 * 
 * @author Richard Maldonado rlk538 on 10/23/21
 *
 */
public class Advertisement {
	//field as outlined in the assignment
	private String title;
	private String phone;
	private Boolean fullTime;
	private String date;
	private String contact;
	
	/**Constructor which takes String values and initializes the object fields.
	 * 
	 * @param title
	 * @param fullTime
	 * @param phone
	 * @param contact
	 * @param date
	 */
	public Advertisement(String title, String fullTime, String phone, String contact, String date)
	{
		this.title=title;
		this.phone=phone;
		if (fullTime.charAt(0)=='f' || fullTime.charAt(0)=='F')
			this.fullTime=true;
		else
			this.fullTime=false;
		this.date=date;
		this.contact=contact;
	}

	/**Getter for title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**Setter for title.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**Getter for phone.
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**Setter for phone.
	 * 
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**Getter for fullTime.
	 * 
	 * @return the fullTime
	 */
	public Boolean getFullTime() {
		return fullTime;
	}

	/**Setter for fullTime.
	 * 
	 * @param fullTime the fullTime to set
	 */
	public void setFullTime(Boolean fullTime) {
		this.fullTime = fullTime;
	}

	/**Getter for date.
	 * 
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**Setter for date.
	 * 
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**Getter for contact.
	 * 
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**Setter for contact.
	 * 
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**This method is similar to a modified toString, taking the fields of the Advertisement object,
	 * formatting them to the desired output text for the classified ad, and returning a String array
	 * of the formatted text. Note: this is performed in the Advertisement class as to not violate the
	 * SOLID dependency inversion principal.
	 * 
	 * @return a formatted String array to be used to display the Advertisement fields in the Labels
	 * of the Classifieds.
	 */
	public String[] format()
	{
		String[] temp = new String[3];
		temp[0] = this.title;
		if (this.fullTime)
			temp[1]="(Full Time)";
		else
			temp[1]="(Part Time)";
		
		temp[1] += "\n"+"("+this.phone.substring(0, 3)+") "+this.phone.substring(3,6)+"-"
		+this.phone.substring(6,10)+"\n";
		temp[2] = "Posted by "+this.contact+" on "+this.date; 
		
		return temp;
	}
}
