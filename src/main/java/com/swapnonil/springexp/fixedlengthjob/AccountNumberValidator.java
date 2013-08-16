package com.swapnonil.springexp.fixedlengthjob;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

public class AccountNumberValidator implements Validator<Record>
{

	public void validate(Record value) throws ValidationException
	{
		long x = value.getBankAccountId();
		if (x == 222222222220130000L)
		{
			throw new ValidationException("This account number has been blacklisted");
		}
	}
}
