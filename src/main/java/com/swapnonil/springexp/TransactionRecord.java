package com.swapnonil.springexp;

public class TransactionRecord
{
	String manufacturingNumber, cardTransactionNumber, transactionType, transactionDateTime, drcrFlag, purseFlag,
			transactionAmount, afterCardBalance, cardIssuer, obuNumber, entrySPID, signatureVersionNumber, signature,
			cardNumber, corporateFlag, userCategory, cscCardType, entryLocation, lastRefillMachineCode,
			applicationSector, freeFormat;

	public String getManufacturingNumber()
	{
		return manufacturingNumber;
	}

	public void setManufacturingNumber(String manufacturingNumber)
	{
		this.manufacturingNumber = manufacturingNumber;
	}

	public String getCardTransactionNumber()
	{
		return cardTransactionNumber;
	}

	public void setCardTransactionNumber(String cardTransactionNumber)
	{
		this.cardTransactionNumber = cardTransactionNumber;
	}

	public String getTransactionType()
	{
		return transactionType;
	}

	public void setTransactionType(String transactionType)
	{
		this.transactionType = transactionType;
	}

	public String getTransactionDateTime()
	{
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime)
	{
		this.transactionDateTime = transactionDateTime;
	}

	public String getDrcrFlag()
	{
		return drcrFlag;
	}

	public void setDrcrFlag(String drcrFlag)
	{
		this.drcrFlag = drcrFlag;
	}

	public String getPurseFlag()
	{
		return purseFlag;
	}

	public void setPurseFlag(String purseFlag)
	{
		this.purseFlag = purseFlag;
	}

	public String getTransactionAmount()
	{
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount)
	{
		this.transactionAmount = transactionAmount;
	}

	public String getAfterCardBalance()
	{
		return afterCardBalance;
	}

	public void setAfterCardBalance(String afterCardBalance)
	{
		this.afterCardBalance = afterCardBalance;
	}

	public String getCardIssuer()
	{
		return cardIssuer;
	}

	public void setCardIssuer(String cardIssuer)
	{
		this.cardIssuer = cardIssuer;
	}

	public String getObuNumber()
	{
		return obuNumber;
	}

	public void setObuNumber(String obuNumber)
	{
		this.obuNumber = obuNumber;
	}

	public String getEntrySPID()
	{
		return entrySPID;
	}

	public void setEntrySPID(String entrySPID)
	{
		this.entrySPID = entrySPID;
	}

	public String getSignatureVersionNumber()
	{
		return signatureVersionNumber;
	}

	public void setSignatureVersionNumber(String signatureVersionNumber)
	{
		this.signatureVersionNumber = signatureVersionNumber;
	}

	public String getSignature()
	{
		return signature;
	}

	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}

	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public String getCorporateFlag()
	{
		return corporateFlag;
	}

	public void setCorporateFlag(String corporateFlag)
	{
		this.corporateFlag = corporateFlag;
	}

	public String getUserCategory()
	{
		return userCategory;
	}

	public void setUserCategory(String userCategory)
	{
		this.userCategory = userCategory;
	}

	public String getCscCardType()
	{
		return cscCardType;
	}

	public void setCscCardType(String cscCardType)
	{
		this.cscCardType = cscCardType;
	}

	public String getEntryLocation()
	{
		return entryLocation;
	}

	public void setEntryLocation(String entryLocation)
	{
		this.entryLocation = entryLocation;
	}

	public String getLastRefillMachineCode()
	{
		return lastRefillMachineCode;
	}

	public void setLastRefillMachineCode(String lastRefillMachineCode)
	{
		this.lastRefillMachineCode = lastRefillMachineCode;
	}

	public String getApplicationSector()
	{
		return applicationSector;
	}

	public void setApplicationSector(String applicationSector)
	{
		this.applicationSector = applicationSector;
	}

	public String getFreeFormat()
	{
		return freeFormat;
	}

	public void setFreeFormat(String freeFormat)
	{
		this.freeFormat = freeFormat;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionDateTime == null) ? 0 : transactionDateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		TransactionRecord other = (TransactionRecord) obj;
		if (transactionDateTime == null)
		{
			if (other.transactionDateTime != null) return false;
		}
		else if (!transactionDateTime.equals(other.transactionDateTime)) return false;
		return true;
	}	
	
}
