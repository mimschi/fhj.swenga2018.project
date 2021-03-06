package at.fh.swenga.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Activity")

public class Activity implements java.io.Serializable {

	@Id
	@Column(name = "AID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aID;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date datum;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Item item;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;

	@Column(nullable = true, length = 3)
	private int sum;
	
	@Column(nullable = true, length = 5)
	private int kalorienGesamt;
	
	public Activity() {
		// TODO Auto-generated constructor stub
	}
	
	public Activity(Date datum, Item item, User user, int sum) {
		super();
		this.datum = datum;
		this.item = item;
		this.user = user;
		this.sum = sum;
	}
	
	

	public int getKalorienGesamt() {
		return kalorienGesamt;
	}

	public void setKalorienGesamt(int kalorienGesamt) {
		this.kalorienGesamt = kalorienGesamt;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getaID() {
		return aID;
	}

	public void setaID(int aID) {
		this.aID = aID;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (aID != other.aID)
			return false;
		return true;
	}
	
	
}
