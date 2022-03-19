package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seasons")
public class Season {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seasonId;

	@Column(name = "seasonName")
	private String seasonName;

	@OneToMany(mappedBy = "season")
	private List<Lesson> lessons = new ArrayList<>();

	public Season() {
		super();
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	@Override
	public String toString() {
		return "Season [seasonId=" + seasonId + ", seasonName=" + seasonName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(seasonId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
		return seasonId == other.seasonId;
	}

}
