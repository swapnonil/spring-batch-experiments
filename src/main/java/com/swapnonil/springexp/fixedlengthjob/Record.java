package com.swapnonil.springexp.fixedlengthjob;

public class Record
{
	private int id;
	private String name;
	private long bankAccountId;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public long getBankAccountId()
	{
		return bankAccountId;
	}
	public void setBankAccountId(long bankAccountId)
	{
		this.bankAccountId = bankAccountId;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bankAccountId ^ (bankAccountId >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Record other = (Record) obj;
		if (bankAccountId != other.bankAccountId) return false;
		if (id != other.id) return false;
		if (name == null)
		{
			if (other.name != null) return false;
		}
		else if (!name.equals(other.name)) return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Record [id=").append(id).append(", name=").append(name).append(", bankAccountId=")
				.append(bankAccountId).append("]");
		return builder.toString();
	}
	
}
