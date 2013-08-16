package com.swapnonil.springexp.partioning;

public class Record
{
	private int id;
	private String stateName;
	private String capital;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getStateName()
	{
		return stateName;
	}

	public void setStateName(String name)
	{
		this.stateName = name;
	}

	public String getCapital()
	{
		return capital;
	}

	public void setCapital(String capital)
	{
		this.capital = capital;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Record other = (Record) obj;
		if (id != other.id) return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Record [id=").append(id).append(", stateName=").append(stateName).append(", capital=")
				.append(capital).append("]");
		return builder.toString();
	}
}
