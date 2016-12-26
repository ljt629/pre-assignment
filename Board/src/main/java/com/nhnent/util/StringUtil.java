package com.nhnent.util;

import java.util.regex.Pattern;

public class StringUtil {

	public static boolean isValidEmail(String email) {

		boolean isValidEmail = Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", email.trim());
		return isValidEmail;
	}
}
