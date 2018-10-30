package hu.food.core.entity.base;

import hu.food.core.entity.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECDATE")
	private Date recDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODDATE")
	private Date modDate;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	@PrePersist
	public void prePersist() {
		recDate = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		modDate = new Date();
	}

	public Date getRecDate() {
		return recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
