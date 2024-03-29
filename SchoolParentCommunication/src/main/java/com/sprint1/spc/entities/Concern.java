package com.sprint1.spc.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Concern")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Concern {

	@Id
	@SequenceGenerator(name = "ConcernIdGeneration", initialValue = 2001, allocationSize = 1)
	@GeneratedValue(generator = "ConcernIdGeneration")
	private long concernId;

	private String concernDescription;
	private boolean resolved;
	private String resolution;
	private LocalDate concernDate;
	private LocalDate resolvedDate;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "Concern_Resolver")
	private ConcernParty party;

	@ManyToOne
	private Parent affectedParty;

	@ManyToOne
	//@JsonIgnore
	private Teacher resolvedBy;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "Concern_Type")
	private ConcernType type;

	public long getConcernId() {
		return concernId;
	}

	public void setConcernId(long concernId) {
		this.concernId = concernId;
	}

	public String getConcernDescription() {
		return concernDescription;
	}

	public void setConcernDescription(String concernDescription) {
		this.concernDescription = concernDescription;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public LocalDate getConcernDate() {
		return concernDate;
	}

	public void setConcernDate(LocalDate concernDate) {
		this.concernDate = concernDate;
	}

	public LocalDate getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(LocalDate resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public Parent getAffectedParty() {
		return affectedParty;
	}

	public void setAffectedParty(Parent affectedParty) {
		this.affectedParty = affectedParty;
	}

	public User getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Teacher resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public ConcernType getType() {
		return type;
	}

	public void setType(ConcernType type) {
		this.type = type;
	}

	public ConcernParty getParty() {
		return party;
	}

	public void setParty(ConcernParty party) {
		this.party = party;
	}

	
	
	public Concern(long concernId, String concernDescription, boolean resolved, String resolution,
			LocalDate concernDate, LocalDate resolvedDate, ConcernParty party, Parent affectedParty, Teacher resolvedBy,
			ConcernType type) {
		super();
		this.concernId = concernId;
		this.concernDescription = concernDescription;
		this.resolved = resolved;
		this.resolution = resolution;
		this.concernDate = concernDate;
		this.resolvedDate = resolvedDate;
		this.party = party;
		this.affectedParty = affectedParty;
		this.resolvedBy = resolvedBy;
		this.type = type;
	}
	

	public Concern(long concernId, String concernDescription, LocalDate concernDate, ConcernParty party,
			Parent affectedParty, ConcernType type) {
		super();
		this.concernId = concernId;
		this.concernDescription = concernDescription;
		this.concernDate = concernDate;
		this.party = party;
		this.affectedParty = affectedParty;
		this.type = type;
	}
	
	public Concern(String concernDescription, LocalDate concernDate, ConcernParty party, Parent affectedParty,
			ConcernType type) {
		super();
		this.concernDescription = concernDescription;
		this.concernDate = concernDate;
		this.party = party;
		this.affectedParty = affectedParty;
		this.type = type;
	}
	
	public Concern(String concernDescription, LocalDate concernDate, Parent affectedParty,
			ConcernType type) {
		super();
		this.concernDescription = concernDescription;
		this.concernDate = concernDate;
		this.affectedParty = affectedParty;
		this.type = type;
	}
	
	public Concern(long concernId, String concernDescription, LocalDate concernDate, Parent affectedParty,
			ConcernType type) {
		super();
		this.concernId = concernId;
		this.concernDescription = concernDescription;
		this.concernDate = concernDate;
		this.affectedParty = affectedParty;
		this.type = type;
	}

	public Concern() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Concern [concernId=" + concernId + ", concernDescription=" + concernDescription + ", resolved="
				+ resolved + ", resolution=" + resolution + ", resolvedDate=" + resolvedDate + ", affectedParty="
				+ affectedParty + ", resolvedBy=" + resolvedBy + ", type=" + type + ", party=" + party + "]";
	}

}